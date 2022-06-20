package com.paulo.modulo09_classes_internas;

import com.paulo.modulo09_classes_internas.domain.OuterLocalClass;

/* Uma classe local é uma classe utilizada dentro de um bloco anônimo ou um método, dentro da classe principal.
   Assim como uma InnerClass comum, uma LocalClass pode acessar os atributos da classe principal.

   Ver anotações gerais na classe OuterLocalClass. */
public class A190_ClassesLocais {
    public static void main(String[] args) {
        OuterLocalClass outerLocalClass = new OuterLocalClass();
        outerLocalClass.defineAndUseLocalClass();
    }
}
