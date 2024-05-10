package com.tarefaChicao.projeto.dtos;

import com.tarefaChicao.projeto.entities.Aluno;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String curso;
    private int idade;
    private boolean matricula;

    public AlunoDTO(Long id, String nome, String curso, int idade, boolean matricula) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
        this.matricula = matricula;
    }

    public AlunoDTO(Aluno entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.curso = entity.getCurso();
        this.idade = entity.getIdade();
        this.matricula = entity.isMatricula();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isMatricula() {
        return matricula;
    }
}
