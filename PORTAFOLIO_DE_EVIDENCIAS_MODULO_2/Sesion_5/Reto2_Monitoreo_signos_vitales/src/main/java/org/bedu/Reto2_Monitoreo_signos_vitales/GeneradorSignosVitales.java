package org.bedu.Reto2_Monitoreo_signos_vitales;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class GeneradorSignosVitales 
{
    Random random = new Random();

    //Frecuencia cardiaca
    public static Flux<String> generarFC(int paciente)
    {
        return 	
        Flux.interval( Duration.ofMillis(300) )
        .onBackpressureBuffer()
        .map(i -> 40 + new Random().nextInt(100))
        .filter(fre -> fre > 120 || fre < 50 )
        .delayElements(Duration.ofSeconds(1))
        .map( fc -> " Paciente " + paciente + " - FC critica: " + fc + " bpm");
    }

    // Presión Arterial
    public static Flux<String> generarPA(int paciente)
    {
        return 	
        Flux.interval( Duration.ofMillis(300) )
        .onBackpressureBuffer()
        .map(i ->60 + new Random().nextInt(100))
        .filter(pre -> pre > 140 || pre < 90 )
        .delayElements(Duration.ofSeconds(1))
        .map( pre -> " Paciente " + paciente + " - PA anormal: " + pre + " mmHg");
    }

    // Oxigenación (SpO2)
    public static Flux<String> generarOS(int paciente)
    {
        return 	
        Flux.interval( Duration.ofMillis(300) )
        .onBackpressureBuffer()
        .map(i -> 75 + new Random().nextInt(25))
        .filter(oxi -> oxi < 90 )
        .delayElements(Duration.ofSeconds(1))
        .map( oxi -> " Paciente " + paciente + " - SpO2 baja: " + oxi + "%");
    }
}