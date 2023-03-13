package com.classes.model;

public class Aluno {

    private int id;
    private String nome;
    private String sexo;
    private int codigoCurso;
    private double nota;
    private int idade;

    public Aluno() {}

    public Aluno( String nome, String sexo, double nota, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.nota = nota;
        this.idade = idade;
    }

    public Aluno( String nome, String sexo, int codigoCurso, double nota, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.codigoCurso = codigoCurso;
        this.nota = nota;
        this.idade = idade;
    }

    public Aluno(int id, String nome, String sexo, int codigoCurso, double nota, int idade) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.codigoCurso = codigoCurso;
        this.nota = nota;
        this.idade = idade;
    }

    // Setters:

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
       this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getters:

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSexo() {
        return this.sexo;
    }

    public int getCodigoCurso() {
        return this.codigoCurso;
    }

    public double getNota() {
        return this.nota;
    }

    public int getIdade() {
        return this.idade;
    }
}



 /*
      AVISO IMPORTANTÍSSIMO!!!

      Caso o nome dos atributos não seja compatível com o nome
      dos seus métodos...

      Exmeplo:

      private int codigoCurso; <- atributo
      public int getCodigoCurso() <- método get

      note que a palavra "codigoatributo" aparece em ambos, independente de
      letras maiusculas

      .. o Thymeleaf será incapaz de fazer a alimentação na view,
      impossibilitando vc de cadastrar o usuário ou qualquer outra
      coisa do tipo... :P

    */
