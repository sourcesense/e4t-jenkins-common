void call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    e4tDepScript("""
        dep include ${e4tDepScript.shellCommon} projects ;\\
        check_version ;\\
    """)
}
