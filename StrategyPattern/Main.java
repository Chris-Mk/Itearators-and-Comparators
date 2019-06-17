package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Person> firstSet = new TreeSet<>(new NameComparator());
        TreeSet<Person> secondSet = new TreeSet<>(new AgeComparator());

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            firstSet.add(person);
            secondSet.add(person);
        }

        firstSet.forEach(person -> System.out.println(person.toString()));
        secondSet.forEach(person -> System.out.println(person.toString()));
    }
}
