package org.bedu.Reto2_Monitoreo_signos_vitales;

import java.time.Duration;

import reactor.core.publisher.Flux;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Reto2MonitoreoSignosVitalesApplication 
{

	public static void main(String[] args) throws InterruptedException
	{
		// SpringApplication.run(Reto2MonitoreoSignosVitalesApplication.class, args);
		
		Flux.merge(
			
			//Frecuencia cardiaca
            GeneradorSignosVitales.generarFC(1),
            GeneradorSignosVitales.generarFC(2),
            GeneradorSignosVitales.generarFC(3),
    		
			// Presión Arterial
            GeneradorSignosVitales.generarPA(1),
            GeneradorSignosVitales.generarPA(2),
            GeneradorSignosVitales.generarPA(3),

			// Oxigenación (SpO2)
            GeneradorSignosVitales.generarOS(1),
            GeneradorSignosVitales.generarOS(2),
            GeneradorSignosVitales.generarOS(3)
        )
        .delayElements(Duration.ofSeconds(1)) // Backpressure
        .subscribe(System.out::println);

		Thread.sleep(30000);
	}

}
