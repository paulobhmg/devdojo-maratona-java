/* Um bloco estático será executado antes dos blocos não estáticos.
   Blocos estáticos são executados apenas uma vez, sendo o primeiro componente executado dentro da classe.

   Blocos estáticos podem acessar apenas atributos estáticos, pois assim como os métodos estáticos, blocos estáticos
   são executados antes mesmo da alocação de espaço em memória para instanciação do objeto.

   Entendendo blocos e o modificador estático, temos então a seguinte ordem de inicialização:

   1° - Atributos estáticos recebem valores padrão ou atribuidos
   2° - Bloco estático é executado (Esse será executado apenas uma vez, ou seja, ao instanciar o primeiro objeto)
   3° - Alocação de espaço em memória para o objeto
   4° - Atributos de instância recebem valores padrão ou atribuídos
   5° - Blocos de inicialização comuns são executados
   6° - Construtor é executado.

   Essa ordem ainda irá sofrer alterações quando houver herança de classes (assunto futuro). */
package com.paulo.modulo02_orientacaoObjetos.c_sequencia_de_inicializacao.domain;

public class AnimeComBlocoEstatico {
    private String nome;
    private int episodios;
    private static boolean teste;

    {
        System.out.println("Dentro do bloco comum (Executado - Instanciado novo objeto)");
        this.nome = "Nome Padrão";
    }

    static {
        System.out.println("Dentro do bloco estático (Executado uma única vez)");
        teste = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "AnimeComBlocoEstatico{" +
                "nome='" + nome + '\'' +
                ", episodios=" + episodios +
                '}';
    }

    public static boolean isTeste() {
        return teste;
    }

    public static void setTeste(boolean teste) {
        AnimeComBlocoEstatico.teste = teste;
    }
}
