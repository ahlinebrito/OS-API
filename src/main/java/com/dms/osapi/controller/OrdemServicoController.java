package com.dms.osapi.controller;

import com.dms.osapi.model.OrdemServico;
import com.dms.osapi.model.StatusOS;
import com.dms.osapi.service.OrdemServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoService service;

    @Autowired
    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    // GET /api/ordens-servico
    // GET /api/ordens-servico?status=PENDENTE
    @GetMapping
    public ResponseEntity<List<OrdemServico>> listar(
            @RequestParam(required = false) StatusOS status) {

        List<OrdemServico> resultado = (status != null)
                ? service.listarPorStatus(status)
                : service.listarTodas();

        return ResponseEntity.ok(resultado);
    }

    // GET /api/ordens-servico/1
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // POST /api/ordens-servico
    @PostMapping
    public ResponseEntity<OrdemServico> criar(@Valid @RequestBody OrdemServico ordemServico) {
        OrdemServico criada = service.criar(ordemServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    // PUT /api/ordens-servico/1
    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody OrdemServico ordemServico) {

        return ResponseEntity.ok(service.atualizar(id, ordemServico));
    }

    // DELETE /api/ordens-servico/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
