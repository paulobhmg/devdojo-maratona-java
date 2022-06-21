package com.paulo.modulo09_classes_internas;

/* Uma NestedStaticClass funciona basicamente como uma classe interna comum, porém, ela funcionará como se estivesse
   no mesmo nível da classe, como se fosse uma outra classe dentro do mesmo arquivo. Uma NestedStaticClass é definida
   por questões de empacotamento, pois não há a necessidade de criar uma classe no mesmo nível que a classe origiária
   do arquivo .Java.
   Elas não podem acessar os atributos não estáticos da classe original, sendo necessário instanciar um objeto dessa classe
   para que seus atributos possam ser acessados e manipulados.

   Não é necessário ter uma instância da classe original para obter uma instância da classe estática interna, pois ela
   estará definida antes mesmo da existência da classe cumum. */
public class A192_NestedStaticClass {
    private String name = "External name";

    static class NestedClass {
        public void print(){
            System.out.println(new A192_NestedStaticClass().name);
        }
    }

    public static void main(String[] args) {
        NestedClass nested = new NestedClass();
        nested.print();
    }
}
