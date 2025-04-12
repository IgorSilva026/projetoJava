package com.teste.projeto.Controller;


import com.teste.projeto.model.Aluno;
import com.teste.projeto.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //Listar eles
    @GetMapping
    public String listaAlunos(Model model){
        List<Aluno> alunos = alunoService.BuscarAluno();
        model.addAttribute("alunos", alunos);
        return "alunos/listar";
    }

    //formulario
    @GetMapping("/novo")
    public String novoAlunoForm(Model model){
        model.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }

    //Salva novo aluno
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno){
        alunoService.SalvarAluno(aluno);
        return "redirect:/alunos";
    }

    //form para editar
    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.BuscarAlunoPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        model.addAttribute("aluno", aluno);
        return "alunos/form";
    }

    //Atualizar dados dos alunos
    @PostMapping("/atualizar/{id}")
    public String atualizarAluno(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        alunoService.AlterarAluno(id, aluno);
        return "redirect:/alunos";
    }

    // Deletar aluno (Delete)
    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.ExcluirAluno(id);
        return "redirect:/alunos";
    }
}

