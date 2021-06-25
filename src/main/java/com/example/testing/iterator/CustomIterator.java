package com.example.testing.iterator;

public interface CustomIterator<T> {

    boolean hasNext();

    T next();

    default void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    void forEach();
}
