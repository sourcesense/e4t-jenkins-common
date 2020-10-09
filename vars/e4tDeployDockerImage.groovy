void call(String repoName, String localTag, String remoteTag, String remoteHost) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            dep include log2/shell-common 0.1.0-SNAPSHOT projects ;\\
            docker_push $repoName $localTag $remoteTag $remoteHost ;\\
        '
    """)
}
