package com.example.testing.list.linkedList.link;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link<T> {

    private T value;

    private Link<T> prev;

    private Link<T> next;

    public Link(T value) {
        this.value = value;
    }
}
