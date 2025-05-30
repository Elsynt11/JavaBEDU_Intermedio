import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String>
{
    @Override
    public String call() throws Exception
    {
        return "📡 Soporte vital: enlace con estación terrestre establecido.";
    }
}
