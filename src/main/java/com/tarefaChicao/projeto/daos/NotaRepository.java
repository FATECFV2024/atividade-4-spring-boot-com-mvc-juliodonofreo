package com.tarefaChicao.projeto.daos;

import com.tarefaChicao.projeto.entities.Nota;
import org.springframework.data.repository.CrudRepository;

public interface NotaRepository extends CrudRepository<Nota, Long> {
}
