package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input;

        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);
            people.add(person);
        }

        int nthPerson = Integer.parseInt(scan.nextLine());
        Person p = people.get(nthPerson - 1);
        int equal = 0, diff = 0;

        for (Person person : people) {
            if (p.compareTo(person) != 0) {
                diff++;
            } else {
                equal++;
            }
        }

        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(equal + " " + diff + " " + people.size());
        }
    }
}
