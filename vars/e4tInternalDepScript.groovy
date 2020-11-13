/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call(String script, String result) {
    sh(script: """
        /bin/bash -c ' \\
            . /app/dep-bootstrap.sh 0.4.1 ;\\
            dep define log2/shell-common:0.2.0 ;\\
            dep define EcoMind/git-common:0.2.2 ;\\
            dep define EcoMind/container-common:0.1.0 ;\\
            dep define EcoMind/k8s-common:0.1.0 ;\\
            $script
        '
    """,
    returnStdout: "$result")
}
