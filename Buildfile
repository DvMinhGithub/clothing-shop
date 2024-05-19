pipeline {
    agent any
    environment {
        SSH_HOST = '178.128.24.181'
        SSH_USER = 'minh'
    }
    stages {
        stage('Deploy Spring Boot ') {
            steps {
                script {
                     withCredentials([string(credentialsId: 'token-tele', variable: 'TOKEN'), string(credentialsId: 'tele-id', variable: 'CHAT_ID')]) {
                        sh ' curl -s -X POST https://api.telegram.org/bot"$TOKEN"/sendMessage -d chat_id="$CHAT_ID" -d text="🏀 Start build Tech Store " '
                     }
                    echo 'Connecting to server...'
                    sh """ssh ${SSH_USER}@${SSH_HOST} << 'END'
                    cd /home/loi/techStore
                    git stash
                    git pull git@gitlab.com:loi65732102/techStore.git
                    chmod +x build.sh
                    ./build.sh
                    END
                    """
                }
            }
            post {
                success {
                    script {
                         withCredentials([string(credentialsId: 'token-tele', variable: 'TOKEN'), string(credentialsId: 'tele-id', variable: 'CHAT_ID')]) {
                            sh ' curl -s -X POST https://api.telegram.org/bot"$TOKEN"/sendMessage -d chat_id="$CHAT_ID" -d text="✔️ Build Tech Store success" '
                         }
                    }
                }
                failure {
                    script {
                         withCredentials([string(credentialsId: 'token-tele', variable: 'TOKEN'), string(credentialsId: 'tele-id', variable: 'CHAT_ID')]) {
                            sh ' curl -s -X POST https://api.telegram.org/bot"$TOKEN"/sendMessage -d chat_id="$CHAT_ID" -d text="❌ Build Tech Store failure" '
                         }
                    }
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
