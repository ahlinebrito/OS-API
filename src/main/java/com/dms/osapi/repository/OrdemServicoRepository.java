package com.dms.osapi.repository;

import com.dms.osapi.model.OrdemServico;
import com.dms.osapi.model.StatusOS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    Optional<OrdemServico> findByNumeroOs(String numeroOs);

    List<OrdemServico> findByStatus(StatusOS status);

}
