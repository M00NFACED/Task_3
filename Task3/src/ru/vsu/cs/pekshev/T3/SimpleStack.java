package ru.vsu.cs.pekshev.T3;

public interface SimpleStack<T> {
    void push(T value);
    T pop() throws Exception;
    T peek() throws Exception;
    int count();
    boolean empty();
}
