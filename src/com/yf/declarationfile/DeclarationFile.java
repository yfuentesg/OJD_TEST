/*Los comentarios son opcionales. Y pueden ir en cualquier linea del codigo*/

/*EL package es opcional. Pero de haberlo sera la primera linea(SIn tener en cuenta comentarios)*/
package com.yf.declarationfile;

/*Los imports son Opcionales. SI los hay deben ir despues del package (SI hay)*/
import com.yf.identifiers.*;

/*Puden haber varias clases en un archivo pero maximo una como publica*/
/*De haber una clase publica en el archivo. Dicho archivo DEBE llamarse igual que dicha clase publica*/
public class DeclarationFile {
    
    public void doStuffs() {
        /*The ONLY non-access modifier allowed*/
        final int a = 4;
        System.out.println("Message");
    }
    
    public static void main(String[] args) {
        DeclarationFile f = new DeclarationFile();
        f.doStuffs();
    }
    
}
