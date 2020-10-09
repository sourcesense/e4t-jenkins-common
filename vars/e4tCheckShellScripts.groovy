void call(String baseDir='.', String reportFileName='checkstyle-report.xml') {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            dep include log2/shell-common 0.1.0-SNAPSHOT check ;\\
            check_shell_scripts $baseDir $reportFileName ;\\
        '
    """)
}
