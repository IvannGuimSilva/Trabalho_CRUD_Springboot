package com.classes;

import com.classes.model.Aluno;
import com.classes.model.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

import java.math.BigDecimal;


@Controller
public class AtualizarAlunoController {

    @Autowired
    private ApplicationContext context;



    @GetMapping("atualizar/{idAluno}")
    public String irPFormAtualizar(
            @PathVariable("idAluno") int idAluno, Model model) {

        AlunoService aluno_dao = context.getBean(AlunoService.class);
        Map<String, Object> dadosCaptados = aluno_dao.escolherAluno(idAluno);

        BigDecimal nota = (BigDecimal) dadosCaptados.get("nota");
        double notaDouble = nota.doubleValue();

        Aluno alunoAeditar = new Aluno(
                (String)dadosCaptados.get("nome"),
                (String)dadosCaptados.get("sexo"),
                notaDouble,
                (int)dadosCaptados.get("idade")
        );

        model.addAttribute("antigoAlunoDados", alunoAeditar);
        model.addAttribute("idAntigoAluno", idAluno);

        return "formAtualizarAluno";
    }



    @PostMapping("/atualizar/{idAluno}")
    public String atualizandoAluno(
            @PathVariable("idAluno") int idAluno,
            @ModelAttribute Aluno alunoAtualizado)
    {
            AlunoService aluno_dao = context.getBean(AlunoService.class);
            aluno_dao.atualizarAlunoEscolhido(
                    idAluno,
                    alunoAtualizado
            );

            return "redirect:/todos";
    }
}
