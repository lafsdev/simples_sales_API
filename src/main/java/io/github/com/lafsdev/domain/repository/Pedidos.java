package io.github.com.lafsdev.domain.repository;

import io.github.com.lafsdev.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
