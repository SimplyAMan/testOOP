package ua.study.queue;

public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    Object peek() ;

    int size();

    // [A, B, C]
    public String toString();
}