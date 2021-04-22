/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Main
 */

import java.io.File;
import java.io.FileNotFoundException;
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
        VectorHeap<Paciente> vectorHeap = new VectorHeap<Paciente>();

        //Se busca si existe el archivo
        try {
            File obj = new File("Pacientes.txt");
            Scanner myReader = new Scanner(obj);
            //Si existe se hace un ciclo
            while (myReader.hasNextLine()) {
                //Se realiza un contador
                String data = myReader.nextLine();//Se toma la linea de texto
                String[] dataList = data.split(", ");
                Paciente paciente = new Paciente(dataList[0], dataList[1], dataList[2]);
                vectorHeap.add(paciente);
            }   
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");//Se muestra el error
            e.printStackTrace();
            System.exit(1);//Sale del programa
        }

        System.out.println("\nBienvenido a la Emergencia del Hospital");
        	
		vectorHeap.imprimir();
    }
}
