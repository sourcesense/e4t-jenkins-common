void call(String baseDir='.', String reportFileName='checkstyle-report.xml') {
    e4tExecute("""
        dep include \$DEP_SHELL_COMMON_PACKAGE \$DEP_SHELL_COMMON_VERSION check ;\\
        check_shell_scripts $baseDir $reportFileName ;\\
    """)
}
