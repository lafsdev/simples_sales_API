package io.github.com.lafsdev.service;

import io.github.com.lafsdev.domain.entity.Pedido;
import io.github.com.lafsdev.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
