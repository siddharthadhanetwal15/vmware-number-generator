# vmware-number-generator
This repo contains code for Question 1-NUMBER GENERATOR

Most of the documentation can be found in Swagger UI url- http://localhost:8080/swagger-ui.html

Open the project in Intellij and Run GeneratorApplication.java

To build the project and run test cases. mvn clean install

To perform task/generate numbers, please execute this POST API, http://localhost:8080/api/generate with JSON body 
{
    "Goal":"20",
    "Step":"2"
}

Output files will be generated under project_dir/tmp/
