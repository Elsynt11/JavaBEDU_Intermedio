import java.util.List;
import java.util.Objects;

public class Main
{
    public static void main(String[] args)
    {
        List<Pedido> pedidos = List.of(
            new Pedido("Roger", "local", null),
            new Pedido("Gabriela", "Local", "555-0123"),
            new Pedido("Javier", "domicilio", "555-1234"),
            new Pedido("Andrés", "domicilio", "555-5678"),
            new Pedido("Victoria", "domicilio", null)
        );

        pedidos.stream()
            .filter(pedido -> Objects.equals(pedido.getTipoEntrega(), "domicilio") )
            .filter(pedido -> pedido.getTelefono().isPresent() )
            .forEach(System.out::println);

    }
}