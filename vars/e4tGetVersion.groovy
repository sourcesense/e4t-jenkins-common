void call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    e4tDepScript("""
        dep include EcoMind/git-common versions ;\\
        project_version ;\\
    """)
}
