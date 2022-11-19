package io.github.com.lafsdev.rest.dto;

import io.github.com.lafsdev.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {

    @NotNull(message = "Informe o código do cliente")
    private Integer cliente;
    @NotNull(message = "Campo Total do Pedido é obrigatório")
    private BigDecimal total;
    @NotEmptyList
    private List<ItemPedidoDTO> items;
}
