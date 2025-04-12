package com.teste.projeto.repository;

import com.teste.projeto.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {

}
