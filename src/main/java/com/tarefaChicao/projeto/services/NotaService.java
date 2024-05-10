package com.tarefaChicao.projeto.services;

import com.tarefaChicao.projeto.daos.NotaRepository;
import com.tarefaChicao.projeto.dtos.NotaMinDTO;
import com.tarefaChicao.projeto.entities.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
     private NotaRepository repository;

    public List<NotaMinDTO> findAll(){
        List<Nota> list = (List<Nota>) repository.findAll();
        return list.stream().map(NotaMinDTO::new).toList();
    }

    public NotaMinDTO findByID(Long id){
        Nota entity = repository.findById(id).get();
        return new NotaMinDTO(entity);
    }

    public NotaMinDTO insert(NotaMinDTO dto) {
        Nota entity = new Nota();

        entity.setNota(dto.getNota());
        entity.setNome_disciplina(dto.getNome_disciplina());

        entity = repository.save(entity);
        return new NotaMinDTO(entity);
    }

    public NotaMinDTO update(Long id, NotaMinDTO dto) {
        Nota entity = repository.findById(id).get();

        entity.setNota(dto.getNota());
        entity.setNome_disciplina(dto.getNome_disciplina());

        entity = repository.save(entity);
        return new NotaMinDTO(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
