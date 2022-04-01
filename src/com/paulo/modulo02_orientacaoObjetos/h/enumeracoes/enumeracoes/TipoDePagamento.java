/* Enumerações são tipos especiais de classes, utilizadas quando há a necessidade de padronizar valores informados pelo
   usuário. Como exemplo desta classe, temos 3 tipos de pagamento. A fim de evitar que cada usuário informe um tipo de
   pagamento de uma forma, utilizamos as enumerações, que tem esse valor fixado em seus atributos.

   Por padrão, as constantes de uma enumeração são públicas e não aceitam modificadores de acesso em sua definição.
   O construtor de uma enumeração é privado, ou seja, a própria classe irá atribuir a seus atributos, os valores passados
   em seu construtor. */

package com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.enumeracoes;

public enum TipoDePagamento {
    DEBITO(1, "Débito"){
        @Override
        public double calculaDesconto(double valor){
            return valor * 10 / 100;
        }
    },
    CREDITO(2, "Crédito"){
        @Override
        public double calculaDesconto(double valor){
            return 0;
        }
    },
    BOLETO(3, "Boleto"){
        @Override
        public double calculaDesconto(double valor){
            return valor * 0.2;
        }
    },
    TESTE(4, "Opção inválida"){
        @Override
        public double calculaDesconto(double valor){
            return 0;
        }
    };

    public final int codigo;
    public final String descricao;

    TipoDePagamento(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public abstract double calculaDesconto(double valor);

    public TipoDePagamento getPagamento(String descricao){
        for(TipoDePagamento tipoDePagamento : values()){
            if(tipoDePagamento.equals(valueOf(descricao))){
                return tipoDePagamento;
            }
        }
        return null;
    }
}
