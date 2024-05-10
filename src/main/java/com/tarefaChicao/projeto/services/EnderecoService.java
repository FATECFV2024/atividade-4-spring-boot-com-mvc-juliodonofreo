package com.tarefaChicao.projeto.services;

import com.tarefaChicao.projeto.dtos.AlunoMinDTO;
import com.tarefaChicao.projeto.dtos.EnderecoDTO;
import com.tarefaChicao.projeto.entities.Aluno;
import com.tarefaChicao.projeto.entities.Endereco;
import com.tarefaChicao.projeto.repositories.AlunoRepository;
import com.tarefaChicao.projeto.repositories.EnderecoRepository;
import com.tarefaChicao.projeto.services.exceptions.DatabaseException;
import com.tarefaChicao.projeto.services.exceptions.NotFoundException;
import com.tarefaChicao.projeto.services.utils.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<EnderecoDTO> findAll(){
        List<Endereco> list = (List<Endereco>) repository.findAll();
        return list.stream().map(EnderecoDTO::new).toList();
    }

    public EnderecoDTO findByID(Long id){
        Endereco entity = repository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessages.ENDERECO_NAO_ENCONTRADO));
        return new EnderecoDTO(entity);
    }

    public EnderecoDTO insert(EnderecoDTO dto) {
        Endereco entity = new Endereco();
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new EnderecoDTO(entity);
    }

    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        Endereco entity = repository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessages.ENDERECO_NAO_ENCONTRADO));
        copyDtoToEntity(entity, dto);

        entity = repository.save(entity);
        return new EnderecoDTO(entity);
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(ErrorMessages.ENDERECO_NAO_PODE_DELETAR);
        }
    }

    private void copyDtoToEntity(Endereco entity, EnderecoDTO dto){
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setNumero(dto.getNumero());
        entity.setRua(dto.getRua());

        for (AlunoMinDTO alunoDTO : dto.getAlunos()) {
            Aluno aluno = alunoRepository.findById(alunoDTO.getId()).orElseThrow(() -> new NotFoundException(ErrorMessages.ALUNO_NAO_ENCONTRADO));;
            aluno.getEnderecos().add(entity);
            entity.getAlunos().add(aluno);
        }
    }
}
