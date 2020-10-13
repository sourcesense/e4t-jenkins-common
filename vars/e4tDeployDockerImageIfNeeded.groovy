void call(String repoName, String localTag, String remoteHost) {
    e4tDepScript("""
        dep include ${e4tDepSccript.shellCommon} projects ;\\
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
