import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Video> videos = List.of(
            new Video("Introducción a Java", "Mario", 15),
            new Video("POO en Java", "Carlos", 20)
        );

        List<Articulo> articulos = List.of(
            new Articulo("Historia de Java", "Ana", 1200),
            new Articulo("Tipos de datos", "Luis", 800)
        );

        List<Ejercicio> ejercicios = List.of(
             new Ejercicio("Variables y tipos", "Luis", false),
             new Ejercicio("Condicionales", "Mario", false)
        );

        System.out.println("\n📚 Materiales del curso:");
        mostrarMateriales(videos);
        mostrarMateriales(articulos);
        mostrarMateriales(ejercicios);

        contarDuracionVideos(videos);
        System.out.println();
        marcarEjerciciosRevisados(ejercicios);

        Predicate<MaterialCurso> esDeMario = m -> m.autor.equalsIgnoreCase("Mario");

        List<MaterialCurso> todosMateriales = new ArrayList<>();
        todosMateriales.addAll(videos);
        todosMateriales.addAll(articulos);
        todosMateriales.addAll(ejercicios);

        List<MaterialCurso> materialesDeMario = filtrarPorAutor(todosMateriales, esDeMario);

        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso m : materialesDeMario)
        {
            m.mostrarDetalle();
        }
    }

    public static void mostrarMateriales(List<? extends MaterialCurso> lista)
    {
        for ( MaterialCurso material : lista )
        {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista)
    {
        double duracion_total_videos = 0.00;

        for ( Video v : lista )
        {
            duracion_total_videos += v.duracion;
        }

        System.out.println("\n🎥 Duración total de videos: " + duracion_total_videos + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista)
    {
        for (Object obj : lista)
        {
            if (obj instanceof Ejercicio ejercicio)
            {
                ejercicio.revisado = true;
                System.out.println("✅ Ejercicio '" + ejercicio.titulo + "' marcado como " + ( (ejercicio.revisado) ? "revisado" : "NO revisado" ) );
            }
        }
    }

    public static List<MaterialCurso> filtrarPorAutor(List<? extends MaterialCurso> materiales, Predicate<MaterialCurso> criterio)
    {
        return materiales.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }
}