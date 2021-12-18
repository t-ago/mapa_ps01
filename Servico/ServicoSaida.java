package Servico;

import Entidade.Enum.RiscoEnum;

public interface ServicoSaida {
    public void telaInicial();

    public void imprimir(String string);

    public String indicarAla(RiscoEnum resultado, int pontuacao);

    public void mostrarErro(Exception e);
}
