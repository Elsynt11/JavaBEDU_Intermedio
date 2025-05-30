package src;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<OrdenMasa> ordenMasa = new ArrayList<>();
        List<OrdenPersonalizada> ordenPersonalizada = new ArrayList<>();
        List<OrdenPrototipo> ordenPrototipo = new ArrayList<>();

        ordenMasa.add( new OrdenMasa("A123", 500) );
        ordenMasa.add( new OrdenMasa("A124", 750) );

        ordenPersonalizada.add( new OrdenPersonalizada("P456", 100, "ClienteX" ) );
        ordenPersonalizada.add( new OrdenPersonalizada("P789", 150, "ClienteY") );

        ordenPrototipo.add( new OrdenPrototipo("T789", 10, "Diseño") );
        ordenPrototipo.add( new OrdenPrototipo("T790", 5, "Pruebas") );

        System.out.println("\n 📋 Órdenes registradas:");
        mostrarOrdenes(ordenMasa);

        System.out.println("\n 📋 Órdenes registradas:");
        mostrarOrdenes(ordenPersonalizada);

        System.out.println("\n 📋 Órdenes registradas:");
        mostrarOrdenes(ordenPrototipo);

        System.out.println("\n 💰 Procesando órdenes personalizadas...");
        procesarPersonalizadas(ordenPersonalizada, 200);

        System.out.println("\n 📊 Resumen total de órdenes:");
        int totalMasa = ordenMasa.size();
        int totalPersonalizadas = ordenPersonalizada.size();
        int totalPrototipos = ordenPrototipo.size();

        System.out.println("🔧 Producción en masa: " + totalMasa);
        System.out.println("🛠️ Personalizadas: " + totalPersonalizadas);
        System.out.println("🧪 Prototipos: " + totalPrototipos);

    }

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista)
    {
        for (OrdenProduccion orden : lista )
        {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional)
    {
        for ( Object obj : lista)
        {
            if (obj instanceof OrdenPersonalizada orden)
            {
                orden.agregarCosto(costoAdicional);
            }
        }
    }


}