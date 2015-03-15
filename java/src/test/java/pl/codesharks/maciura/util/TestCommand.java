package pl.codesharks.maciura.util;

public interface TestCommand<T1, T2> {
    T2 execute(T1 x);
}
