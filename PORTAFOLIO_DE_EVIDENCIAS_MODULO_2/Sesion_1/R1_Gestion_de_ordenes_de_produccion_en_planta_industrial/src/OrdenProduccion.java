package src;

public abstract class OrdenProduccion
{
    String codigo;
    int cantidad;

    public OrdenProduccion(String codigo, int cantidad)
    {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public abstract void mostrarResumen();

}