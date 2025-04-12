package com.teste.projeto.service;

import com.teste.projeto.model.Aluno;
import com.teste.projeto.model.Professor;
import com.teste.projeto.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    //Cadastrar professor (CREATE)
    public Professor CadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    //BUSCAR (READ)
    public List<Professor> BuscarProfessor() {
        return professorRepository.findAll();
    }

    //Buscar ID
    public Optional<Professor> BuscarProfessorId(Long id) {
        return professorRepository.findById(id);
    }

    //Atualizar
    public Professor atualizarProfessor(Long id, Professor professorAtualizado) {
        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setNomeProfessor(professorAtualizado.getNomeProfessor());
                    professor.setDisciplinaProfessor(professorAtualizado.getDisciplinaProfessor());
                    professor.setId(professorAtualizado.getId());
                    return professorRepository.save(professor);
                })
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    //DELETAR
    public void DeletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }

}

