void call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    e4tDepScript("""
        dep include ${e4tDepShellCommon.name} ${e4tDepShellCommon.version} projects ;\\
        check_version ;\\
    """)
}
