package EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            treeSet.add(person);
            hashSet.add(person);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
