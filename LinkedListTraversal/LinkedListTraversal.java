package LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListTraversal<T> implements Iterable<T> {
    private List<T> list;
    private T head;
    private T tail;

    public LinkedListTraversal(List<T> list) {
        this.list = new ArrayList<>();
        this.head = null;
        this.tail = null;
    }

    public void add(T element) {
        this.list.add(element);

        if (this.list.isEmpty()) {
            this.head = this.tail = element;
        } else {
            this.head = this.tail;
            this.tail = element;
        }
    }

    public boolean remove(T element) {
        int index = this.list.indexOf(element);
        return this.list.remove(element);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < list.size();
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }
}
