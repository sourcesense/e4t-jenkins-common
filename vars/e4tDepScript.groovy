void call(String script) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            $script
        '
    """)
}
