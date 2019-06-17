package LinkedListTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        List<Integer> list = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");

            switch (input[0]) {
                case "Add":

                    break;
                case "Remove":
                    break;
            }
        }
    }
}
