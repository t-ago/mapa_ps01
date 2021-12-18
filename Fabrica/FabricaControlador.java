package Fabrica;

import Controlador.CLI.ControladorCLI;
import Servico.ServicoControlador;
import Servico.ServicoTriagem;

public class FabricaControlador {
    public ServicoControlador obterControlador(String flagUI, ServicoTriagem st) {
        switch (flagUI) {
            case "-cli":
                return new ControladorCLI(st);
            default:
                throw new IllegalArgumentException("ERRO FATAL: " +
                        "Flag de controlador inválida.");
        }
    }
}
