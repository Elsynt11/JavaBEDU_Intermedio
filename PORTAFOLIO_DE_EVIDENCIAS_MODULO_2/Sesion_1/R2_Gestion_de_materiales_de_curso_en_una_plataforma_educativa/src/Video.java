public class Video extends MaterialCurso
{
    double duracion;

    public Video(String titulo, String autor, double duracion)
    {
        super(titulo, autor);
        this.duracion = duracion;
    }

    @Override
    public void mostrarDetalle()
    {
        System.out.println("🎥 Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min");
    }
}
