package Entidade;

import Entidade.Enum.RiscoEnum;
import Servico.ServicoTriagem;

import java.util.Hashtable;
import java.util.Map;

public class Triagem {
    public Paciente Individuo;
    public ServicoTriagem Triagem;
    public Hashtable<Sintoma, Boolean> Sintomas;
    public RiscoEnum Resultado;

    public Triagem(Paciente entradaPaciente, ServicoTriagem entradaServico) {
        Individuo = entradaPaciente;
        Triagem = entradaServico;
        Sintomas = entradaServico.gerarSintomas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Individuo.toString());
        sb.append("\nINDICAÇÃO: " + Resultado);

        sb.append("\n");
        for (Map.Entry<Sintoma, Boolean> entrada : Sintomas.entrySet()) {
            sb.append(String.format("%s (%d pontos)",
                    entrada.getKey(),
                    entrada.getKey().Peso));
            sb.append(" - ");
            sb.append(entrada.getValue());
            sb.append("\n");
        }

        return sb.toString();
    }
}
