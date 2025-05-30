import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try
        {
            Future<String> navegacion = executor.submit( new SistemaNavegacion() );
            Future<String> soporteVital = executor.submit( new SistemaSoporteVital() );
            Future<String> comunicaciones = executor.submit( new SistemaComunicaciones() );
            Future<String> controlTermico = executor.submit( new SistemaControlTermico() );

            System.out.println("\n🚀 Simulación de misión espacial iniciada...");
            System.out.println( navegacion.get() );
            System.out.println( soporteVital.get() );
            System.out.println( comunicaciones.get() );
            System.out.println( controlTermico.get() );
            System.out.println("✅ Todos los sistemas reportan estado operativo.");
        }
        catch (InterruptedException | ExecutionException e)
        {
            System.out.println( "❌ Parece que algo falló: " + e.getMessage() );
        }

        executor.shutdown();

    }
}