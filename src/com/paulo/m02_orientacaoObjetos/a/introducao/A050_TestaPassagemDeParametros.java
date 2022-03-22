/* Quando passamos argumentos para métodos, a forma como eles são trados é diferente, de acordo com o seu tipo.
   Ao passar valores do tipo primitivo como argumentos de métodos, é criado uma cópia do valor. Sendo assim,
   as alterações feitas nas variáveis dentro do método não serão refletidas fora do método, após sua execução.

   Já para os argumentos do tipo referência, o que é passado como argumento é a referência ao objeto, ou seja, dentro do
   método essas variáveis continuam apontando para o mesmo local da memória onde está o objeto e todas as modificações
   feitas em argumentos do tipo REFERENCE refletirão no objeto ao qual esão fazendo referência, alterando seu estado.
 */

package com.paulo.m02_orientacaoObjetos.a.introducao;

import com.paulo.m02_orientacaoObjetos.a.introducao.domain.Aluno;

public class A050_TestaPassagemDeParametros {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        Aluno aluno = new Aluno(29, "Paulo", 'M');

        System.out.printf("Valores fora do metodo, antes da chamada: %d, %d\n", num1, num2);
        imprimeParametrosPrimitivos(num1, num2);
        System.out.printf("Valores fora do metodo, depois da chamada: %d, %d\n", num1, num2);
        System.out.println("-----------------------------------------------");

        System.out.printf("Aluno fora do método, antes da chamada: %s\n", aluno);
        imprimeParametrosReferencia(aluno);
        System.out.printf("Aluno fora do método, depois da chamada: %s\n", aluno);
    }

    public static void imprimeParametrosReferencia(Aluno aluno) {
        aluno.setNome("Nadille");
        aluno.setSexo('F');
        aluno.setIdade(23);
        System.out.printf("Aluno dentro do método: %s\n", aluno);
    }

    public static void imprimeParametrosPrimitivos(int param1, int param2){
        param1 *= 10;
        param2 *= 10;
        System.out.printf("Valores dentro do método: %d, %d\n", param1, param2);
    }
}
