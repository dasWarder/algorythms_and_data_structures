package com.example.testing.iterator;

import com.example.testing.list.linkedList.DoublyLinkedList;
import com.example.testing.list.linkedList.link.Link;

public class CustomListIterator<T, E extends DoublyLinkedList<T>> implements CustomIterator<T> {

    private E list;

    private Link<T> current;

    public CustomListIterator(E list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {

        if( list.getFirst() != null
                                    && current == null) {
            return true;

        } else {

            return current.getNext() != null;
        }
    }

    @Override
    public T next() {

        if(current == null
                           && list.getFirst() != null) {

            current = list.getFirst();

            return current.getValue();

        } else {

            Link<T> nextLink = current.getNext();

            setLinks();

            return nextLink.getValue();
        }
    }

    @Override
    public void forEach() {

        while(hasNext()) {

            System.out.println(next());

        }
    }

    private void setLinks() {

        current = current.getNext();
    }
}
