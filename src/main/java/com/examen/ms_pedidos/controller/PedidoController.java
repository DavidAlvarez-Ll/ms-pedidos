package com.examen.ms_pedidos.controller;

import com.examen.ms_pedidos.dto.PedidoDTO;
import com.examen.ms_pedidos.entity.Pedido;
import com.examen.ms_pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> crear(@Valid @RequestBody PedidoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Pedido> actualizarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(service.actualizarEstado(id, body.get("estado")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}