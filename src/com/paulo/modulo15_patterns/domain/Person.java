package com.paulo.modulo15_patterns.domain;

public class Person {
    private String name;
    private String lastName;
    private String nickname;
    private int age;

    public Person() {}

    public Person(String name, String lastName, String nickname, int age) {
        this.name = name;
        this.lastName = lastName;
        this.nickname = nickname;
        this.age = age;
    }

    /* Para instanciar um builder é necessário que a classe que será instanciada tenha um método estático que instancia
       um Buider(). A partir da instânica do builder, podemos atribuir valores aos atributos de classe de forma explícita
       e individual. Cada vez que chamamos um método do builder, alteramos suas propriedades e retornamos a referência
       ao mesmo objeto. Sendo assim, casa alteração modificará sempre o mesmo objeto.

       Um builder deve ter um método que retorna o objeto que queremos instanciar. Esse metodo basicamente irá instanciar
       o objeto, passando em seu construtor os atributos do builder, mas também pode construir um novo objeto de acordo
       com uma regra de negócio específica, então um método build(), pode haver uma lógica complexa de construção de objeto.
       Esse método deverá ser o último a ser executado pelo Builder, ou seja, somente depois de atribuir todos os valores. */
    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static final class PersonBuilder {
        private String name;
        private String lastName;
        private String nickname;
        private int age;

        /* Cada vez que chamamos um método do builder, alteramos suas propriedades e retornamos a referência
           ao mesmo objeto. Sendo assim, casa alteração modificará sempre o mesmo objeto. */
        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder nickname(String nickname) {
            this.nickname= nickname;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(name, lastName, nickname, age);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
