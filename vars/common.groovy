def compile() {
   if(app_lang == "nodejs")
       sh 'npm install'
    if(app_lang == "maven")
        sh 'mvn package'
}

def testcases() {
    if(app_lang == "nodejs")
        echo 'Run unit tests'
    if(app_lang == "maven")
        echo 'Run test cases'
}

static def codequality() {
    'sonar-scanner -Dsonar.host.url=http//IP:9000 -Dsonar.login=admin -Dsonar.password=admin -Dsonar.projectkey=${component}' as java.lang.Object
}



