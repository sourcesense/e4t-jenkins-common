void call(String baseDir='.', String reportFileName='checkstyle-report.xml') {
    e4tDepScript("""
        dep include ${e4tDepShellCommon.name} ${e4tDepShellCommon.version} check ;\\
        check_shell_scripts $baseDir $reportFileName ;\\
    """)
}
