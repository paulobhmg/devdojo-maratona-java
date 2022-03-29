/* Quando instanciamos um objeto, antes da execução do construtor, outros componentes são executados:
   1° - Alocação do espaço em memória
   2° - Inicia os atributos com os valores padrão ou valores atribuídos
   3° - Executa os blocos de inicialização
   4° - Executa o construtor

   Essa regra é válida quando não há atributos estáticos, blocos estáticos e herança. Em outra classe poderemos perceber que
   quando há esses outros itens, a ordem de execução será alterada.

   O bloco de inicialização definodo na classe será executado em cada instanciação de um objeto daquele tipo. */

package com.paulo.modulo02_orientacaoObjetos.c.sequencia_de_inicializacao.domain;

public class AnimeSemBlocoDeInicializacao {
    private String nome = "Shingeki no kyojin";
    private int episodios = 120;

    public AnimeSemBlocoDeInicializacao() {}

    public AnimeSemBlocoDeInicializacao(String nome){
        this.nome = nome;
    }

    // Ao instanciar um objeto a partir do construtor, os atributos definidos anteriormente receberão novos valores.
    public AnimeSemBlocoDeInicializacao(String nome, int episodios){
        System.out.printf("Atributos antes do construtor: Nome = %s, episodios = %d.\n", this.nome, this.episodios);
        this.nome = nome;
        this.episodios = episodios;
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
}
