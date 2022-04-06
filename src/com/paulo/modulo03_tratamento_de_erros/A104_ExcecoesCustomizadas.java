package com.paulo.modulo03_tratamento_de_erros;

import com.paulo.modulo03_tratamento_de_erros.exceptions.LoginInvalidoException;

/* Exceções customizadas são utilizadas quando há a necessidade de tratar situações definidas pela regra de negocio, ou seja,
   regras que nao sao erros de logica ou erros que lancem uma exceçao do tipo checked, por exemplo. */
public class A104_ExcecoesCustomizadas {

    public static void main(String[] args) {
        try {
            logar("PaulO", "paulo");
        } catch(LoginInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean validaLogin(String usuario, String senha){
        return usuario.equalsIgnoreCase("paulo") && senha.equals("paulo");
    }

    public static void logar(String usuario, String senha) throws LoginInvalidoException {
        if(!validaLogin(usuario, senha)){
            throw new LoginInvalidoException("Usuario ou senha invalidos.");
        }
        System.out.println("Login efetuado com sucesso.");
    }

}
