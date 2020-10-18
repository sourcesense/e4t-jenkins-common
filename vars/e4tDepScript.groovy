void call(String script) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh 0.3.0 ;\\
            $script
        '
    """)
}

@groovy.transform.Field
String shellCommon = 'log2/shell-common:0.1.0'
