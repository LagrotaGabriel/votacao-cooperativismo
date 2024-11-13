package br.com.votacao.modules.associado.repository;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, UUID> {

    @Query("SELECT COUNT(a) > 0 FROM AssociadoEntity a WHERE a.cpf = :cpf")
    boolean verificaSeJaExisteUmAssociadoCadastradoComCpfInformado(
            @Param("cpf") String cpf
    );
}
