import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp 
{
    public static CompletableFuture<String> calcularRuta()
    {
        return CompletableFuture.supplyAsync( () -> {
            System.out.println("🚦Calculando ruta...");
            latencia(2);
            return "Ruta: Centro -> Norte";
        });
    }

    public static CompletableFuture<Double> estimarTarifa()
    {
        return CompletableFuture.supplyAsync( () -> {
            System.out.println("💰 Estimando tarifa...");
            latencia(2);
            return 75.50;
        });
    }

    // Método auxiliar para simular latencia
    public static void latencia(int segundos)
    {
        try
        {
            TimeUnit.SECONDS.sleep(segundos);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void combinarOperaciones()
    {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        CompletableFuture<Void> rutaCalculada = rutaFuture.thenCombine(tarifaFuture,
            (ruta, precio) -> {
                return "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + precio;
            })
            .thenAccept(System.out::println)
            .exceptionally(ex -> {
                System.out.println("🚨 Error al calcular la ruta: " + ex.getMessage() );
                return null;
            });

        // Esperar que todo termine
        rutaCalculada.join();
    }


}
