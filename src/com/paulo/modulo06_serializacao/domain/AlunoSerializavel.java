package com.paulo.modulo06_serializacao.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* No caso do objeto Turma não ser serializável e o programador não ter controle sobre o seu código, é necessário implementar
   os métodos para escrita e leitura dos atributos do objeto. Os atributos serão serializados, mas não o objeto. Porém,
   no momento de desesserializar o objeto, será possível instanciar um objeto com base nos atributos que foram lidos do arquivo,
   pois esses serão os atributos transcritos no momento da serialização do objeto.
*/

public class AlunoSerializavel implements Serializable {
    private static final long serialVersionUID = -6142645513683898517L;

    private long id;
    private String name;
    private transient String password; // utilizamos transient quando não queremos que um atributo seja serializado
    private static final String school = "DEVDOJO"; // Atributos estáticos também não são serializados
    private transient TurmaNaoSerializavel turma;

    public AlunoSerializavel() {
    }

    public AlunoSerializavel(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TurmaNaoSerializavel getTurma() {
        return turma;
    }

    public void setTurma(TurmaNaoSerializavel turma) {
        this.turma = turma;
    }

    /* Neste caso, quando o Java for serializar este objeto, esse método privado será chamado e é aqui que é definido
       como um objeto deverá ser serializado. Neste caso, primeiro o objeto será escrito de forma padrão e posteriormente
       serão serializados todos os atributos dos objetos que não são serializados ou que são transientes. É importante
       observar a ordem em que é feito a escrita dos atributos, pois essa deverá ser seguida no momento da leitura. */
    private void writeObject(ObjectOutputStream oos){
        try{
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNome());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /* Quando o Java for desesserializar este objeto, o método abaixo será chamado. Esse método é quem vai determinar como
       o objeto será lido de um arquivo, por exemplo. A ordem de leitura dos atributos dos objetos não serializados ou intransientes
       deve ser a mesma definida no momento da serialização do arquivo. Após a leitura é possível obter um objeto com
       base nos atributos lidos. */
    private void readObject(ObjectInputStream ois){
        try {
            ois.defaultReadObject();
            turma = new TurmaNaoSerializavel(ois.readUTF());
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "AlunoSerializavel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", school='" + school + '\'' +
                ", class='" + turma + '\'' +
                '}';
    }
}
