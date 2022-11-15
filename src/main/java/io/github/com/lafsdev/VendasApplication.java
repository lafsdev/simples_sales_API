package io.github.com.lafsdev;

import io.github.com.lafsdev.domain.entity.Cliente;
import io.github.com.lafsdev.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Leandro Alves de Fontes Silva"));
            clientes.save(new Cliente("Cliente 2"));

            System.out.println("Pesquisando com query Methods HQL");
            List<Cliente> result = clientes.encontrarPorNomeHQL("Leandro");
            result.forEach(System.out::println);


            System.out.println("Pesquisando com query Methods SQL");
            List<Cliente> result2 = clientes.encontrarPorNomeSQL("Leandro");
            result2.forEach(System.out::println);


            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes.");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.save(c);
            });
            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes.");
            clientes.findByNomeLike("Cli").forEach(System.out::println);

            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Deletando clientes");
            clientes.findAll().forEach(c -> {
                clientes.delete(c);
            });
            todosClientes = clientes.findAll();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado");
            } else {
                todosClientes.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
