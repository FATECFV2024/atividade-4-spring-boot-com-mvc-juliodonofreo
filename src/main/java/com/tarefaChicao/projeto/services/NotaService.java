package com.tarefaChicao.projeto.services;

import com.tarefaChicao.projeto.repositories.AlunoRepository;
import com.tarefaChicao.projeto.repositories.NotaRepository;
import com.tarefaChicao.projeto.dtos.NotaDTO;
import com.tarefaChicao.projeto.entities.Aluno;
import com.tarefaChicao.projeto.entities.Nota;
import com.tarefaChicao.projeto.services.exceptions.NotFoundException;
import com.tarefaChicao.projeto.services.utils.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
     private NotaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<NotaDTO> findAll(){
        List<Nota> list = (List<Nota>) repository.findAll();
        return list.stream().map(x -> new NotaDTO(x)).toList();
    }

    public NotaDTO findByID(Long id){
        Nota entity = repository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessages.NOTA_NAO_ENCONTRADA));
        return new NotaDTO(entity);
    }

    public NotaDTO insert(NotaDTO dto) {
        Nota entity = new Nota();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new NotaDTO(entity);
    }

    public NotaDTO update(Long id, NotaDTO dto) {
        Nota entity = repository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessages.NOTA_NAO_ENCONTRADA));
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new NotaDTO(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void copyDtoToEntity(Nota entity, NotaDTO dto){
        entity.setNota(dto.getNota());
        entity.setNome_disciplina(dto.getNome_disciplina());

        Aluno aluno = alunoRepository.findById(dto.getAluno().getId()).orElseThrow(() -> new NotFoundException(ErrorMessages.ALUNO_NAO_ENCONTRADO));
        entity.setAluno(aluno);
    }
}
