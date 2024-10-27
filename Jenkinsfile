pipeline{
    agent any



    stages {


        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/main']],
			extensions: [],
			userRemoteConfigs: [[url: 'https://github.com/abdelkaderdaghrour/g.git']]])
            }
        }


       stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  "

            }
        }



        stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }



         stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }



/*
                 stage('Code Quality Check via SonarQube') {
                   steps{

       sh " mvn clean verify sonar:sonar -Dsonar.projectKey=devops -Dsonar.projectName='devops' -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.token=sqp_713eaa9aaa061933c23aa01153a14472a47337cd"
                   }
                 }

*/

                stage('Publish to Nexus') {
                   steps {



         sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=achat -Dversion=1.2 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.33.10:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.2.jar'



                   }
               }

 stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t g2rdaghrour/devops:back .'
                          }
                      }
                  }

                  stage('login dockerhub') {
                                        steps {

				sh 'docker login -u g2rdaghrour --password dckr_pat_4vQWPShBxeWzU-clJXVmnV71h6E'
                                            }
		  }

	                      stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push g2rdaghrour/devops:back'
                                            }
		  }



stage('clone frontend'){
         steps{
             script{
                  checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abdelkaderdaghrour/g.git']]])

             }
         }

 }





	    stage('Build Frontend Docker Image') {
                      steps {
                          script {
                             sh 'docker login -u g2rdaghrour --password dckr_pat_4vQWPShBxeWzU-clJXVmnV71h6E'
                            sh 'docker build -t g2rdaghrour/devops:front .'
                          }
                      }
                  }

 stage("Push Frontend Docker image") {


            steps {
                script {

             sh 'docker login -u g2rdaghrour --password dckr_pat_4vQWPShBxeWzU-clJXVmnV71h6E'

             sh "docker push g2rdaghrour/devops:front"

                }
            }




            }


		   stage('Run Spring && MySQL Containers yes') {
               steps {
                   script {
                       sh 'docker-compose up --remove-orphans'

                   }
               }
           }


	    



     
}


                        

    

}
       
