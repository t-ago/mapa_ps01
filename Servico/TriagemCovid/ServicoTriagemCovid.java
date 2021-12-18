package Servico.TriagemCovid;

import Entidade.Sintoma;
import Entidade.Enum.RiscoEnum;
import Servico.ServicoTriagem;

import java.util.Hashtable;

public class ServicoTriagemCovid implements ServicoTriagem {

    public Hashtable<Sintoma, Boolean> gerarSintomas() {
        Hashtable<Sintoma, Boolean> saida = new Hashtable<Sintoma, Boolean>();

        saida.put(new Sintoma("Febre", 5), false);
        saida.put(new Sintoma("Dor de cabeça", 1), false);
        saida.put(new Sintoma("Secreção nasal ou espirros", 1), false);
        saida.put(new Sintoma("Dor/irritação na garganta", 1), false);
        saida.put(new Sintoma("Tosse Seca", 3), false);
        saida.put(new Sintoma("Dificuldade Respiratória", 10), false);
        saida.put(new Sintoma("Dores no Corpo", 1), false);
        saida.put(new Sintoma("Diarreia", 1), false);
        saida.put(new Sintoma("Contato, nos últimos 14 dias, " +
                "com um caso diagnosticado com COVID-19", 10), false);
        saida.put(new Sintoma("Contato com grandes aglomerações", 3), false);

        return saida;
    }

    public RiscoEnum calcularRisco(int pontuacaoTriagem) {
        RiscoEnum resultado;

        if (pontuacaoTriagem <= 9) {
            resultado = RiscoEnum.RiscoBaixo;
        } else if (pontuacaoTriagem <= 19) {
            resultado = RiscoEnum.RiscoMedio;
        } else {
            resultado = RiscoEnum.RiscoAlto;
        }

        return resultado;
    }
}
