void call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    sh(script: '''
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            dep include log2/shell-common 0.1.0-SNAPSHOT projects ;\\
            check_version ;\\
        '
    ''')
}
