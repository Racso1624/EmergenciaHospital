/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Main
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

//Se crea la clase Main
public class Main {
    
    /** 
     * Pre:Se ingresan los archivos
     * @param args
     * Post:Se regresa la lista de los pacientes
     */
    //Se crea el Main
    public static void main(String[] args) {

        //Se crean instancias
        Scanner scanner = new Scanner(System.in);

        //Se crea un ciclo para las opciones
        System.out.println("\nBienvenido a la Emergencia del Hospital");
        boolean var = false;
        a: while(var == false){//Se crea el ciclo
            System.out.println("\n\nIngrese la implementacion que desea:");
            System.out.println("1) VectorHeap");
            System.out.println("2) PriorityQueue");
            System.out.println("3) Salir\n");

            try {
                
                int opcion = scanner.nextInt();//Se verifica el numero

                if(opcion == 1){//Si es VectorHeap
                    VectorHeap<Paciente> vectorHeap = new VectorHeap<Paciente>();
                    //Se busca si existe el archivo
                    try {
                        File obj = new File("Pacientes.txt");
                        Scanner myReader = new Scanner(obj);
                        //Si existe se hace un ciclo
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();//Se toma la linea de texto
                            String[] dataList = data.split(", ");//Se separa
                            Paciente paciente = new Paciente(dataList[0], dataList[1], dataList[2]);
                            vectorHeap.add(paciente);//Se ingresan los datos como paciente
                        }   
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Archivo no encontrado.");//Se muestra el error
                        e.printStackTrace();
                        System.exit(1);//Sale del programa
                    }
                    boolean var2 = false;
                    while(var2 == false){// Se crea el ciclo para imprimir pacientes

                        System.out.println("\n\nIngrese la opcion que desea:");
                        System.out.println("1) Siguiente Paciente");
                        System.out.println("2) Salir\n");

                        try {
                            
                            int opcion2 = scanner.nextInt();//Se verifica el numero

                            if(opcion2 == 1){//Si se requiere el paciente
                                if(!vectorHeap.isEmpty()){//Se verifica que el vector tenga datos
                                    System.out.println("\nEl siguiente paciente es: " + vectorHeap.remove());//Se imprime
                                }
                                else{//Si no, termina el programa
                                    System.out.println("\n\nLa lista de pacientes se ha terminado");
                                    System.out.println("Ya no quedan pacientes en espera");
                                    break a;
                                }
                            }
                            else if(opcion2 == 2){//Si se sale
                                System.out.println("Saliendo del Programa");
                                break a;//Sale del programa
                            }
                            else{
                                System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                            scanner.nextLine();//Se toma de nuevo
                        }
                    }
                        
                }
                else if(opcion == 2){//Si es PriorityQueue
                    PriorityQueue<Paciente> priorityQueue = new PriorityQueue<Paciente>();
                    //Se busca si existe el archivo
                    try {
                        File obj = new File("Pacientes.txt");
                        Scanner myReader = new Scanner(obj);
                        //Si existe se hace un ciclo
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();//Se toma la linea de texto
                            String[] dataList = data.split(", ");//Se separa
                            Paciente paciente = new Paciente(dataList[0], dataList[1], dataList[2]);
                            priorityQueue.add(paciente);//Se ingresa un nuevo paciente al queue
                        }   
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Archivo no encontrado.");//Se muestra el error
                        e.printStackTrace();
                        System.exit(1);//Sale del programa
                    }
                    boolean var2 = false;
                    while(var2 == false){//Se revisa el ciclo para los pacientes

                        System.out.println("\n\nIngrese la opcion que desea:");;
                        System.out.println("1) Siguiente Paciente");
                        System.out.println("2) Salir\n");

                        try {
                            
                            int opcion2 = scanner.nextInt();//Se verifica el numero

                            if(opcion2 == 1){//Si se requiere al paciente
                                if(!priorityQueue.isEmpty()){//Se verifica que no este vacio
                                    System.out.println("\nEl siguiente paciente es: " + priorityQueue.poll());//Se imprime 
                                }
                                else{//Si no hay nada, se termina programa
                                    System.out.println("\n\nLa lista de pacientes se ha terminado");
                                    System.out.println("Ya no quedan pacientes en espera");
                                    break a;
                                }
                            }
                            else if(opcion2 == 2){//Si no, se sale del programa
                                System.out.println("Saliendo del Programa");
                                break a;
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
                else if(opcion == 3){//Se sale del programa
                    System.out.println("Saliendo del Programa");
                    var = true;//Se termina el ciclo principal
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
