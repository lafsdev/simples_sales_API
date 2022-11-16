package io.github.com.lafsdev.service.impl;

import io.github.com.lafsdev.domain.repository.Pedidos;
import io.github.com.lafsdev.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}