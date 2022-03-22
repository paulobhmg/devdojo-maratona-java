package com.paulo.m02_orientacaoObjetos.a.introducao;

public class A046_OrientacaoObjetos {
    public static void main(String[] args) {
        Aluno marilene = new Aluno(59, "Marilene", 'F');
        Aluno tiago = new Aluno(37, "Tiago", 'M');
        Aluno renato = new Aluno(34, "Renato", 'M');
        Aluno paulo = new Aluno(29, "Paulo", 'M');
        Aluno augusto = new Aluno(27, "Augusto", 'M');
        Aluno[] turma = new Aluno[5];

        turma[0] = marilene;
        turma[1] = tiago;
        turma[2] = renato;
        turma[3] = paulo;
        turma[4] = augusto;

        for(Aluno membro : turma){
            System.out.printf("%s\n", membro);
            System.out.println("-----------");
        }
    }
}
