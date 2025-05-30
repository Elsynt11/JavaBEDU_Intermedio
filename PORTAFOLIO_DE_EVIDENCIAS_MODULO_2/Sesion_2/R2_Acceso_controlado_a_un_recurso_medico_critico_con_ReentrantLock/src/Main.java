import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
    public static void main(String[] args)
    {
        RecursoMedico recursoMedico = new RecursoMedico("Sala de cirugía");

        Runnable doctor1 = () -> recursoMedico.usar("Dra. Sánchez");
        Runnable doctor2 = () -> recursoMedico.usar("Dr. Gómez");
        Runnable enfermero1 = () -> recursoMedico.usar("Enfermero Ruiz");
        Runnable enfermero2 = () -> recursoMedico.usar("Enfermera López");

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        System.out.println("\n🏥 Iniciando acceso a la Sala de cirugía...");
        executorService.submit(doctor1);
        executorService.submit(doctor2);
        executorService.submit(enfermero1);
        executorService.submit(enfermero2);

        executorService.shutdown();
    }
}