def call() {
    if(env.sonar_extra_opts) {
        sonar_extra_opts = ""
    }
    pipeline {
        agent any

        stages {
            stage ('compile/build') {
                steps {
                    scripts {
                        common.compile()
                    }

                }
            }
            stage ('test cases') {
                steps {
                    scripts {
                        common.testcases()
                    }

                }
            }
            stage ('code quality') {
                steps {
                    scripts {
                        common.codequality()

                    }

                }
            }
        }
    }

}

post {
    failure {
        mail body: "<h1>${component} - Pipeline Failed \n ${BUILD_URL}</h1>", from: 'satyadineshk328@gmail.com', subject: "${component} - Pipeline Failed", to: 'satyadineshk328@gmail.com',  mimeType: 'text/html'

    }
}