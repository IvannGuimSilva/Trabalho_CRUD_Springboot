package com.classes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class AlunoDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    // inicializat Java Database Conectivity c/ Base de Dados
    // (PostGreSQL Heroku):

    @PostConstruct
    private  void  initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void insert(Aluno aluno) {

        String sql = "insert into aluno (nome, sexo, codigocurso, nota, idade) values(?,?,?,?,?)";

        jdbc.update(sql, new Object[] {
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getCodigoCurso(),
                aluno.getNota(),
                aluno.getIdade()
        });
    }

    public List<Map<String, Object>> getAllAlunos() {

        String sql = "select * from aluno";

        List<Map<String, Object>> listaAlunos = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaAlunos;
    }

    public List<Map<String, Object>> getAllHomens() {

        String sql = "select * from aluno where aluno.sexo = 'M'";
        List<Map<String, Object>> listaHomens = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaHomens;
    }

    public List<Map<String, Object>> getAllMulheres() {

        String sql = "select * from aluno where aluno.sexo = 'F'";
        List<Map<String, Object>> listaMulheres = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaMulheres;
    }

    public List<Map<String, Object>> getAllReprovados() {

        String sql = "select * from aluno where aluno.nota < 6";
        List<Map<String, Object>> listaReprovados = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaReprovados;
    }

    public List<Map<String, Object>> getAllAlunosSI() {

        String sql = "select * from aluno where aluno.codigocurso = 5";
        List<Map<String, Object>> listaDeAlunosSI = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaDeAlunosSI;
    }

    public List<Map<String, Object>> getAllAlunosADS() {

        String sql = "select * from aluno where aluno.codigocurso = 1";
        List<Map<String, Object>> listaDeAlunosADS = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaDeAlunosADS;
    }

    public List<Map<String, Object>> getAllAlunosLOG() {

        String sql = "select * from aluno where aluno.codigocurso = 4";
        List<Map<String, Object>> listaDeAlunosLOG = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaDeAlunosLOG;
    }

    public List<Map<String, Object>> getAllAlunosGE() {

        String sql = "select * from aluno where aluno.codigocurso = 2";
        List<Map<String, Object>> listaDeAlunosGE = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaDeAlunosGE;
    }

    public List<Map<String, Object>> getAllAlunosGP() {

        String sql = "select * from aluno where aluno.codigocurso = 3";
        List<Map<String, Object>> listaDeAlunosGP = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return listaDeAlunosGP;
    }

    public void deletarAluno(int idAluno) {
        String sql = "delete from aluno where id = ?";
        jdbc.update(sql, new Object[] {idAluno});
    }

    public Map<String, Object> escolherAluno(int idAluno) {
        String sql = "select nome, sexo, nota, idade from aluno where aluno.id = ?";
        return jdbc.queryForMap(sql, new Object[] {idAluno});
    }

    public void atualizarAlunoEscolhido(int idAluno, Aluno alunoAtualizado) {
        String sql = "update aluno set nome = ?, sexo = ?, nota = ?, idade = ? where id = ?";


        jdbc.update(sql, new Object[] {
                alunoAtualizado.getNome(),
                alunoAtualizado.getSexo(),
                alunoAtualizado.getNota(),
                alunoAtualizado.getIdade(),
                idAluno
        });
    }
}
