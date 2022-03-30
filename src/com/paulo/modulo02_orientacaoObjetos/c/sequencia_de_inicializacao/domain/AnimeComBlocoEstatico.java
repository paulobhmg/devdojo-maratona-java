/* Um bloco estático será executado antes dos blocos não estáticos.
   Blocos estáticos são executados apenas uma vez, sendo o primeiro componente executado dentro da classe.

   Blocos estáticos podem acessar apenas atributos estáticos, pois assim como os métodos estáticos, blocos estáticos
   são executados antes mesmo da alocação de espaço em memória para instanciação do objeto. */
package com.paulo.modulo02_orientacaoObjetos.c.sequencia_de_inicializacao.domain;

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
