package com.yf.modulestest;

/*
    EL modulo es una cnfiguracion que agrupa paquetes. 
    Se puede indicar dependencia entre modulos asi como permisos 
    para que ciertos paquetes sean usados SOLO x ciertos modulos
    
    NO pueden haber varios modulos que expongan el mismo paquete

    EL JDK esta organizado de esta manera desde la v9
    
    EL archivo de configuracion de los modulos se llama module-info.java y se aloja en el directorio raiz del modulo 
    Donde cuelgan los paquetes que componen el modulo
    
*/
public class ModulesTest {
    
    public void ejemplo() {        
        /*
            Ejemplos de los archivos module-info.java             
        
            module com.module1 {
                exports com.operaciones; <-- Nombre del paquete a exportar
            }
            
            module com.module2 {
                exports com.cliente; <-- Nombre del paquete a exportar
                requires com.module1; <-- paquetes requeridos
            }
        */
        
    }
    
    public void compilar() {
       /**DESDE EL DIRECTORIO RAIZ QUE CONTIENE LOS MODULOS A EJECUTAR*/ 
      
       /*
        module-path: Modulos de los que depende (Si hay varios separarlos x ;)
       */
      
      //javac --module-path DIRECTORIOS_DE_MODULOS -d DIRECTORIO_DESTINO ARCHIVOS_A_COMPILAR
      
      //javac -d myDirectorio1/ *.java <-- En este ejemplo NO se necesita module-path dato que NO hay dependencia de modulos
      //javac --module-path myDirectorio1 -d myDirectorio2 myDirectorio2/*.java
    }
    
    public void ejecutar() {
        /**DESDE EL DIRECTORIO RAIZ QUE CONTIENE LOS MODULOS A EJECUTAR*/ 
        
        /*
        module-path: Modulos de los que depende (Si hay varios separarlos x ;)
        */
        
        //java --module-path DIRECTORIOS_DE_MODULOS --module NOMBRE_MODULO/CLASE
        
        //java --module-path myDirectorio1;myDirectorio2 --module com.module2/com.cliente.TestClass
        
        //java -module-path . --module com.module2/com.cliente //en eeste ejemplo el . indica directorio actual        
       
    }
    
    public void abreviaturas() {
        /* ABREVIATURAS
           module-path: -p
           module: -m
         */

        //javac -p myDirectorio1 -d myDirectorio2 myDirectorio2/*.java
        //java -p myDirectorio1;myDirectorio2 -m com.module2/com.cliente.TestClass
    }
    
    public void empaquetar() {
        //jar -c -file=DIRECTORIO_DESTINO/NOMBRE_ARCHIVO.jar -C DIRECTORIO_MODULO .  <--DIRECTORIO_DESTINO debe existir, el . indica incluir todo el contenido del directorio
        
        /*jmod es similar a .jar pero es mas usado para librerias nativas :S.
        jmod NO puede ser usado para ejecucion de modulos*/
        //jmod create --class-path DIRECTORIOS_DE_MODULOS NOMBRE_ARCHIVO.jmod
    }
}
