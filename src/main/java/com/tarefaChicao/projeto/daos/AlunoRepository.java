package com.tarefaChicao.projeto.daos;

import com.tarefaChicao.projeto.entities.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}
