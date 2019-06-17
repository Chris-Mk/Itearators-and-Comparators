package StackIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CustomStack<Integer> implements Iterable<Integer> {
    private List<Integer> stack;

    public CustomStack() {
        this.stack = new Stack<>();
    }

    public void push(Integer element) {
        this.stack.add(element);
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.stack.remove(this.stack.size() - 1);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    public final class CustomIterator implements Iterator<Integer> {
        private int index = stack.size() - 1;
        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public Integer next() {
            return stack.get(index--);
        }
    }

}
