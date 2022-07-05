package com.paulo.modulo14_concorrencia.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapReadWriter {
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    private ReentrantReadWriteLock lock;

    public MapReadWriter (ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    public void put(Integer key, Integer value) {
        lock.writeLock().lock();
        try {
            System.out.printf("Thread %s got the writeLock.\n", Thread.currentThread().getName());
            map.put(key, value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Set<Map.Entry<Integer, Integer>> reader() {
        if(lock.isWriteLocked()) {
            try {
                System.out.print("WRITE LOCK!!\n");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        lock.readLock().lock();
        try {
            System.out.printf("Thread %s is saying finally got this lock.\n", Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + ": " + map.entrySet());
        return map.entrySet();
    }
}
