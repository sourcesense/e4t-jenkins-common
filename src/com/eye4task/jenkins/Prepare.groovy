package com.eye4task.jenkins

class Prepare implements Serializable {

    def steps
    Prepare(steps) { this.steps = steps }

    def mvn(args) {
        echo 'Hello'
        steps.sh "${steps.tool 'Maven'}/bin/mvn -v"
    }

}
