package br.com.votacao.modules.voto.entity;

import br.com.votacao.modules.associado.entity.AssociadoEntity;
import br.com.votacao.modules.voto.entity.enums.TipoVotoEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * VotoEntity
 * Classe responsável por fornecer todos os atributos que deverão ser utilizados na entidade Voto. Também
 * fornecendo parâmetros que deverão ser utilizados na tabela TB_VOTO
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 00:53
 */
@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_VOTO")
public class VotoEntity {

    @Id
    @Comment("Chave primária do voto - UUID")
    @Column(name = "COD_VOTO_VTO", nullable = false, updatable = false)
    private UUID id;

    @Comment("Tipo do voto: SIM ou NAO")
    @Column(name = "ENM_TIPO_VTO", nullable = false)
    private TipoVotoEnum tipoVoto;

    @Comment("Data e hora que o voto foi realizado")
    @Column(name = "LDT_DATAHORA_VTO", nullable = false, updatable = false)
    private LocalDateTime dataHoraVoto;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("Associado que realizou o voto")
    @JoinColumn(name = "COD_ASSOCIADO_VTO", referencedColumnName = "COD_ASSOCIADO_ASC", nullable = false, updatable = false)
    private AssociadoEntity associado;
}