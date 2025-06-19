package com.bedu.Reto2_tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Reto2TiendaApplication 
{

	public static void main(String[] args) 
    {
		SpringApplication.run(Reto2TiendaApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository  categoriaRepo, MarcaRepository marcaRepo) 
	{
        return (args) -> {

            Categoria tecnologia = new Categoria("Tecnologia");
            categoriaRepo.save(tecnologia);

            Marca Apple = new Marca("Apple");
            Marca Samsung = new Marca("Samsung");
            marcaRepo.save(Apple);
            marcaRepo.save(Samsung);

            productoRepo.save(new Producto("iPhone 15", "Telefono iPhone 15", 90000.00, tecnologia, Apple));
            productoRepo.save(new Producto("iPad Pro", "Telefono iPad Pro", 140000.00, tecnologia, Apple));
            productoRepo.save(new Producto("Galaxy S23", "Telefono Galaxy S23", 7800.00, tecnologia, Samsung));
            productoRepo.save(new Producto("Smart TV", "TV Smart", 12000.00, tecnologia, Samsung));

            System.out.println("📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
            System.out.println("🏷️ " + marca.getNombre() + ":");
            productoRepo.findAll().stream()
                .filter(p -> p.getMarca().getId().equals(marca.getId()))
                .forEach(p -> System.out.println("   - " + p.getNombre()));
            });

        };
    }


}
