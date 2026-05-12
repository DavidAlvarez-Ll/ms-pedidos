package com.examen.ms_pedidos.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String correoCliente;
    private Long productoId;
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal total;
    private String estado;
    private LocalDateTime fechaPedido;
}