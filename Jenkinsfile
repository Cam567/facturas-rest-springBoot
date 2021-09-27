pipeline{
    agent any
    stages{
        stage("Descargar codigo de la aplicacion"){
            steps{
                git ""
            }
        }
        stage("Compilar y empaquetar el proyecto"){
            steps{
                script{
                    if(isUnix()){
                        sh "mvn clean package"
                    }else{
                        bat "mvn clean package"
                    }
                }
            }
        }
        stage("Creación de imagen"){
            steps{
                script{
                    if(isUnix()){
                        sh "docker build -t camila-formacion/app-java ."
                    }
                    else{
                        bat "docker build -t camila-formacion/app-java ."
                    }
                }
            }
        }

       stage("Ejecución de contenedor"){
           steps {
               script{
                   if(isUnix()){
                       sh "docker run -d --name app-java -p 8081:8080 camila-formacion/app-java"
                   }else{
                       bat "docker run -d --name app-java -p 8081:8080 camila-formacion/app-java"       
                   }
               }    
           }
        }
        stage(""){}

        stage("Cerrar recursos"){
           steps {
                script{
                    if(isUnix()){
                        sh "docker stop app-java"
                        sh "docker container rm app-java" 
                        sh "docker image rm camila-formacion/app-java"
                    }
                    else{
                        bat "docker stop app-java"
                        bat "docker container rm app-java" 
                        bat "docker image rm camila-formacion/app-java"
                    }
                }
            }            
        }
    }
}