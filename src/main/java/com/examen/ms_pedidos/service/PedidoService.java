package com.examen.ms_pedidos.service;

import com.examen.ms_pedidos.dto.PedidoDTO;
import com.examen.ms_pedidos.entity.Pedido;
import com.examen.ms_pedidos.exception.ResourceNotFoundException;
import com.examen.ms_pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido crear(PedidoDTO dto) {
        Pedido p = new Pedido();
        p.setCliente(dto.getCliente());
        p.setCorreoCliente(dto.getCorreoCliente());
        p.setProductoId(dto.getProductoId());
        p.setNombreProducto(dto.getNombreProducto());
        p.setCantidad(dto.getCantidad());
        p.setPrecioUnitario(dto.getPrecioUnitario());
        p.setTotal(dto.getPrecioUnitario().multiply(
                java.math.BigDecimal.valueOf(dto.getCantidad())));
        p.setEstado("REGISTRADO");
        p.setFechaPedido(LocalDateTime.now());
        return repository.save(p);
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un pedido con el ID " + id));
    }

    public Pedido actualizarEstado(Long id, String estado) {
        Pedido p = buscarPorId(id);
        p.setEstado(estado);
        return repository.save(p);
    }

    public void eliminar(Long id) {
        Pedido p = buscarPorId(id);
        p.setEstado("CANCELADO");
        repository.save(p);
    }
}