pipeline {
    agent any
    parameters {
        choice(name: 'AGENT_NODE', choices: ['any'], description: 'Seleccionar NODO')
        choice(name: 'ENV', choices: ['dev', 'uat'], description: 'Selecionar ambiente')
    }
    stages {
        stage('Test automation'){
            steps{
                git branch:"main", url: 'https://github.com/cesaralcantarav/serenity-screenplay-training'
                script{
                    try{
                        withMaven(maven: 'maven3.8.5'){
                            if(isUnix()){
                               sh "mvn clean verify"
                            }
                             else{
                                bat "mvn clean verify"
                             }
                        }

                    } finally{
                          publishReport();
                    }
                }
            }
        }
    }
}
    def publishReport(){
        publishHTML(target: [
            reportName : 'Serenity',
            reportDir:   'target/site/serenity',
            reportFiles: 'index.html',
            keepAll:     true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])
    }