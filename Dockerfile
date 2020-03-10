FROM jetty
ADD build/libs/calculator.war /var/lib/jetty/webapps/calculator.war
EXPOSE 8080