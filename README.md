# Calculator using Spring, Jetty and Docker
HomeWork 06 - Cloud Native

### CALCULATOR - DEPLOYMENT
1. To deploy the application, access its root project folder and execute: `./gradlew deploy`
2. Access `build/libs` and copy the `.war` file

### DOCKER
3. In order to build calculator's image on docker, it's necessary to access the Tema-06 or Calculator's root directory (where Dockerfile is located) and then run: 
`docker build -t calculator .`
4. Since the image is built, run: `sudo docker run -p 8080:8080 calculator`
5. Now, all you need to do is start the server and access [localhost:8080/calculator/](http://localhost:8080/calculator/) 
6. To exit, just press `CTRL + C`

### CALCULATOR WEBAPP 
* The math operations supported by the calculator are:
  * sum
  * sub
  * mul
  * div
  * exp
* To execute an operation, follow the pattern below:
  * Example a: 9/3
  * `localhost:8080/calculator/?op=div&firstTerm=9&secondTerm=3` 
  * Example b: 6-7
  * `localhost:8080/calculator/?op=sub&firstTerm=6&secondTerm=7` 
* To access calculator logs, just enter:
  * `localhost:8080/calculator/?logs` 
