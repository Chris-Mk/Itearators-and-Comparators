package PetClinics;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Clinic> clinics = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            switch (input[0]) {
                case "Create":
                    if ("Pet".equals(input[1])) {
                        Pet pet = new Pet(input[2], Integer.parseInt(input[3]), input[4]);
                        pets.add(pet);
                    } else {
                        int rooms = Integer.parseInt(input[3]);
                        if (rooms % 2 != 0) {
                            Clinic clinic = new Clinic(input[2], rooms);
                            clinics.add(clinic);
                        } else {
                            System.out.println("Invalid Operation!");
                        }
                    }
                    break;
                case "Add":
                    Clinic c = clinics.stream()
                            .filter(clinic -> clinic.getName().equals(input[2]))
                            .findFirst()
                            .get();
                    Pet p = pets.stream()
                            .filter(pet -> pet.getName().equals(input[1]))
                            .findFirst()
                            .get();
                    System.out.println(c.addPet(p));
                    break;
                case "Release":
                    Clinic cl = clinics.stream()
                            .filter(clinic -> clinic.getName().equals(input[1]))
                            .findFirst()
                            .get();
                    System.out.println(cl.release());
                    break;
                case "HasEmptyRooms":
                    Clinic cli = clinics.stream()
                            .filter(clinic -> clinic.getName().equals(input[1]))
                            .findFirst()
                            .get();
                    System.out.println(cli.hasEmptyRooms());
                    break;
                case "Print":
                    if (input.length == 2) {
                        clinics.stream()
                                .filter(clinic -> clinic.getName().equals(input[1]))
                                .forEach(clinic -> clinic.getPets()
                                        .forEach(pet -> System.out.println(pet.toString())));
                    } else {
                        clinics.stream()
                                .filter(clinic -> clinic.getName().equals(input[1]))
                                .forEach(clinic -> System.out.println(clinic.getPets()
                                        .get(Integer.parseInt(input[2]))
                                        .toString()));
                    }
                    break;
            }
        }
    }
}
