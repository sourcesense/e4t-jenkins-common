void call() {
    checkout scm
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
}
