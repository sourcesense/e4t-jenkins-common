void call() {
    sh(script: '''
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            dep include log2/shell-common 0.1.0-SNAPSHOT projects ;\\
            check_version ;\\
        '
    ''')
}
