package com.paulo.modulo10_programacao_funcional.interfaces;

@FunctionalInterface
public interface TriFunction <T, U, V, R> {
    R apply(T t, U u, V v);
}
