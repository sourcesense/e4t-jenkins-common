void call(String baseDir='.', String reportFileName='checkstyle-report.xml') {
    e4tDepScript("""
        dep include ${e4tDepSccript.shellCommon} check ;\\
        check_shell_scripts $baseDir $reportFileName ;\\
    """)
}
