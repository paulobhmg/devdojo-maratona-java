package com.paulo.modulo03_tratamento_de_erros.domain;

import com.paulo.modulo03_tratamento_de_erros.exceptions.LoginInvalidoException;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class PessoaException {
    public abstract void salvar() throws LoginInvalidoException, FileNotFoundException;
    public abstract void salvar2() throws LoginInvalidoException, FileNotFoundException;
    public abstract void salvar3() throws LoginInvalidoException, IOException;
}
