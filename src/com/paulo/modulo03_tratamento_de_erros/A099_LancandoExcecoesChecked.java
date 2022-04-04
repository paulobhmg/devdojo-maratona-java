package com.paulo.modulo03_tratamento_de_erros;

import java.io.File;
import java.io.IOException;

/* Qual é a diferença de tratar a exceção dentro do método ou lançar uma exceção?
    - Quando tratamos uma exceção dentro do método, o programa que chamou o método não terá opções para tratar de forma difererente,
      ou seja, como a exceção foi tratada dentro do próprio método, o oque fazer? E se eu quisesse tratar de forma diferente?
      Isso não seria possível, pois já foi tratado dentro do método.

    - Quando lançamos uma exceção, passamos a responsabilidade de de decidir o que será feito para quem está chamando o método.
      Qual é a vantagem disso? Se o sistema é grande e a funcionalidade de criar um arquivo, por exemplo, for compartilhada
      entre diversas classes, a tratativa para uma exception pode ser diferente para cada regra de negócio. Sendo assim,
      deixar a responsabilidade para quem chama o método, além de ampliar as possíveis tratativas do erro, mantém o baixo
      acoplamento do código e também mais limpo.

   Quando utilizar um ou outro?
    - Quando utilizamos métodos privados, esses não estarão disponíveis publicamente. Dessa forma, o tratamento da exceção
      deve ser feito dentro do método, pois as classes externas o desconhecem. Sendo assim, como tratariam esses erros?
    - Quando temos métodos públicos, é recomendável deixar apenas a lógica de execução do método e caso ele lance alguma
      exceção, que ela seja tratada externamente por quem está chamando o método.

    Normalmente, exceções lançadas serão do tipo RuntimeException, a fim de informar ao usuário que está acontecendo algo
    diferente do esperado durante a execução da aplição. Todavia, códigos que possuem exceções do tipo checked obrigatoriamente
    devem ser tratados, pois pode haver situações que estão além do controle do desenvolvedor. Nestes casos, uma exceção será
    lançada, assim como é feito o lançamento de uma exceção do tipo Runtime, a fim de informar que algo está errado. */
public class A099_LancandoExcecoesChecked {
    public static void main(String[] args) {
        try {
            boolean arquivoCriado = criarArquivo("src/com/paulo/modulo03_tratamento_de_erros/domain/arquivo2.txt");
            System.out.println("Arquivo criado? " + (arquivoCriado ? "Sim" : "Não"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean criarArquivo(String path) throws IOException {
        File arquivo = new File(path);
        return arquivo.createNewFile();
    }
}
