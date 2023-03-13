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

import java.util.List;
import java.util.Map;

@Controller
public class EstudanteController {

    @Autowired
    private ApplicationContext context;


    /* Definindo outras rotas do (Estudante / Aluno) ... */
    /* Definindo Index */

    @GetMapping("/")
    public String criarAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "criarAluno";
    }


    @PostMapping("/criado") /* Criando novo Aluno */
    public String acaoCadastrar(@ModelAttribute Aluno aluno) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        aluno_dao.insert(aluno);
        return "redirect:/todos";
    }

    @PostMapping("/apagar/{idAluno}")
    public String apagarAluno(@PathVariable("idAluno") int idAluno) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        aluno_dao.deletarAluno(idAluno);
        return "redirect:/todos";
    }

    /* --- Definindo controllers p/ chegar às listas de alunos: --- */

    @GetMapping("/todos")
    public String listaTodos(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaAlunos = aluno_dao.getAllAlunos();
        model.addAttribute("allAlunosLista", listaAlunos);
        return "todosOsAlunos";
    }

    @GetMapping("/homens")
    public String listaHomens(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaHomens = aluno_dao.getAllHomens();
        model.addAttribute("allHomensLista", listaHomens);
        return "alunosHomens";
    }

    @GetMapping("/mulheres")
    public String listaMulheres(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaMulheres = aluno_dao.getAllMulheres();
        model.addAttribute("allMulheresLista", listaMulheres);
        return "alunasMulheres";
    }

    @GetMapping("/reprovados")
    public String listaReprovados(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaReprovados = aluno_dao.getAllReprovados();
        model.addAttribute("allReprovadosLista", listaReprovados);
        return "alunosReprovados";
    }

    @GetMapping("/si")
    public String listaSi(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaDeSI = aluno_dao.getAllAlunosSI();
        model.addAttribute("allDeSILista", listaDeSI);
        return "alunosDeSi";
    }

    @GetMapping("/ads")
    public String listaADS(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaDeADS = aluno_dao.getAllAlunosADS();
        model.addAttribute("allDeADSLista", listaDeADS);
        return "alunosDeAds";
    }

    @GetMapping("/log")
    public String listaLog(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaDeLOG = aluno_dao.getAllAlunosLOG();
        model.addAttribute("allDeLOGLista", listaDeLOG);
        return "alunosDeLog";
    }

    @GetMapping("/ge")
    public String listaGe(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaDeGE = aluno_dao.getAllAlunosGE();
        model.addAttribute("allDeGELista", listaDeGE);
        return "alunosDeGe";
    }

    @GetMapping("/gp")
    public String listaGp(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaDeGP = aluno_dao.getAllAlunosGP();
        model.addAttribute("allDeGPLista", listaDeGP);
        return "alunosDeGp";
    }

}
