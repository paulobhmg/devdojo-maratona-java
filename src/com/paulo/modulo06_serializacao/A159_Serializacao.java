package com.paulo.modulo06_serializacao;

import com.paulo.modulo06_serializacao.domain.AlunoSerializavel;
import com.paulo.modulo06_serializacao.domain.TurmaNaoSerializavel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Quando precisamos salvar um objeto em um arquivo, o Java precisa trabalhar com o fluxo de dados em bytes, serializando
   um arquivo. Para serializar um arquivo é necessário que ele seja serializável, ou seja, implemente a interface Serializable.

   Quando fazemos o processo reverso, ou seja, desserializar um objeto, não é utilizado um construtor. É importante estar
   atento a essa observação para os casos em que um objeto possui herança e dentro do seu construtor é chamado o super()
   da classe pai.

   Quando um objeto possui uma associação e o objeto associado não é serializável e não temos o controle sobre o código,
   precisamos especificar ao Java, na classe que será serializada, como deverá ser feito a serialização dos atributos do
   objeto, para que possamos utilizá-los para criar um objeto no momento de desesserializar.
 */
public class A159_Serializacao {
    public static void main(String[] args) {
        AlunoSerializavel aluno = new AlunoSerializavel(1L, "Paulo", "12345");
        Path path = Paths.get("src/com/paulo/modulo06_serializacao/files/aluno.ser");
        aluno.setTurma(new TurmaNaoSerializavel("Java de bixão."));
        serialize(aluno);
        unserialize(path);
    }

    public static void serialize(AlunoSerializavel aluno){
        Path path = Paths.get("src/com/paulo/modulo06_serializacao/files/aluno.ser");

        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            if(Files.notExists(path)){
                Files.createFile(path);
            }
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unserialize(Path path){
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            AlunoSerializavel aluno = (AlunoSerializavel) ois.readObject();
            System.out.println(aluno);
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
