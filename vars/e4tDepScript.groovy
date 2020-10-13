void call(String script) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh ;\\
            $script
        '
    """)
}

@groovy.transform.Field
String shellCommon = 'log2/shell-common:0.1.0-SNAPSHOT'
