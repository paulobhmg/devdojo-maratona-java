package com.paulo.modulo09_classes_internas.domain;

public class OuterClass {
    private String outerClassName = "OuterClass name";

    /* Uma clase Interna é como se fosse um atributo da classe externa e tem acesso à todos os seus atributos, mesmo
       que eles sejam privados. Assim como atributos de instância, para que seja possível acessar esse atributo é necessário
       especificar o modificador de acesso e caso ele seja privado, é necessário haver um método get para recuperar a instância. */
    public class InnerClass {
        private String innerClassName = "InnerClass name";

        /* O this utiliza o escopo da classe em que está sendo chamado, ou seja, dentro da classe Interna, o this fará
           referência aos seus próprios atributos. Para fazer referência ao this da classe externa é necessário utilizar
           a sintaxe <nomeDaClasseExterna.this[.attribute]> */
        public void printOuterClassAttributes(){
            System.out.println("Reading outerclass atrributes: " + OuterClass.this.outerClassName);
        }

        public String getInnerClassName() {
            return innerClassName;
        }

        public void setInnerClassName(String innerClassName) {
            this.innerClassName = innerClassName;
        }
    }

    public String getOuterClassName() {
        return outerClassName;
    }

    public void setOuterClassName(String outerClassName) {
        this.outerClassName = outerClassName;
    }
}
