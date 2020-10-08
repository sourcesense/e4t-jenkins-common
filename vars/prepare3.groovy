def call(String name) {
    echo "Hello3, ${name}."
    steps.sh "${steps.tool 'Maven'}/bin/mvn -v"
}
