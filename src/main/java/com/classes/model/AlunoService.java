package com.classes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    AlunoDAO alunoDAO;

    public void insert(Aluno aluno) {
        alunoDAO.insert(aluno);
    }

    public List<Map<String, Object>> getAllAlunos() {
        return alunoDAO.getAllAlunos();
    }

    public List<Map<String, Object>> getAllHomens() {
        return alunoDAO.getAllHomens();
    }

    public  List<Map<String, Object>> getAllMulheres() {
        return  alunoDAO.getAllMulheres();
    }

    public List<Map<String, Object>> getAllReprovados() {
        return alunoDAO.getAllReprovados();
    }

    public List<Map<String, Object>> getAllAlunosSI() {
        return alunoDAO.getAllAlunosSI();
    }

    public List<Map<String, Object>> getAllAlunosADS() {
        return alunoDAO.getAllAlunosADS();
    }

    public List<Map<String, Object>> getAllAlunosLOG() {
        return alunoDAO.getAllAlunosLOG();
    }

    public List<Map<String, Object>> getAllAlunosGE() {
        return alunoDAO.getAllAlunosGE();
    }

    public List<Map<String, Object>> getAllAlunosGP() {
        return alunoDAO.getAllAlunosGP();
    }

    public void deletarAluno(int idAluno) {
        alunoDAO.deletarAluno(idAluno);
    }

    public Map<String, Object> escolherAluno(int idAluno) {
        return alunoDAO.escolherAluno(idAluno);
    }

    public void atualizarAlunoEscolhido(int idAluno, Aluno alunoAtualizado) {

        alunoDAO.atualizarAlunoEscolhido(
                idAluno,
                alunoAtualizado
        );
    }
}
