public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintomas;
    private char codigoP;

    public Paciente(String nombre, String sintomas, char codigoP) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.codigoP = Character.toUpperCase(codigoP);
    }

    @Override
    public int compareTo(Paciente other) {
        return Character.compare(this.codigoP, other.codigoP);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getSintomas() {
        return this.sintomas;
    }

    public char getCodigoP() {
        return this.codigoP;
    }

    @Override
    public String toString() {
        return nombre + ", " + sintomas + "," + codigoP;
    }
}