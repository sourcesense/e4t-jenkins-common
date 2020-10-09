void call() {
    sh '''
        . /app/dep-bootstrap.sh init
        . /app/dep-bootstrap.sh
        depPackage=log2/shell-common
        depVersion=0.1.0-SNAPSHOT
        dep include $depPackage $depVersion log
        log "ciao"
    '''
}
