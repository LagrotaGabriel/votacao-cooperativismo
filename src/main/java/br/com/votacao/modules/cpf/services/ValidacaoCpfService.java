package br.com.votacao.modules.cpf.services;

import br.com.votacao.modules.cpf.models.request.CpfRequest;
import br.com.votacao.modules.cpf.models.response.CpfResponse;

public interface ValidacaoCpfService {

    CpfResponse realizaValidacaoDeCpf(
            CpfRequest cpfRequest
    );
}
