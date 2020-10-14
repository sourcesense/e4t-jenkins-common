void call(String repoName, String localTag, String remoteHost) {
    e4tDepScript("""
        dep include ${e4tDepScript.shellCommon} projects ;\\
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
                remoteTag="lab-\$version" ;\\
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
