package br.com.votacao.modules.associado.actions.cadastro.services.validator;

public interface CadastroAssociadoValidatorService {

    void realizaValidacaoSeJaExisteUmAssociadoCadastradoComCpfInformado(
            String cpf
    );
}
