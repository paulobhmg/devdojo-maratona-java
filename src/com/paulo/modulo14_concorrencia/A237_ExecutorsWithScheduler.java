package com.paulo.modulo14_concorrencia;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class A237_ExecutorsWithScheduler {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Runnable r = () -> {
            System.out.println(LocalTime.now().format(dateTimeFormatter));
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        /* O método scheduler() irá executar uma única vez o Runnable passado como parãmetro e deverá ser finalizado
           após sua execução.

            System.out.println("Running with just scheduler... ");

            ScheduledFuture<?> schedule = executor.schedule(r, 5, TimeUnit.SECONDS);
            executor.shutdown();
            while(!executor.isTerminated()) {}
            System.out.println("The scheduler executed once and has shutdown.");
            System.out.println("------------------------------");
        */

        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);
        // ScheduledFuture<?> scheduledFuture = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);

        executor.schedule(() -> { // Esse bloco de código para a execução do scheduledFuture e finaliza o executor.
            System.out.println("Finishing the scheduler.");
            scheduledFuture.cancel(false);
            executor.shutdown();
        }, 15, TimeUnit.SECONDS);


        /* Os métodos scheduleAtFixedRate() e scheduleWithDelay() são agendadores que diferente do do scheduler comum,
           executam a rotina infinitamente em intervalo de tempo predefinido, a diferença entre os dois é que o primeiro
           considera o tempo contínuo passado, a partir do momento da sua execução, enquanto o segundo considera o tempo
           a partir do momento em que a Thread está disponível.

           Por exemplo, o Runnable criado acima dorme por 3 segundos, enquanto o Schedule executa o código a cada 5 segundos.
           O scheduleAtFixedRate() irá considerar os 3s do sleep() + 2s, completando os 5 segundos de intervalo, enquanto
           o scheduleWithDelay() vai aguardar o sleep() de 3s e só depois vai contar os 5s do seu intervalo, totalizando 8s.

           Ambos os schedulers ficarão rodando infinitamente, até que sejam cancelados pelo executor e finalizados
           como shutdow().
       */
    }
}
