void call(String script) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            DEP_SHELL_COMMON_PACKAGE="log2/shell-common" ;\\
            DEP_SHELL_COMMON_VERSION="0.1.0-SNAPSHOT" ;\\
            $script
        '
    """)
}
