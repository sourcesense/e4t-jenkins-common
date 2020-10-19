void call(String script) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh 0.4.1 ;\\
            dep define log2/shell-common:0.2.0 ;\\
            dep define EcoMind/git-common:0.1.0 ;\\
            dep define EcoMind/container-common:0.1.0 ;\\
            $script
        '
    """)
}
