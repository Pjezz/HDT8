import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SistemaEmergencias {
    public static void main(String[] args) {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        try (Scanner scanner = new Scanner(new File("pacientes.txt"))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Paciente paciente = new Paciente(
                        datos[0].trim(),
                        datos[1].trim(),
                        datos[2].trim().charAt(0));
                cola.add(paciente);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: pacientes.txt");
            return;
        }

        // Atender pacientes
        while (!cola.isEmpty()) {
            System.out.println("Atendiendo a: " + cola.remove());
        }
    }
}