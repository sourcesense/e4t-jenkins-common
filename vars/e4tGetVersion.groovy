/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call() {
    echo "Branch: ${env.BRANCH_NAME}"
    echo "Project: ${env.PROJECT_NAME}"
    e4tDepScriptWithResult('''
        dep include EcoMind/git-common versions ;\\
        project_version ;\\
    ''')
}
