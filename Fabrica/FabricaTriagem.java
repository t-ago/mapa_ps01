package Fabrica;

import Servico.ServicoTriagem;
import Servico.TriagemCovid.ServicoTriagemCovid;

public class FabricaTriagem {
    public ServicoTriagem obterServicoTriagem(String flagServico) {
        switch (flagServico) {
            case "-covid":
                return new ServicoTriagemCovid();
            default:
                throw new IllegalArgumentException("ERRO FATAL: " +
                        "Flag de serviço inválida.");
        }
    }
}
