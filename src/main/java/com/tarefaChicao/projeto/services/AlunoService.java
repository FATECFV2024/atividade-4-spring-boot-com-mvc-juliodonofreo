package com.tarefaChicao.projeto.services;

import com.tarefaChicao.projeto.daos.AlunoRepository;
import com.tarefaChicao.projeto.dtos.AlunoDTO;
import com.tarefaChicao.projeto.entities.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository repository;

    public List<AlunoDTO> findAll(){
        List<Aluno> list = (List<Aluno>) repository.findAll();
        return list.stream().map(AlunoDTO::new).toList();
    }

    public AlunoDTO findByID(Long id){
        Aluno entity = repository.findById(id).get();
        return new AlunoDTO(entity);
    }

    public AlunoDTO insert(AlunoDTO dto) {
        Aluno entity = new Aluno();

        entity.setNome(dto.getNome());
        entity.setCurso(dto.getCurso());
        entity.setIdade(dto.getIdade());
        entity.setIdade(dto.getIdade());
        entity.setMatricula(dto.isMatricula());

        entity = repository.save(entity);
        return new AlunoDTO(entity);
    }

    public AlunoDTO update(Long id, AlunoDTO dto) {
        Aluno entity = repository.findById(id).get();

        entity.setNome(dto.getNome());
        entity.setCurso(dto.getCurso());
        entity.setIdade(dto.getIdade());
        entity.setIdade(dto.getIdade());
        entity.setMatricula(dto.isMatricula());

        entity = repository.save(entity);
        return new AlunoDTO(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
