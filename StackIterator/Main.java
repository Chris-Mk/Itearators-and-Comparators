package StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CustomStack<Integer> customStack = new CustomStack<>();

        String input;
        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+|,\\s+");

            switch (data[0]) {
                case "Push":
                    for (int i = 1; i < data.length; i++) {
                        customStack.push(Integer.parseInt(data[i]));
                    }
                    break;
                case "Pop":
                    customStack.pop();
                    break;
            }
        }

        customStack.forEach(System.out::println);
        customStack.forEach(System.out::println);
    }
}
