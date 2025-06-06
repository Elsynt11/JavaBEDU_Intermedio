import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl
{
   public static CompletableFuture<Boolean> verificarPista()
   {
       boolean verificacionPista = ThreadLocalRandom.current().nextBoolean();
       return CompletableFuture.supplyAsync(() -> {
          latencia(2);
          return verificacionPista;
      });
   }

   public static CompletableFuture<Boolean> verificarClima()
   {
       boolean verificacionClima = ThreadLocalRandom.current().nextBoolean();
       return CompletableFuture.supplyAsync( () -> {
           latencia(3);
           return verificacionClima;
       });
   }

   public static CompletableFuture<Boolean> verificarTraficoAereo()
   {
       boolean verificacionTraficoAereo = ThreadLocalRandom.current().nextBoolean();
       return CompletableFuture.supplyAsync( () -> {
           latencia(2);
           return verificacionTraficoAereo;
       });
   }

   public static CompletableFuture<Boolean> verificarPersonalTierra()
   {
       boolean verificacionPersonal = ThreadLocalRandom.current().nextBoolean();
       return CompletableFuture.supplyAsync( () -> {
           latencia(3);
           return verificacionPersonal;
       });
   }

    //Método auxiliar para simular latencia
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

    public static void autorizarAterrizaje()
    {
        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture<Void> aterrizaje = CompletableFuture.allOf(pista, clima, trafico, personal).thenRun(() -> {
            try
            {
                System.out.println("\n🏙️ Pista disponible: " + pista.get() +
                        "\n🌥️ Clima favorable: " +  clima.get() +
                        "\n🚦 Tráfico aéreo despejado: " + trafico.get() +
                        "\n👷‍♂️ Personal disponible: " + personal.get() );
                if ( pista.get() && clima.get() && trafico.get() && personal.get() )
                {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                }
                else
                {
                    System.out.println("\n🚨 Aterrizaje denegado: condiciones no óptimas.");
                }
            }
            catch (Exception e)
            {
                System.out.println("🚨 Error al verificar condiciones: " + e.getMessage());
            }
        });

        aterrizaje.join();
    }

}
