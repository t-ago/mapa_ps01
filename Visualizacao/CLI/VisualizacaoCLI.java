package Visualizacao.CLI;

import Entidade.Enum.RiscoEnum;
import Entidade.Enum.SexoEnum;
import Visualizacao.InterfaceUsuario;

import java.util.Scanner;
import java.lang.StringBuilder;

public class VisualizacaoCLI extends InterfaceUsuario {
    private Scanner s;

    public VisualizacaoCLI() {
        s = new Scanner(System.in);
    }

    // ENTRADA

    public String obterNomeDoUsuario() {
        String nomeLocal = s.nextLine();

        if (nomeLocal.matches(".*\\d.*")) {
            throw new RuntimeException("Digite um nome válido (Somente letras): ");
        }

        return nomeLocal;
    }

    public String obterCPFDoUsuario() {
        String cpfLocal = s.nextLine();

        if (!cpfLocal.matches(".*\\d.*")) {
            throw new RuntimeException("Digite um CPF válido (Somente números): ");
        }

        return cpfLocal;
    }

    public SexoEnum obterSexoDoUsuario() {
        String entradaDeDados = s.nextLine();

        if (entradaDeDados.compareToIgnoreCase("masculino") != 0
                && entradaDeDados.compareToIgnoreCase("feminino") != 0
                && entradaDeDados.compareToIgnoreCase("m") != 0
                && entradaDeDados.compareToIgnoreCase("f") != 0) {
            throw new RuntimeException("Digite um sexo válido " +
                    "(m/f ou masculino/feminino): ");
        }

        return stringParaSexoEnum(entradaDeDados.toLowerCase());
    }

    public int obterIntDoUsuario() {
        if (!s.hasNextInt()) {
            // Necessário consumir a linha no buffer
            String temp = s.nextLine();
            temp.isBlank();
            throw new RuntimeException("Digite somente números: ");
        }

        return s.nextInt();
    }

    public Boolean obterBoolDoUsuario() {
        String entradaDeDados = s.nextLine();

        if (entradaDeDados.compareToIgnoreCase("sim") != 0
                && entradaDeDados.compareToIgnoreCase("não") != 0
                && entradaDeDados.compareToIgnoreCase("nao") != 0
                && entradaDeDados.compareToIgnoreCase("s") != 0
                && entradaDeDados.compareToIgnoreCase("n") != 0) {
            throw new RuntimeException("Digite uma resposta válida: sim/não ou s/n: ");
        }

        return stringParaBoolean(entradaDeDados.toLowerCase());
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private SexoEnum stringParaSexoEnum(String s) {
        SexoEnum saida;

        if (s.compareTo("masculino") == 0 || s.compareTo("m") == 0) {
            saida = SexoEnum.Masculino;
        } else {
            saida = SexoEnum.Feminino;
        }

        return saida;
    }

    private Boolean stringParaBoolean(String s) {
        Boolean saida;

        if (s.compareTo("sim") == 0 || s.compareTo("s") == 0) {
            saida = true;
        } else {
            saida = false;
        }

        return saida;
    }

    // SAIDA

    public void telaInicial() {
        limparTela();
        System.out.println("SERVIÇO DE TRIAGEM ELETRÔNICA\n\n" +
                "1 - Nova Triagem\n" +
                "2 - Exibir Triagens (Somente para fins de teste)\n" +
                "0 - Sair" +
                "\n\n");
    }

    public void imprimir(String string) {
        System.out.print(string);
    }

    public void prepararProximaTela() {
        System.out.print("\n\nPressione ENTER para continuar.");
        s.nextLine();
        limparTela();
    }

    public String indicarAla(RiscoEnum resultado, int pontuacao) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nPontuação: %d\n", pontuacao));
        sb.append("Encaminhe-se para a ala ");

        switch (resultado) {
            case RiscoAlto:
                sb.append("de risco alto.");
                break;
            case RiscoMedio:
                sb.append("de risco médio.");
                break;
            case RiscoBaixo:
                sb.append("de risco baixo.");
                break;
        }

        return sb.toString();
    }

    public void mostrarErro(Exception e) {
        System.out.print("ERRO: " + e.getMessage());
    }

    public void mostrarErro(String s) {
        System.out.print("ERRO: " + s);
    }
}
