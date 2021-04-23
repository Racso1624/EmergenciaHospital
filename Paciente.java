//Se crea la clase Paciente
public class Paciente implements Comparable<Paciente> {
    
    //Se cren las propiedades 
    private String nombre;
    private String sintoma;
    private String prioridad;
    private int numeroPrioridad;

    //Se crea el constructor
    public Paciente(String nombre, String sintoma, String prioridad){
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
        //Se realiza la comversion de string a numero
        char prioridadChar = prioridad.charAt(0);
        int prioridadAscii = (int)(prioridadChar);
        this.numeroPrioridad = prioridadAscii - 64;
        System.out.println(numeroPrioridad);
    }

    
    /** 
     * pre: se tiene el nombre
     * @return String es el nombre del paciente
     */
    //Regresa el nombre
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * pre: se tiene la prioridad
     * @return String es la prioridad
     */
    //Regresa la prioridad
    public String getPrioridad() {
        return prioridad;
    }

    
    /** 
     * pre: se tiene el sintoma
     * @return String regresa el sintoma
     */
    //Regresa el sintoma
    public String getSintoma() {
        return sintoma;
    }

    
    /** 
     * pre: se tiene el numero de la prioridad
     * @return int regresa el numero de la prioridad
     */
    //Regresa el numero de prioridad
    public int getNumeroPrioridad() {
        return numeroPrioridad;
    }

    
    /** 
     * pre: se tiene el valor del numero de la prioridad de dos pacientes
     * @param o es el paciente que se desea comparar
     * @return int se regresa la compacion entre los dos datos
     */
    //Regresa la comparacion
    @Override
    public int compareTo(Paciente o) {
        return (this.numeroPrioridad - o.getNumeroPrioridad());//Se comparan dos pacientes
    }

    
    /** 
     * pre: se tienen los datos de nombre, sintoma y prioridad
     * @return String
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + prioridad;//Se regresan las propiedades del paciente
    }

}
