void call(String repoName, String localTag, String remoteHost) {
    e4tExecute("""
        dep include \$DEP_SHELL_COMMON_PACKAGE \$DEP_SHELL_COMMON_VERSION projects ;\\
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
        if [ -z "\$remoteTag" ]; then \\
            docker_push $repoName $localTag \$remoteTag $remoteHost ;\\
        fi ;\\
    """)
}
