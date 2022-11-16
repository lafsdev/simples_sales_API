package io.github.com.lafsdev.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedidoDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}