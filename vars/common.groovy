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