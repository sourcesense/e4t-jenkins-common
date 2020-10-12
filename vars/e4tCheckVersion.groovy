void call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    e4tExecute(script: """
        dep include \$DEP_SHELL_COMMON_PACKAGE \$DEP_SHELL_COMMON_VERSION projects ;\\
        check_version ;\\
    """)
}
