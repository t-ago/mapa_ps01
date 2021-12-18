package Servico;

import Entidade.Sintoma;
import Entidade.Enum.RiscoEnum;

import java.util.Hashtable;

public interface ServicoTriagem {
    public Hashtable<Sintoma, Boolean> gerarSintomas();

    public RiscoEnum calcularRisco(int pontuacaoTriagem);
}
