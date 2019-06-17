package Froggy;

import java.util.*;

public class Lake<Integer> implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake() {
        this.numbers = new ArrayList<>();
    }

    public void add(Integer[] nums) {
        this.numbers.addAll(Arrays.asList(nums));
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public final class Frog implements Iterator<Integer> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return this.index < numbers.size();
        }

        @Override
        public Integer next() {
            return numbers.get(index++);
        }
    }

}
