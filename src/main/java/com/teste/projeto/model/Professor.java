package com.teste.projeto.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String NomeProfessor;
    private String DisciplinaProfessor;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNomeProfessor() {
        return NomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.NomeProfessor = nomeProfessor;
    }

    public String getDisciplinaProfessor() {
        return DisciplinaProfessor;
    }

    public void setDisciplinaProfessor(String disciplinaProfessor) {
        this.DisciplinaProfessor = disciplinaProfessor;
    }
}
