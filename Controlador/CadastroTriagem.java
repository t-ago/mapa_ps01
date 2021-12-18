package Controlador;

import Entidade.Paciente;
import Entidade.Sintoma;
import Entidade.Triagem;
import Servico.ServicoEntrada;
import Servico.ServicoSaida;
import Servico.ServicoTriagem;

import java.util.Map;

public class CadastroTriagem extends Cadastro {

    private ServicoTriagem appServicoTriagem;

    public CadastroTriagem(ServicoEntrada e, ServicoSaida s, ServicoTriagem st) {
        appEntrada = e;
        appSaida = s;
        appServicoTriagem = st;
    }

    public Triagem NovaTriagem() {
        CadastroPaciente cadastroPaciente = new CadastroPaciente(appEntrada, appSaida);
        Triagem triagem = realizarTriagem(cadastroPaciente.novoPaciente());
        appEntrada.prepararProximaTela();

        return triagem;
    }

    private Triagem realizarTriagem(Paciente paciente) {
        Triagem triagem = new Triagem(paciente, appServicoTriagem);
        int contadorPontos = 0;

        for (Map.Entry<Sintoma, Boolean> entrada : triagem.Sintomas.entrySet()) {
            Sintoma sintomaLocal = entrada.getKey();

            while (true) {
                try {
                    appSaida.imprimir(String.format("Teve %s? ",
                            sintomaLocal.Denominacao));
                    Boolean resposta = appEntrada.obterBoolDoUsuario();

                    entrada.setValue(resposta);

                    if (resposta) {
                        contadorPontos += sintomaLocal.Peso;
                    }

                    break;
                } catch (Exception e) {
                    appSaida.mostrarErro(e);
                }
            }
        }

        triagem.Resultado = appServicoTriagem.calcularRisco(contadorPontos);
        appSaida.imprimir(appSaida.indicarAla(triagem.Resultado, contadorPontos));
        return triagem;
    }
}