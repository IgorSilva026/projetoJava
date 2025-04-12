package com.teste.projeto.service;

import com.teste.projeto.model.Aluno;
import com.teste.projeto.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    //cadastrar alunos
    public Aluno SalvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    //Buscar Alunos
    public List<Aluno> BuscarAluno(){
        return alunoRepository.findAll();
    }

    //Buscar id
    public Optional<Aluno> BuscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }

    //Deletar
    public void ExcluirAluno(Long id){
        alunoRepository.deleteById(id);
    }

    //Atualizar
    public Aluno AlterarAluno(Long id, Aluno AtualizarAluno){
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeAluno(AtualizarAluno.getNomeAluno());
                    aluno.setIdadeAluno(AtualizarAluno.getIdadeAluno());
                    aluno.setMatriculaAluno(AtualizarAluno.getMatriculaAluno());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }
}
