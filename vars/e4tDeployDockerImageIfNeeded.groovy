void call(String repoName, String localTag, String remoteHost) {
    e4tDepScript("""
        dep include log2/shell-common:0.1.0-SNAPSHOT projects ;\\
        branch=\$(git_branch) ;\\
        version=\$(project_version) ;\\
        case "\$branch" in \\
            master) \\
                remoteTag=\$version ;\\
                ;; \\
            *-rc*) \\
                remoteTag="qa-\$version" ;\\
                ;; \\
            develop) \\
                commitId=\$(git_commit) ;\\
                remoteTag="lab-\$version-\$commitId" ;\\
                ;; \\
            *) \\
                echo "skipping docker image deploy (branch=\$branch)" ;\\
                ;;
        esac ;\\
        if [ -n "\$remoteTag" ]; then \\
            docker_push $repoName $localTag \$remoteTag $remoteHost ;\\
        fi ;\\
    """)
}
