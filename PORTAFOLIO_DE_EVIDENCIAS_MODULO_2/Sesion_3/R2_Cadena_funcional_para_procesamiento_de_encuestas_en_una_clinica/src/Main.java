import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("Amelia", "La atención estuvo bien", 5),
                new Encuesta("Ricardo", "El tiempo de espera fue largo", 3),
                new Encuesta("Abigail", "El tiempo de espera fue largo para mi", 4),
                new Encuesta("Alfonso", "Excelente servicio", 5)
            ) ),
            new Sucursal("Norte", List.of(
                    new Encuesta("Maria", "La atención estuvo bien", 5),
                    new Encuesta("Alejandro", "El papeleo fue mucho", 2)
            ) ),
            new Sucursal("Sur", List.of(
                    new Encuesta("Monserrat", "La atención estuvo muy bien", 4),
                    new Encuesta("Victor", "La atención fue buena, pero la limpieza puede mejorar", 2),
                    new Encuesta("Perla", "Todo excelente!!", 5)
            ) )
        );

        sucursales.stream()
                .flatMap( sucursal ->
                    sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .map(encuesta -> new Comentario( encuesta, sucursal.getNombre() ) )
                )
                .map(comentario -> {
                    return "Sucursal " + comentario.getSucursal() + ": Seguimiento a paciente con comentario: " + comentario.getEncuesta().toString();
                })
                .forEach(System.out::println);

    }

    static class Comentario
    {
        private final Encuesta encuesta;
        private final String sucursal;

        public Comentario(Encuesta encuesta, String sucursal)
        {
            this.encuesta = encuesta;
            this.sucursal = sucursal;
        }

        public Encuesta getEncuesta()
        {
            return encuesta;
        }

        public String getSucursal()
        {
            return sucursal;
        }

    }
}