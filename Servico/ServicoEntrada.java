package Servico;

import Entidade.Enum.SexoEnum;

public interface ServicoEntrada {
    public String obterNomeDoUsuario();

    public String obterCPFDoUsuario();

    public SexoEnum obterSexoDoUsuario();

    public int obterIntDoUsuario();

    public Boolean obterBoolDoUsuario();

    public void prepararProximaTela();
}
