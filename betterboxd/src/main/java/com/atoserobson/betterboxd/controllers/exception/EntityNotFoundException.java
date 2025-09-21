package com.atoserobson.betterboxd.controllers.exception;

public class EntityNotFoundException extends RuntimeException {

        public EntityNotFoundException(String mensagem) {
                super(mensagem);
        }

}
