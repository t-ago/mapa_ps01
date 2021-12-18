package Controlador.CLI;

import Controlador.Controlador;
import Controlador.CadastroPaciente;
import Controlador.CadastroTriagem;
import Entidade.Triagem;
import Servico.ServicoControlador;
import Servico.ServicoTriagem;
import Visualizacao.CLI.VisualizacaoCLI;

import java.util.ArrayList;

public class ControladorCLI extends Controlador implements ServicoControlador {

    VisualizacaoCLI c;

    public ControladorCLI(ServicoTriagem st) {
        c = new VisualizacaoCLI();
        cadastroTriagem = new CadastroTriagem(c, c, st);
        cadastroPaciente = new CadastroPaciente(c, c);
        sessao = new ArrayList<Triagem>();

        executarPrograma();
    }

    public void executarPrograma() {
        Boolean ligaOuDesliga = true;

        while (ligaOuDesliga) {
            c.telaInicial();
            int entradaDoUsuario = obterOpcaoUsuario();
            c.prepararProximaTela();

            switch (entradaDoUsuario) {
                case 1:
                    c.prepararProximaTela();
                    sessao.add(cadastroTriagem.NovaTriagem());

                    break;
                case 2:
                    c.prepararProximaTela();
                    for (Triagem triagem : sessao) {
                        System.out.println(triagem);
                        c.prepararProximaTela();
                    }

                    break;
                case 0:
                    ligaOuDesliga = false;

                    break;
                default:
                    System.out.print("Insira uma opção válida." +
                            "Pressione ENTER para continuar...");
                    c.prepararProximaTela();
                    break;
            }
        }
    }

    private int obterOpcaoUsuario() {
        int entradaDoUsuario;

        while (true) {
            try {
                entradaDoUsuario = c.obterIntDoUsuario();
                break;
            } catch (RuntimeException e) {
                c.mostrarErro("Insira uma opção válida: ");
            }
        }

        return entradaDoUsuario;
    }
}
