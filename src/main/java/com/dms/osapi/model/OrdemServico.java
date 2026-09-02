package com.dms.osapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "ordens_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O numero da OS e obrigatorio")
    @Column(nullable = false, unique = true)
    private String numeroOs;

    @NotBlank(message = "O cliente e obrigatorio")
    @Column(nullable = false)
    private String cliente;

    private String descricao;

    @NotNull(message = "A data de abertura e obrigatoria")
    @Column(nullable = false)
    private LocalDate dataAbertura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOS status = StatusOS.PENDENTE;

    public OrdemServico() {
    }

    public OrdemServico(String numeroOs, String cliente, String descricao, LocalDate dataAbertura, StatusOS status) {
        this.numeroOs = numeroOs;
        this.cliente = cliente;
        this.descricao = descricao;
        this.dataAbertura = dataAbertura;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroOs() {
        return numeroOs;
    }

    public void setNumeroOs(String numeroOs) {
        this.numeroOs = numeroOs;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public StatusOS getStatus() {
        return status;
    }

    public void setStatus(StatusOS status) {
        this.status = status;
    }
}
