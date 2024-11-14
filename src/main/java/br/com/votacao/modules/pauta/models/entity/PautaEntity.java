package br.com.votacao.modules.pauta.models.entity;

import br.com.votacao.modules.voto.entity.VotoEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * PautaEntity
 * Classe responsável por fornecer todos os atributos que deverão ser utilizados na entidade Pauta. Também
 * fornecendo parâmetros que deverão ser utilizados na tabela TB_PAUTA
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 00:47
 */
@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PAUTA")
public class PautaEntity {

    @Id
    @Comment("Chave primária da pauta - UUID")
    @Column(name = "COD_PAUTA_PTA", nullable = false, updatable = false)
    private UUID id;

    @Comment("Título da pauta")
    @Column(name = "STR_TITULO_PTA", nullable = false, length = 60)
    private String titulo;

    @Comment("Descrição da pauta")
    @Column(name = "STR_DESCRICAO_PTA", nullable = false, length = 80)
    private String descricao;

    @Comment("Tempo de duração da pauta em minutos")
    @Column(name = "INT_TEMPODURACAOEMMINUTOS_PTA", nullable = false, length = 3)
    private Integer tempoDuracaoEmMinutos;

    @Comment("Data e hora que o cadastro da pauta foi realizado")
    @Column(name = "LDT_DATAHORACRIACAO_PTA", nullable = false, updatable = false)
    private LocalDateTime dataHoraCriacao;

    @Comment("Data e hora que a pauta deverá expirar")
    @Column(name = "LDT_DATAHORAEXPIRACAO_PTA", nullable = false, updatable = false)
    private LocalDateTime dataHoraExpiracao;

    @ToString.Exclude
    @Comment("Votos da pauta")
    @OneToMany(targetEntity = VotoEntity.class,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<VotoEntity> votos = new ArrayList<>();
}
