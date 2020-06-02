pipeline {
	agent any

	tools {
	  maven "Maven3"
	}

	stages {
		stage ('Prepare') {
			steps {
				// Clone git
				git 'https://github.com/StepanMelnik/HelloSpringFramework.git'
				
				// Init properties
				sh "rm -f datasource.properties> /dev/null"
				sh "echo spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver >> datasource.properties"
				sh "echo spring.datasource.url=jdbc:sqlserver://repository.sme.com\\;databaseName=SpringTestCust >> datasource.properties"
				sh "echo spring.datasource.username=sa >> datasource.properties"
				sh "echo spring.datasource.password=stepanathome1 >> datasource.properties"
				sh "echo spring.jpa.show-sql=true >> datasource.properties"
				
				sh "cp datasource.properties hello-spring-framework-mvc/src/main/resources/datasource.properties"
			}          
		}
		stage('Build') {
		    steps {
		        withMaven(globalMavenSettingsConfig: 'b08fcc34-34b9-4e53-ba93-898a88c8fb20', jdk: 'JDK8u221', maven: 'Maven3'){
		            sh "mvn --version"
		            
		            // Cobertura
		            sh "mvn clean cobertura:cobertura -Dcobertura.report.format=xml"
		            
		            // Package
		            sh 'mvn package -DskipTests=true -Dcheckstyle.skip=true'
		        }
		    }
		}
		stage('Test') {
		    steps {
		        withMaven(globalMavenSettingsConfig: 'b08fcc34-34b9-4e53-ba93-898a88c8fb20', jdk: 'JDK8u221', maven: 'Maven3'){
		            sh "mvn test -Dmaven.test.failure.ignore=true -Dcheckstyle.skip=true -B -X"
		        }
		    }
		    post {
		        success {
		            junit healthScaleFactor: 0.0, testResults: '**/target/surefire-reports/*.xml' 
		        }
		    }
		}
        stage('Code analyzing') {
            steps {
                withMaven(globalMavenSettingsConfig: 'b08fcc34-34b9-4e53-ba93-898a88c8fb20', jdk: 'JDK8u221', maven: 'Maven3'){
                    sh "mvn test checkstyle:checkstyle@checkstyle-main-report checkstyle:checkstyle@checkstyle-test-report -B -X"
                }
            }
            post {
                always {
                    checkstyle canRunOnFailed: true, unstableTotalAll: '0', pattern: '**/target/checkstyle-result-*.xml'
                }
            }
        }
        stage('Release') {
            when {
                environment name: 'IS_VERSION_TAG', value: 'true'
            }
            steps {
                withMaven(globalMavenSettingsConfig: 'b08fcc34-34b9-4e53-ba93-898a88c8fb20', jdk: 'JDK8u221', maven: 'Maven3'){
                    sh "mvn deploy -DskipTests -Dcheckstyle.skip -B -X"
                }
            }
        }
	}
	post {
	    success {
	       junit '**/target/surefire-reports/TEST-*.xml'
	       archiveArtifacts '**/target/*.jar'
	       cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', sourceEncoding: 'ASCII', zoomCoverageChart: false
	    }
	}
}