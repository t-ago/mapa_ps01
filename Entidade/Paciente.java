package Entidade;

import Entidade.Enum.SexoEnum;

import java.lang.StringBuilder;

public class Paciente {
    public String Nome;
    public String CPF;
    public SexoEnum Sexo;
    public int Idade;

    public Paciente(String entradaNome,
            String entradaCPF,
            SexoEnum entradaSexo,
            int entradaIdade) {
        Nome = entradaNome;
        CPF = entradaCPF;
        Sexo = entradaSexo;
        Idade = entradaIdade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Nome: %s\n", Nome));
        sb.append(String.format("CPF: %s\n", CPF));
        sb.append(String.format("Sexo: %s\n", Sexo.toString()));
        sb.append(String.format("Idade: %d\n", Idade));

        return sb.toString();
    }
}
