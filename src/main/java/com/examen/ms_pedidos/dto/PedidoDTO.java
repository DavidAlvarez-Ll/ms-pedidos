package com.examen.ms_pedidos.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class PedidoDTO {

    @NotBlank(message = "El cliente no puede estar vacío")
    private String cliente;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener formato válido")
    private String correoCliente;

    @NotNull(message = "El productoId es obligatorio")
    private Long productoId;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombreProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser mayor que cero")
    private Integer cantidad;

    @NotNull(message = "El precio unitario es obligatorio")
    @Positive(message = "El precio unitario debe ser mayor que cero")
    private BigDecimal precioUnitario;
}