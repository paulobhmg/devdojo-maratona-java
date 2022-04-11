package com.paulo.modulo02_orientacaoObjetos.c_sequencia_de_inicializacao.domain;

public class AnimeComBlocoDeInicializacao {
    private String nome = "Shingeki no kyojin";
    private int episodios = 120;

    {
        System.out.printf("Nome antes do bloco de execução: %s, %d.\n", nome, episodios);
        this.nome = "NULL";
        this.episodios = 0;
    }

    public AnimeComBlocoDeInicializacao(){
        System.out.printf("Nome dentro do construtor: %s, %d.\n", this.nome, this.episodios);
    }

    public AnimeComBlocoDeInicializacao(String nome, int episodios){
        System.out.printf("Nome dentro do construtor (Vai ser alterado): %s, %d.\n", this.nome, this.episodios);
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
