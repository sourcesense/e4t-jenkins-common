void call() {
    checkout scm
    echo "Current branch is: ${BRANCH_NAME}"
    echo "Project name: ${PROJECT_NAME}"
}
