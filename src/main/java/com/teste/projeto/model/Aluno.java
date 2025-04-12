package com.teste.projeto.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String NomeAluno;
    private long Id;
    private String MatriculaAluno;
    private int IdadeAluno;


    //getter e setter alunos

    public String getNomeAluno() {
        return NomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.NomeAluno = nomeAluno;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getMatriculaAluno() {
        return MatriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.MatriculaAluno = matriculaAluno;
    }

    public int getIdadeAluno() {
        return IdadeAluno;
    }

    public void setIdadeAluno(int idadeAluno) {
        this.IdadeAluno = idadeAluno;
    }
}
