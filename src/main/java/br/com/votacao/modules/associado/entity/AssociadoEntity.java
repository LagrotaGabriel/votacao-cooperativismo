package br.com.votacao.modules.associado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.UUID;

/**
 * AssociadoEntity
 * Classe responsável por fornecer todos os atributos que deverão ser utilizados na entidade Associado. Também
 * fornecendo parâmetros que deverão ser utilizados na tabela TB_ASSOCIADO
 * @author Gabriel Henrique Afonso Cruz Lagrota
 * @since 13/11/2024 - 00:44
 */
@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ASSOCIADO")
public class AssociadoEntity {

    @Id
    @Comment("Chave primária do associado - UUID")
    @Column(name = "COD_ASSOCIADO_ASC", nullable = false, updatable = false)
    private UUID id;

    @Comment("Nome do associado")
    @Column(name = "STR_NOME_ASC", nullable = false, length = 60)
    private String nome;

    @Comment("CPF do associado")
    @Column(name = "STR_CPF_ASC", unique = true, nullable = false, length = 14)
    private String cpf;
}
