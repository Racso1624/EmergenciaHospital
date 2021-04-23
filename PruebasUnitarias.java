/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Pruebas Unitarias
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class PruebasUnitarias {
    
    //Se crean las instancias
    VectorHeap<Paciente> vectorHeap = new VectorHeap<Paciente>();
    PriorityQueue<Paciente> queue = new PriorityQueue<Paciente>();
    
    @Test
    public void insertaryremoverVectorHeap(){
        //Se crean los pacientes
        Paciente paciente = new Paciente("Oscar", "Dolor de cabeza", "R");
        Paciente paciente2 = new Paciente("Oscar", "Dolor de cabeza", "A");
        //Se agregan los pacientes
        vectorHeap.add(paciente);
        vectorHeap.add(paciente2);

        //Se realiza la comparacion por el assertEquals
        assertEquals(paciente2, vectorHeap.remove());
    }

    @Test
    public void insertaryremoverPriorityQueue(){
        //Se crean los pacientes
        Paciente paciente = new Paciente("Oscar", "Dolor de cabeza", "R");
        Paciente paciente2 = new Paciente("Oscar", "Dolor de cabeza", "A");
        //Se agregan los pacientes
        queue.add(paciente);
        queue.add(paciente2);

        //Se realiza la comparacion por el assertEquals
        assertEquals(paciente2, queue.poll());
    }

}
