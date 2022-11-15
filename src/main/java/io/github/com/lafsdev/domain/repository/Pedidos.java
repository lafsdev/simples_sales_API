package io.github.com.lafsdev.domain.repository;

import io.github.com.lafsdev.domain.entity.Cliente;
import io.github.com.lafsdev.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
