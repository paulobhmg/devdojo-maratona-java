package com.paulo.modulo09_classes_internas.domain;

public class OuterLocalClass {
    private String outerLocalClassName = "OuterLocalClass name";

    /* As variáveis locais, em métodos que possuem classes locais, são obrigatoriamente final ou efetivamente final.
       Dizer que um atributo é efetivamente final significa que mesmo ele não sendo declarado como final, não poderá ter
       seu valor alterado. */
    public void defineAndUseLocalClass() {
        String finalName = "Nome final";

        // Os únicos modificadores de acesso permitidos para classes locais são default, public ou abstract.
        class InnerLocalClass {
            String innerLocalClassAttribute = "Inner attribute";
            public void printInternalClass(){
                innerLocalClassAttribute = "new"; // Atributos da classe local poderão ser alterados dentro do método.
                System.out.println(OuterLocalClass.this.outerLocalClassName + " - " + finalName + ", " + innerLocalClassAttribute);
            }
        }

        /* A única forma de utilizar uma classe local é instanciando-a dentro do método a qual ela pertence e
           invocando o método. Isso é necessário pois o ciclo de vida dessa classe se encerra juntamente com o método,
           portanto, só é possível acessá-la durante a execução do método e ela não está disponível em classes externas. */
        InnerLocalClass inner = new InnerLocalClass();
        inner.printInternalClass();
    }
}
