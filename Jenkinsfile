pipeline {
    agent any
    stages {
        stage('Run tests') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
    post {
           always {
            publishHTML target: [
                  allowMissing: true,
                  alwaysLinkToLastBuild: false,
                  keepAll: true,
                  reportDir: 'Reports/HTMLReports',
                  reportFiles: 'cucumber_test_report.html',
                  reportName: 'Cucumber Test Report'
                ]
            publishHTML target: [
                              allowMissing: true,
                              alwaysLinkToLastBuild: false,
                              keepAll: true,
                              reportDir: 'Reports/HTMLReports',
                              reportFiles: 'extent_test_report.html',
                              reportName: 'Extent Test Report'
                            ]
            emailext body: 'This a test email using Jenkins Email Extension!', subject: 'Jenkins SMTP Test Email', to: 'alfredo_natividad@yahoo.com'
           }
    }
}