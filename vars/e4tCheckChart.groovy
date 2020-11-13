/* groovylint-disable MethodReturnTypeRequired, NoDef */

def call(String sampleValues='sampleValues/sample.yaml', String baseDir='chart') {
    e4tDepScript("""
        dep include EcoMind/k8s-common helm ;\\
        chart_check $sampleValues $baseDir ;\\
    """)
}
