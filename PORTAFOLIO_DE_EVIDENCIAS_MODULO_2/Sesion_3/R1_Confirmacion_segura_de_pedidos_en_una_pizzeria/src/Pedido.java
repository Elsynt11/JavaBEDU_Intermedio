import java.util.Optional;

public class Pedido
{
    private final String cliente;
    private final String tipoEntrega; //"domicilio" o "local"
    private final String telefono;

    public Pedido(String cliente, String tipoEntrega,  String telefono)
    {
        this.cliente = cliente;
        this.telefono = telefono;
        this.tipoEntrega = tipoEntrega;
    }

    public String getCliente()
    {
        return cliente;
    }

    public String getTipoEntrega()
    {
        return tipoEntrega;
    }

    public Optional<String> getTelefono()
    {
        return Optional.ofNullable(telefono);
    }

    @Override
    public String toString()
    {
        return "📞 Confirmación enviada al número: " + telefono;
    }
}
