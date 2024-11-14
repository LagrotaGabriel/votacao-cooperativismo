package br.com.votacao.modules.cpf.services;

import br.com.votacao.modules.cpf.models.CpfRequest;
import br.com.votacao.modules.cpf.models.CpfResponse;

public interface ValidacaoCpfService {

    CpfResponse realizaValidacaoDeCpf(
            CpfRequest cpfRequest
    );
}
