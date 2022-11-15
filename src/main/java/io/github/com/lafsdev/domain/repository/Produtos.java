package io.github.com.lafsdev.domain.repository;

import io.github.com.lafsdev.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {

}
