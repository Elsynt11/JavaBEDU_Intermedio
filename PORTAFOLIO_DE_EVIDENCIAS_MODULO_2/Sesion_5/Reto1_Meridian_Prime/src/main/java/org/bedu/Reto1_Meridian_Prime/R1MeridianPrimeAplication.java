package org.bedu.Reto1_Meridian_Prime;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class R1MeridianPrimeAplication {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        // 🚗 Sensor de tráfico
        Flux.just(1).repeat()
            .delayElements(Duration.ofMillis(500))
            .map(i -> random.nextInt(101))
            .filter(trafico -> trafico > 70)
            .map(trafico -> " [ALERTA]: Congestion critica: " + trafico + "%")
            .subscribe(System.out::println);

        // 🌫️ Contaminación del aire
        Flux.just(1).repeat()
            .delayElements(Duration.ofMillis(600))
            .map(i -> random.nextInt(101))
            .filter(aire -> aire > 50)
            .map(aire -> " [ALERTA]: Contaminacion alta: " + aire + " ug/m3")
            .subscribe(System.out::println);

        // 🚑 Accidentes viales
        Flux.just(1).repeat()
            .delayElements(Duration.ofMillis(800))
            .map(i -> {
                String[] prioridades = {"Baja", "Media", "Alta"};
                return prioridades[random.nextInt(prioridades.length)];
            })
            .filter(prio -> prio.equals("Alta"))
            .map(prio -> " [EMERGENCIA VIAL]: Accidente con prioridad " + prio)
            .subscribe(System.out::println);

        // 🚝 Tren maglev
        Flux.just(1).repeat()
            .delayElements(Duration.ofMillis(700))
            .map(i -> random.nextInt(11))
            .filter(min -> min > 5)
            .map(min -> " [TREN MANLEV]: Tren maglev con retraso critico: " + min + " min")
            .subscribe(System.out::println);

        // 🚦 Semáforos inteligentes
        Flux.just(1).repeat()
            .delayElements(Duration.ofMillis(400))
            .map(i -> {
                String[] estados = {"Verde", "Amarillo", "Rojo"};
                return estados[random.nextInt(estados.length)];
            })
            .buffer(3, 1)
            .filter(lista -> lista.stream().allMatch(estado -> estado.equals("Rojo")))
            .map(lista -> " [SEMAFORO]: Semaforo en rojo 3 veces seguidas")
            .subscribe(System.out::println);

        Thread.sleep(9000);
    }
}
