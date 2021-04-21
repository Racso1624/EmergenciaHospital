public class Paciente implements Comparable<Paciente> {
    
    private String nombre;
    private String sintoma;
    private String prioridad;
    private int numeroPrioridad;


    public Paciente(String nombre, String sintoma, String prioridad){
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;

        char prioridadChar = prioridad.charAt(0);
        int prioridadAscii = (int)prioridadChar;
        numeroPrioridad = prioridadAscii - 64;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getSintoma() {
        return sintoma;
    }

    public int getNumeroPrioridad() {
        return numeroPrioridad;
    }

    @Override
    public int compareTo(Paciente o) {
        return (this.numeroPrioridad - o.getNumeroPrioridad());
    }

}
