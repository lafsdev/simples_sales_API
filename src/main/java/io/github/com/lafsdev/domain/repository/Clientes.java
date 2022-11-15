package io.github.com.lafsdev.domain.repository;

import io.github.com.lafsdev.domain.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrId(String nome, Integer id);

    boolean existsByNome(String nome);
    
}