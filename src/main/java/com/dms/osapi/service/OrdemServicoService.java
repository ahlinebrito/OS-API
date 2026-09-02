package com.dms.osapi.service;

import com.dms.osapi.exception.OrdemServicoNaoEncontradaException;
import com.dms.osapi.model.OrdemServico;
import com.dms.osapi.model.StatusOS;
import com.dms.osapi.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;

    @Autowired
    public OrdemServicoService(OrdemServicoRepository repository) {
        this.repository = repository;
    }

    public List<OrdemServico> listarTodas() {
        return repository.findAll();
    }

    public List<OrdemServico> listarPorStatus(StatusOS status) {
        return repository.findByStatus(status);
    }

    public OrdemServico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrdemServicoNaoEncontradaException(id));
    }

    public OrdemServico criar(OrdemServico ordemServico) {
        return repository.save(ordemServico);
    }

    public OrdemServico atualizar(Long id, OrdemServico dadosAtualizados) {
        OrdemServico existente = buscarPorId(id);

        existente.setNumeroOs(dadosAtualizados.getNumeroOs());
        existente.setCliente(dadosAtualizados.getCliente());
        existente.setDescricao(dadosAtualizados.getDescricao());
        existente.setDataAbertura(dadosAtualizados.getDataAbertura());
        existente.setStatus(dadosAtualizados.getStatus());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        OrdemServico existente = buscarPorId(id);
        repository.delete(existente);
    }

}
