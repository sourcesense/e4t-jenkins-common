/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call(String baseDir='.', String reportFileName='checkstyle-report.xml') {
    e4tDepScript("""
        dep include log2/shell-common check ;\\
        check_shell_scripts $baseDir $reportFileName ;\\
    """)
}
