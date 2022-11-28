pipeline {
    agent any
    parameters {
        choice(name: 'AGENT_NODE', choices: ['any'], description: 'Seleccionar NODO')
        choice(name: 'ENV', choices: ['dev', 'uat'], description: 'Selecionar ambiente')
        string(name: 'SCENARIO_TAG', trim: false, description: 'Tag a ejecutar')
    }
    stages {
        stage('Test automation'){
            steps{
                script{
                    try{
                        withMaven(maven: 'maven3.8.5'){
                            if(isUnix()){
                               echo "Ejecutando tag: $params.SCENARIO_TAG"
                               sh "mvn clean verify -Dcucumber.filter.tags=%SCENARIO_TAG%"
                            }
                             else{
                                echo "Ejecutando tag: $params.SCENARIO_TAG"
                                bat "mvn clean verify -Dcucumber.filter.tags=%SCENARIO_TAG%"
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
            reportName : 'Serenity Report',
            reportDir:   'target/site/serenity',
            reportFiles: 'index.html',
            keepAll:     true,
            alwaysLinkToLastBuild: true,
            allowMissing: false
        ])
    }