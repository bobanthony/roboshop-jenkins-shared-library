def call() {
    pipeline {
        agent any

        stages {
            stage ('compile/build') {
                steps {
                   common.compile()
                }
            }
            stage ('test cases') {
                steps {
                   common.testcases()
                }
            }
            stage ('code quality') {
                steps {
                    common.codequality()
                }
            }
        }
    }

}