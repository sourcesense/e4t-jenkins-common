/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call(String repoName, String localTag, String remoteHost) {
    e4tDepScript("""
        dep include EcoMind/git-common versions ;\\
        dep include EcoMind/container-common containers ;\\
        branch=\$(git_branch) ;\\
        if [[ $localTag == *-EXP-SNAPSHOT* ]]; then \\
            localTag=$localTag ;\\
            version=\${localTag%-EXP-SNAPSHOT*} ;\\
            commitId=\${localTag#*SNAPSHOT-} ;\\
            shortCommitId=\${commitId:0:6} ;\\
            timeStamp=\$(date '+%Y%m%d%H%M%S') ;\\
        fi ;\\
        case "\$branch" in \\
            master | main) \\
                if [[ $localTag == *-EXP-SNAPSHOT* ]]; then \\
                    remoteTag="\$branch-\$version-EXP-SNAPSHOT-\$shortCommitId-\$timeStamp" ;\\
                else \\
                    remoteTag=$localTag ;\\
                fi ;\\
                ;; \\
            release/*) \\
                if [[ $localTag == *-EXP-SNAPSHOT* ]]; then \\
                    release=\${branch#release/} ;\\
                    remoteTag="release-\$release-\$version-EXP-SNAPSHOT-\$shortCommitId-\$timeStamp" ;\\
                elif [[ $localTag == *SNAPSHOT* ]]; then \\
                    echo "skipping docker image deploy (version=$localTag)" ;\\
                else \\
                    remoteTag=$localTag ;\\
                fi ;\\
                ;; \\
            hotfix/*) \\
                if [[ $localTag == *-EXP-SNAPSHOT* ]]; then \\
                    hotfix=\${branch#hotfix/} ;\\
                    remoteTag="hotfix-\$hotfix-\$version-EXP-SNAPSHOT-\$shortCommitId-\$timeStamp" ;\\
                elif [[ $localTag == *SNAPSHOT* ]]; then \\
                    echo "skipping docker image deploy (version=$localTag)" ;\\
                else \\
                    remoteTag=$localTag ;\\
                fi ;\\
                ;; \\
            develop) \\
                if [[ $localTag != *SNAPSHOT* ]]; then \\
                    echo "wrong develop tag detected, skipping (version=$localTag)" ;\\
                else \\
                    localTag=$localTag ;\\
                    version=\${localTag%-SNAPSHOT*} ;\\
                    commitId=\${localTag#*SNAPSHOT-} ;\\
                    shortCommitId=\${commitId:0:6} ;\\
                    timeStamp=\$(date '+%Y%m%d%H%M%S') ;\\
                    remoteTag="develop-\$version-SNAPSHOT-\$shortCommitId-\$timeStamp" ;\\
                fi ;\\
                ;; \\
            feature/*) \\
                if [[ $localTag == *-EXP-SNAPSHOT* ]]; then \\
                    feature=\${branch#feature/} ;\\
                    remoteTag="feature-\$feature-\$version-EXP-SNAPSHOT-\$shortCommitId-\$timeStamp" ;\\
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
