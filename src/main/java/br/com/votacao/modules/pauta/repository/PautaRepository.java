package br.com.votacao.modules.pauta.repository;

import br.com.votacao.modules.pauta.models.entity.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PautaRepository extends JpaRepository<PautaEntity, UUID> {
}
