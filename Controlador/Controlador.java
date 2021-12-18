package Controlador;

import Entidade.Triagem;

import java.util.ArrayList;

public abstract class Controlador {
    protected CadastroTriagem cadastroTriagem;
    protected CadastroPaciente cadastroPaciente;
    protected ArrayList<Triagem> sessao;
}
