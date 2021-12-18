package Entidade;

public class Sintoma {
    public String Denominacao;
    public int Peso;

    public Sintoma(String entradaDenominacao, int entradaPeso) {
        Denominacao = entradaDenominacao;
        Peso = entradaPeso;
    }

    @Override
    public String toString() {
        return Denominacao;
    }
}
