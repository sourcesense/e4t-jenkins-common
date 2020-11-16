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
                remoteTag=qa-$localTag ;\\
                ;; \\
            develop) \\
                remoteTag=lab-$localTag ;\\
                ;; \\
            *) \\
                echo "skipping docker image deploy (branch=\$branch)" ;\\
                ;;
        esac ;\\
        if [ -n "\$remoteTag" ]; then \\
            docker_push "$repoName" "$localTag" "\$remoteTag" "$remoteHost" ;\\
        fi ;\\
    """)
}
