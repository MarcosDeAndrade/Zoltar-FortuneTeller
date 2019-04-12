# Zelzar - Fortune Teller (Java)

---

<p align="center"><b>Zelar - Fortune Teller - Binary Trees</b><br>Software desarrollado en lenguaje JAVA, con el IDE NetBeans.</p>

---

## ***Introducción***

Zelzar es un adivinador de animales, implementa arbles binarios para poder establecer la toma de desiciones. El adivinador va aprendiendo de los desaciertos que cometa al tratar de adivinar el animal en el cual está pensando el usuario. El Zelzar realizará una serie de preguntas al usuario y en función de las respuestas que este ofrezca, generará una respuesta.
> NOTA: NO todas las funcionalidades del juego se encuentran implementadas.

## ***Instrucciones***

1. Descarga el repositorio, en el encontaras el archivo ***Zelzar-FortuneTeller***.
2. Ejecuta tu IDE deseado, se sugiere [NetBeans](https://netbeans.org/downloads/7.0/?pagelang=us).
3. Abre el archivo ***Zelzar-FortuneTeller*** anteriormente mencionado con el IDE.
4. Compila y corre el programa.
6. Sigue las instrucciones en el menu de ***Instrucciones*** para poder proceder a la corrcta utilización.

## ***Especificaciones***

Durante el servicio se requieren dos tipos de empleados:

1. **Inicio de sesión:** Con lo cual, el sistema realizará las preguntas pertinentes para intentar adivinar el animal en el cual piensa el usuario. Una vez que el sistema genere una respuesta, bien sea correcta o incorrecta, se termina la sesión.

2. **Almacenamiento de la Base de Conocimientos:** Tome en cuenta que la base de conocimientos almacenada en un árbol binario debe poder ser guardada en un archivo de texto para que lo aprendido por el Adivinador no se pierda. Cada vez que se inicia el Adivinador, se cargará desde el archivo, la información correspondiente a la base de conocimientos.

3. **Interfaz gráfica:** Implementar una interfaz gráfica de usuario.

4. **Mostrar base de conocimientos:** El sistema ofrecerá al usuario la opción de poder observar el árbol binario en el que se representa la base de conocimientos. En otras palabras, el usuario podrá ver el diagrama correspondiente al árbol. ***No esta Implemetado***.

5. **Inicialización de la base de conocimientos:** El usuario podrá borrar la base de conocimientos si así lo requiere.

## ***Ejemplo del Funcionamiento del Algoritmo***

  <p>Estás pensando en un animal? si<br>
     Es un pájaro? no<br>
     Qué animal era? ratón<br>
     Qué diferencia a un pájaro de un Ratón? vuela<br>
     Si el animal fuera un pájaro cuál sería la respuesta? si</p>
      
  <p>Estás pensando en un animal? si<br>
     Vuela? si<br>
     Es un pájaro? no<br>
     Qué animal era? aguila<br>
     Qué diferencia a un pájaro de un Aguila? caza<br>
     Si el animal fuera un pájaro cuál sería la respuesta? no</p>
      
  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Es un Ratón? no<br>
     Qué animal era? perro<br>
     Qué diferencia a un Ratón de un Perro? ladra<br>
     Si el animal fuera un Ratón cuál sería la respuesta? no</p>
     
  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Ladra? no<br>
     Es un Ratón? no<br>
     Qué animal era? rinoceronte<br>
     Qué diferencia a un Ratón de un Rinoceronte? tiene colmillos<br>
     Si el animal fuera un Ratón cuál sería la respuesta? no</p>
     
     
  <p>Estás pensando en un animal? si<br>
     Vuela? si<br>
     Caza? no<br>
     Es un pájaro? no<br>
     Qué animal era? buitre<br>
     Qué diferencia a un pájaro de un Buitre? come carroña<br>
     Si el animal fuera un pájaro cuál sería la respuesta? no</p>

  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Ladra? no<br>
     Tiene colmillos? si<br>
     Es un Rinoceronte? no<br>
     Qué animal era? elefante<br>
     Qué diferencia a un Rinoceronte de un Elefante? tienen trompa<br>
     Si el animal fuera un Rinoceronte cuál sería la respuesta? no</p>

  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Ladra? no<br>
     Tiene colmillos? si<br>
     Tienen trompa? no<br>
     Es un Rinoceronte? no<br>
     Qué animal era? jabalí<br>
     Qué diferencia a un Rinoceronte de un Jabalí? le gusta entrar al agua<br>
     Si el animal fuera un Rinoceronte cuál sería la respuesta? no</p>

  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Ladra? no<br>
     Tiene colmillos? no<br>
     Es un Ratón? no<br>
     Qué animal era? jirafa<br>
     Qué diferencia a un Ratón de un Jirafa? tiene el cuello largo<br>
     Si el animal fuera un Ratón cuál sería la respuesta? no</p>

  <p>Estás pensando en un animal? si<br>
     Vuela? si<br>
     Caza? no<br>
     Come carroña? no<br>
     Es un pájaro? no<br>
     Qué animal era? mosca<br>
     Qué diferencia a un pájaro de un Mosca? es un insecto<br>
     Si el animal fuera un pájaro cuál sería la respuesta? no</p>

  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Ladra? no<br>
     Tiene colmillos? si<br>
     Tienen trompa? no<br>
     Le gusta entrar al agua? si<br>
     Es un Rinoceronte? no<br>
     Qué animal era? hipopótamo<br>
     Qué diferencia a un Rinoceronte de un Hipopótamo? se sumerge por largo tiempo.<br>
     Si el animal fuera un Rinoceronte cuál sería la respuesta? no</p>

  <p>Estás pensando en un animal? si<br>
     Vuela? no<br>
     Ladra? no<br>
     Tiene colmillos? si<br>
     Tienen trompa? no<br>
     Le gusta entrar al agua? si<br>
     Se sumerge por largo tiempo? si<br>
     Es un Hipopótamo? si</p>
     
   **Soy el más grande!**
   
   <p align="center"><img src="https://i.ibb.co/61pfc0q/Imagen1.jpg"></p>
   
   ## ***Views***
   
   ### *Menu Principal*
   
   ![Main Menu](https://i.ibb.co/tXYRtnG/Imagen1.png)
   
   ### *Secuencia*
    
   ![Secuencia 1](https://i.ibb.co/fCv7PJQ/Imagen2.png)
   ![Secuencia 2](https://i.ibb.co/PDKBm0d/Imagen3.png)
   ![Secuencia 3](https://i.ibb.co/QbDNDgC/Imagen4.png)
   ![Secuencia 4](https://i.ibb.co/MspFD9Z/Imagen5.png)
   ![Secuencia 5](https://i.ibb.co/TrCHBfQ/Imagen6.png)
   ![Secuencia 6](https://i.ibb.co/5BTmpd0/Imagen7.png)

   ### *Creditos*

   ![Creditos](https://i.ibb.co/jrZC8vB/Imagen8.png)
   
   ## ***Creditos***

Proyecto realizado por
* [Marcos De Andrade](https://github.com/MarcosDeAndrade)
* [Samuel Boada](https://github.com/systems-multimedia).
* Alberto Pereira

## ***Licencia***

[MIT](https://github.com/MarcosDeAndrade/Zoltar-FortuneTeller/blob/master/LICENSE)

&nbsp;

<p align="center">✌️</p>
<p align="center">
<sub><sup>A project by <a href="https://github.com/MarcosDeAndrade">Marcos De Andrade</a> & <a href="https://github.com/systems-multimedia">Samuel Boada</a> & Alberto Pereira<br>Copyright (c) 2018</sup></sub></p>

