package io.github.com.lafsdev.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {

    private Integer produto;
    private Integer quantidade;
}
