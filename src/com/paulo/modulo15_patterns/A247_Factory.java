package com.paulo.modulo15_patterns;

import com.paulo.modulo15_patterns.domain.CountryEnum;
import com.paulo.modulo15_patterns.domain.CurrencyFactory;
import com.paulo.modulo15_patterns.domain.ICurrency;

/* O padrão de projeto Factory possibilita desacoplar a lógica para a construção deu um objeto, permitindo
   criar um objeto com base em lógicas específicas.

   Neste exemplo, temos duas classes, real e dolar, que implementam a interface ICurrency, que fornece um método para
   recuperar qual é a moeda local.

   Com base nisso, a CurrencyFactory retorna uma instância de um objeto, podendo retornar ou Real ou Dolar, de acordo
   com a enumeração passada como argumento do método makeCurrency() */
public class A247_Factory {
    public static void main(String[] args) {
        ICurrency real = CurrencyFactory.makeCurrency(CountryEnum.BRAZIL);
        ICurrency dolar = CurrencyFactory.makeCurrency(CountryEnum.USA);

        System.out.println(real.getCurrency());
        System.out.println(dolar.getCurrency());
    }
}
