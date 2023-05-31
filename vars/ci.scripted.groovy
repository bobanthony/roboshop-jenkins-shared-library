def call() {
    node('workstation')



    try {
        stage('checkout') {
            cleanws()
        }



        if (env.BRANCH_NAME != 'main') {
            stage('compile/build') {
                common.compile
        }

        }

        stage('test cases') {
            common.testcases
        }

        stage('code quality') {
            common.codequality
        }

    }  catch (e) {


    }




}

