import Fabrica.FabricaControlador;
import Fabrica.FabricaTriagem;
import Servico.ServicoControlador;

public class App {
    public static void main(String[] args) {
        /*
         * Formato de argumento: {"flagUI", "flagServico"}
         * Exemplo: <comando de init> -cli -covid
         * NOTA: Por padrão, usa "-cli -covid"
         */

        String flagVisualizacao;
        String flagServico;

        switch (args.length) {
            case 0:
                flagVisualizacao = "-cli";
                flagServico = "-covid";
                break;
            case 2:
                flagVisualizacao = args[0];
                flagServico = args[1];
                break;
            default:
                throw new IllegalArgumentException("ERRO FATAL: " +
                        "Formato de flags inválida.");
        }

        FabricaTriagem ft = new FabricaTriagem();
        FabricaControlador fc = new FabricaControlador();
        ServicoControlador controladorPrincipal = fc.obterControlador(flagVisualizacao,
                ft.obterServicoTriagem(flagServico));

        controladorPrincipal.executarPrograma();
    }
}