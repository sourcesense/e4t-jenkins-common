void call(String repoName, String localTag, String remoteTag, String remoteHost) {
    e4tExecute(script: """
        dep include \$DEP_SHELL_COMMON_PACKAGE \$DEP_SHELL_COMMON_VERSION projects ;\\
        docker_push $repoName $localTag $remoteTag $remoteHost ;\\
    """)
}
