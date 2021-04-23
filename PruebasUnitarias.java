import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PruebasUnitarias {
    
    VectorHeap<Paciente> vectorHeap = new VectorHeap<Paciente>();
    
    @Test
    public void insertarVectorHeap(){
        Paciente paciente = new Paciente("Oscar", "Dolor de cabeza", "R");
        Paciente paciente2 = new Paciente("Oscar", "Dolor de cabeza", "A");
        vectorHeap.add(paciente);
        vectorHeap.add(paciente2);

        assertEquals(paciente2, vectorHeap.remove());
    }

}
