/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call() {
    echo "Branch: ${BRANCH_NAME}"
    echo "Project: ${PROJECT_NAME}"
    e4tDepScriptWithResult('''
        dep include EcoMind/git-common versions ;\\
        project_version ;\\
    ''')
}
