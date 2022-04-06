package com.paulo.modulo03_tratamento_de_erros.exceptions;

public class LoginInvalidoException extends Exception{
    public LoginInvalidoException() {
        super();
    }

    public LoginInvalidoException(String message){
        super(message);
    }
}
