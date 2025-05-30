package src;

public class OrdenPrototipo extends OrdenProduccion
{
    String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String fase)
    {
        super(codigo, cantidad);
        this.faseDesarrollo = fase;
    }

    @Override
    public void mostrarResumen()
    {
       System.out.println("🧪 src.OrdenPrototipo - Código: " + codigo + " Cantidad: " + cantidad + " Fase: " + faseDesarrollo);
    }
}
