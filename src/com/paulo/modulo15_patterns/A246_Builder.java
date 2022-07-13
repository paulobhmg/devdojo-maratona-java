package com.paulo.modulo15_patterns;

import com.paulo.modulo15_patterns.domain.Person;

/* O padrão de projetos Builder ajuda na construção de objetos, que pode ser complexa em algumas situações devido à
   quantidade de argumentos que o construtor de um objeto pode receber. Por exemplo, a classe Person recebe 4 argumentos
   em seu construtor, mas poderia ser muito mais. Neste caso, haveria a possibilidade de confundir na hora de passar
   os argumentos e até mesmo passar argumentos incorretos.

   Sendo assim, um builder constroi um objeto de forma mais clara, possibilitando visualizar exatamente o que está sendo
   atribuido a cada atributo.

   O Intellij possui um PLUG que facilita a criação de um builder: Builder Generator. */
public class A246_Builder {
    public static void main(String[] args) {
        Person person = new Person("Paulo", "Nogueira", "Paulinho", 29);
        System.out.println(person);

        // Construíndo Person a partir do Builder.
        Person personBuilder = Person.builder()
                .name("Tiago")
                .lastName("Nogueira")
                .nickname("Vesgo")
                .age(37)
                .build();
        System.out.println(personBuilder);
    }
}
