/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call(String repoName, String localTag, String remoteHost) {
    e4tDepScript("""
        dep include EcoMind/git-common versions ;\\
        dep include EcoMind/container-common containers ;\\
        branch=\$(git_branch) ;\\
        case "\$branch" in \\
            master | main) \\
                remoteTag=$localTag ;\\
                ;; \\
            release/* | hotfix/*) \\
                if [[ $localTag == *SNAPSHOT* ]]; then \\
                    echo "skipping docker image deploy (version=$localTag)" ;\\
                else \\
                    remoteTag=qa-$localTag ;\\
                fi ;\\
                ;; \\
            develop) \\
                remoteTag=lab-$localTag ;\\
                ;; \\
            feature/*) \\
                if [[ $localTag == *-ext-SNAPSHOT* ]]; then \\
                    t0=$localTag
                    t1=\${t0%-ext-SNAPSHOT*}
                    t2=\${branch#feature/}
                    t3=\${t0#*SNAPSHOT-}
                    remoteTag="ext-\$t1-\$t2-SNAPSHOT-\$t3" ;\\
                else \\
                    echo "skipping docker image deploy (version=$localTag)" ;\\
                fi ;\\
                ;; \\
            *) \\
                echo "skipping docker image deploy (branch=\$branch)" ;\\
                ;; \\
        esac ;\\
        if [ -n "\$remoteTag" ]; then \\
            docker_push "$repoName" "$localTag" "\$remoteTag" "$remoteHost" ;\\
        fi ;\\
    """)
}
