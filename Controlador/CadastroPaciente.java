package Controlador;

import Entidade.Paciente;
import Entidade.Enum.SexoEnum;
import Servico.ServicoEntrada;
import Servico.ServicoSaida;

public class CadastroPaciente extends Cadastro {

    private String perguntaNome = "Nome: ";
    private String perguntaCPF = "CPF: ";
    private String perguntaSexo = "Sexo (M/F): ";
    private String perguntaIdade = "Idade: ";

    public CadastroPaciente(ServicoEntrada e, ServicoSaida s) {
        appEntrada = e;
        appSaida = s;
    }

    public Paciente novoPaciente() {
        String nomeLocal = definirNome();
        String cpfLocal = definirCPF();
        SexoEnum sexoLocal = definirSexo();
        int idadeLocal = definirIdade();

        appEntrada.prepararProximaTela();
        return new Paciente(nomeLocal, cpfLocal, sexoLocal, idadeLocal);
    }

    private String definirNome() {
        String nomeLocal;
        appSaida.imprimir(perguntaNome);

        while (true) {
            try {
                nomeLocal = appEntrada.obterNomeDoUsuario();
                break;
            } catch (Exception e) {
                appSaida.mostrarErro(e);
            }
        }

        return nomeLocal;
    }

    private String definirCPF() {
        String cpfLocal;
        appSaida.imprimir(perguntaCPF);

        while (true) {
            try {
                cpfLocal = appEntrada.obterCPFDoUsuario();
                break;
            } catch (Exception e) {
                appSaida.mostrarErro(e);
            }
        }

        if (cpfLocal.compareToIgnoreCase("sair") == 0) {
            System.exit(0);
        }

        return cpfLocal;
    }

    private SexoEnum definirSexo() {
        SexoEnum sexoLocal;
        appSaida.imprimir(perguntaSexo);

        while (true) {
            try {
                sexoLocal = appEntrada.obterSexoDoUsuario();
                break;
            } catch (Exception e) {
                appSaida.mostrarErro(e);
            }
        }

        return sexoLocal;
    }

    private int definirIdade() {
        int idadeLocal;
        appSaida.imprimir(perguntaIdade);

        while (true) {
            try {
                idadeLocal = appEntrada.obterIntDoUsuario();
                break;
            } catch (Exception e) {
                appSaida.mostrarErro(e);
            }
        }

        return idadeLocal;
    }
}
