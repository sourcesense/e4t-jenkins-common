def call(steps) {
    echo 'Hello2'
    steps.sh "${steps.tool 'Maven'}/bin/mvn -v"
}
