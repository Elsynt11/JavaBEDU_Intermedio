package src;

public class OrdenPersonalizada extends OrdenProduccion
{
    String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente)
    {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    @Override
    public void mostrarResumen()
    {
        System.out.println("🛠️ src.OrdenPersonalizada - Código: " + codigo + " Cantidad: " + cantidad + " Cliente: " + cliente);
    }

    public void agregarCosto(double costo)
    {
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costo);
    }
}
