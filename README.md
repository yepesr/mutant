# mutant
Prueba para mercado libre



La aplicación utiliza una base de  datos en mongodb, para arrancar la aplicación se utiliza docker compose que levanta la base de datos y luego sube el servicio 

docker-compose up

Ejecutar Test
./mvnw test -Dtest="com.ml.mutant.**"


Url de prueba 

http://docum-LoadB-1AWTSZYVOIY48-82ec282e3f4a4458.elb.us-east-1.amazonaws.com:8080/mutant/

http://docum-LoadB-1AWTSZYVOIY48-82ec282e3f4a4458.elb.us-east-1.amazonaws.com:8080/stats/