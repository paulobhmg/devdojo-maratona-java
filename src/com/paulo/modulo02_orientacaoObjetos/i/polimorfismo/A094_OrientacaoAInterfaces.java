package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain.SalvamentoNoArquivo;
import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain.SalvamentoNoBanco;
import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.interfaces.ISalvamento;

/* Programar para interfaces facilita na alteração da implementação de um sistema, com base em necessidades específicas.
   Por exemplo, em uma aplicação que faz o salvamento de um objeto, este poderá ser salvo em um arquivo ou em um banco
   de dados. Independente de onde ele está sendo salvo, a tarefa que será executada é a de salvar um arquivo. Sendo assim,
   Uma interface estabelecerá um contrato, definindo a assinatura para um método salvar(), que será implementado pelas
   classes que salvam um objeto, ou no banco de dados, ou em um arquivo de texto, de acordo com a regra de negócio
   estabelecida. */
public class A094_OrientacaoAInterfaces {
    public static void main(String[] args) {
        ISalvamento salvamento = new SalvamentoNoBanco();
        salvamento.salvar();

        /* Os objetos que salvam no banco implementam a mesma interface ISalvamento. Sendo assim, caso seja necessário
           o polimorfismo permite utilizar uma Interface genérica para altera a implementação utilizada na regra de negócio
           sem a necessidade de alterar no restante do código. */
        salvamento = new SalvamentoNoArquivo();
        salvamento.salvar();
    }
}
