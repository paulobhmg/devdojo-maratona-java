package com.paulo.modulo03_tratamento_de_erros;

public class A105_RegrasDeSobrescritaParaExceptions {
    /* Existem algumas regras que devem ser observadas ao estender métodos que podem lançar exceções.
       1° Não é obrigatório adicionar o throws das exceções da classe pai na assinatura do método da classe filha, pois a
          lógica do método pode ser diferente e não lançar exceção.
       2° Pode-se adicionar à assinatura um ou todos os throws definidos na classe pai e se quiser, pode adicionar também
          throws exceções do tipo RuntimeException, pois como elas não tem tratamanto obrigatório, é aceitável.
       3° Não é possível adicionar exceções do tipo checked que não estão definidas na classe pai.
       4° Não é possível adicionar a class filha exceções mais genéricas do que as declaradas na classe pai.

    ------ Ver as classes FuncionarioException e PessoaException em domain. */
}
