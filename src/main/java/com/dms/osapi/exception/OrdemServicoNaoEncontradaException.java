package com.dms.osapi.exception;

public class OrdemServicoNaoEncontradaException extends RuntimeException {

    public OrdemServicoNaoEncontradaException(Long id) {
        super("Ordem de servico nao encontrada com id: " + id);
    }

}
