void call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    e4tDepScript('''
        dep include log2/shell-common:0.1.0-SNAPSHOT projects ;\\
        check_version ;\\
    ''')
}
