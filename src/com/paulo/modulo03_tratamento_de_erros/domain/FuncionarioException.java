package com.paulo.modulo03_tratamento_de_erros.domain;

import com.paulo.modulo03_tratamento_de_erros.exceptions.LoginInvalidoException;

import java.io.FileNotFoundException;
import java.io.IOException;

/* Existem algumas regras que devem ser observadas ao estender métodos que podem lançar exceções.
   1° Não é obrigatório adicionar o throws das exceções da classe pai na assinatura do método da classe filha, pois a
      lógica do método pode ser diferente e não lançar exceção.
   2° Pode-se adicionar à assinatura um ou todos os throws definidos na classe pai e se quiser, pode adicionar também
      throws exceções do tipo RuntimeException, pois como elas não tem tratamanto obrigatório, é aceitável.
   3° Não é possível adicionar exceções do tipo checked que não estão definidas na classe pai.
   4° Não é possível adicionar a class filha exceções mais genéricas do que as declaradas na classe pai.
 */
public class FuncionarioException extends PessoaException{
    @Override // Não lança as exceções da classe pai.
    public void salvar(){

    }

    @Override // Pode lançar as duas exceptions da classe pai e adiciona uma RuntimeException
    public void salvar2() throws LoginInvalidoException, FileNotFoundException, RuntimeException {

    }

    @Override
    public void salvar3() throws LoginInvalidoException, IOException {

    }
}
