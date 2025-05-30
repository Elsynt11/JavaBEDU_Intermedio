public class Ejercicio  extends MaterialCurso
{
    boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado)
    {
        super(titulo, autor);
        this.revisado = revisado;
    }

    @Override
    public void mostrarDetalle()
    {
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}
