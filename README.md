# Instructions to run the project
###You will need Java 11 and docker to run this project

##Via Docker:
1. cd XmlConsumer/
2. mvn clean install
3. docker build .
4. docker images  (copy the image_id of image created from step 2 cmd and run below cmd)
5. docker tag "image_id_from_step_4" docker/rest-iapps-backend:latest
6. docker-compose up
7. docker-compose down

##Via Code:
1. Open XmlConsumerApplication.java file and run  its main method

##Testing via Postman:
1. Open Postman
2. Import collection from directory XmlConsumer/Postman_collection/iApps-task.postman_collection.json
3. You can play with this after running the project.