# chatbot
Creacion de un proyecto de chatbot de telegram, la cual se interactua con el bot con la finalidad de emitir certificados laborales,
el bot crea menu segun lo que se reciba de la escritura por parte del usuario, esta escritura estan vinculadas con un endpoint
que los recibe para obtener la data y poder responder
<ul>
<br>#Versiones
  <br><li>Spring boot: 3.0.5 </li>
  <br><li>Java: 17</li>
 </ul>
<ul>
<br>#instalacion de mvn
<br><li>instalacion de paquetes</li>
  <br>mvn install
<br><li>encapsulacion de paquetes</li>
  <br>mvn packages
</ul>
<ul>
  <br>#instalacion de docker
  <li>1.- docker build -t chatbot .</li>
  <li>2.- docker run --network host <nombre de la imagen></li>
</ul>
<br>variables de entornos se encuentra en el application.yml
