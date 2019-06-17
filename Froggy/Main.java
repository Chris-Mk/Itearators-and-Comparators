package Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Lake<Integer> lake = new Lake<>();
        String input;

        while (!"END".equals(input = scan.nextLine())) {
            Integer[] numbers = Arrays.stream(input.split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            Integer[] temp = new Integer[numbers.length];

            int counter = 0;
            for (int i = 0; i < numbers.length; i += 2) {
                temp[counter++] = numbers[i];
            }

            for (int i = 1; i < numbers.length; i += 2) {
                temp[counter++] = numbers[i];
            }
            lake.add(temp);
        }

        int count = 0;
        for (Integer num : lake) {
            if (count == lake.size() - 1) {
                System.out.print(num);
            } else {
                System.out.print(num + ", ");
                count++;
            }
        }
    }
}
