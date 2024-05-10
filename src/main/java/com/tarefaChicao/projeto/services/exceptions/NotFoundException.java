package com.tarefaChicao.projeto.services.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg) {
        super(msg);
    }
}
