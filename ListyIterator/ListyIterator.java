package ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private static final int INIT_START_INDEX = 0;

    private List<String> list;
    private int index;

    ListyIterator(List<String> list) {
        this.list = list;
        this.index = INIT_START_INDEX;
    }

    boolean move() {
        if (this.index < this.list.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    boolean hasNext() {
        return this.index + 1 < this.list.size();
    }

    void print() {
        if (this.index < this.list.size()) {
            System.out.println(this.list.get(this.index));
        } else {
            System.out.println(("Invalid Operation!"));
        }
    }

    void printAll() {
        System.out.println(String.join(" ", this.list));
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < list.size();
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }
}
