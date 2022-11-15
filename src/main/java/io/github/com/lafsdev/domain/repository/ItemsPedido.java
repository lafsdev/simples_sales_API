package io.github.com.lafsdev.domain.repository;

import io.github.com.lafsdev.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
