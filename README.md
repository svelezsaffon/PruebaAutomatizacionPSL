# PruebaAutomatizacionPSL

Esta prueba consta de automatizar varias páginas donde que tiene formularios donde el usuario ingresa la información

#Casos de prueba

1)	El usuario pueda añadir satisfactoriamente un paciente

2)	El usuario pueda añadir satisfactoriamente un doctor

3) El usuario pueda agendar satisfactoriamente una cita

4) El usuario no pueda añadir un paciente que ya existe

5) El usuario no pueda añadir un doctor que ya existe

#Ejecución

Para ejecutar las pruebas utilizar el siguiente comando mvn test

#Configuración

Para hacer pruebas con diferentes browsers se debe cambiar la siguiente instrucción por el navegador deseado, actualmente solo acepta firefox y chrome, pero facilmente se podria utilizar otros.

public static BrowserFactory.BROWSER_TYPE BROWSER=BrowserFactory.BROWSER_TYPE.FIRE_FOX;


