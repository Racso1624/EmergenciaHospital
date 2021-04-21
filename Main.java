/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Main
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Se crea la clase Main
public class Main {
    
    /** 
     * Pre:Se ingresan los archivos
     * @param args
     * Post:Se regresa la traduccion
     */
    //Se crea el Main
    public static void main(String[] args) {

        //Se instancian las variables y clases
        Scanner scanner = new Scanner(System.in);
        int cantidadPacientes = 0;

        //Se busca si existe el archivo
        try {
            File obj = new File("Pacientes.txt");
            Scanner myReader = new Scanner(obj);
            int contador = 0;
            //Si existe se hace un ciclo
            while (myReader.hasNextLine()) {
                //Se realiza un contador
                contador++;
                String data = myReader.nextLine();//Se toma la linea de texto
                String[] datasplit = data.split(",");//Se hace el split del texto
            }
            cantidadPacientes = contador;//Se toma la cantidad de palabras a verificar traducidas
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");//Se muestra el error
            e.printStackTrace();
            System.exit(1);//Sale del programa
        }

        System.out.println("\nBienvenido al Traductor");
        	
		boolean var = false;
        a: while(var == false){//Se realiza el ciclo principal

            //Se inician variables para el idioma y la frase
     
            boolean var2 = false;
            while(var2 == false){
                System.out.println("\n\nIngrese la traduccion que desea:");
                System.out.println("1) Ingles");
                System.out.println("2) Español");
                System.out.println("3) Francés");
                System.out.println("4) Salir\n");

                try {
                    
                    int opcion = scanner.nextInt();//Se verifica el numero

                    if(opcion == 1){//Si es Ingles

                    }
                    else if(opcion == 2){//Si es Español

                    }
                    else if(opcion == 3){//Si es Francés

                    }
                    else if(opcion == 4){
                        System.out.println("Saliendo del Programa");
                        break a;//Se termina el ciclo principal
                    }
                    else{
                        System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    scanner.nextLine();
                }
            }

        }    
    }
}
