package PetClinics;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int initialIndex;
    private String name;
    private int rooms;
    private List<Pet> pets;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
        this.initialIndex = (int) Math.ceil(this.rooms / 2);
        List<Pet> temp = new ArrayList<>();
        for (int i = 0; i < this.getRooms(); i++) {
            temp.add(null);
        }
        this.pets = new ArrayList<>(temp);
    }

    public String getName() {
        return this.name;
    }

    public int getRooms() {
        return this.rooms;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public boolean addPet(Pet pet) {
        boolean added = false;
        if (this.pets.get(initialIndex) == null) {
            this.pets.add(this.initialIndex, pet);
            added = true;
        } else {
            List<Pet> leftPets = this.pets.subList(0, initialIndex);
            List<Pet> rightPets = this.pets.subList(initialIndex + 1, this.pets.size());
            if (this.pets.size() == 1 && leftPets.size() - 1 >= 0) {
                leftPets.add(leftPets.size() - 1, pet);
                added = true;
            } else {
                if (leftPets.size() > rightPets.size()) {
                    rightPets.add(pet);
                    added = true;
                } else if (leftPets.size() == rightPets.size()) {
                    for (int i = leftPets.size() - 1; i >= 0; i--) {
                        if (leftPets.get(i) == null) {
                            leftPets.add(i, pet);
                            added = true;
                        }
                    }
                }
            }
            leftPets.addAll(rightPets);
            this.pets = leftPets;
        }
        return added;
    }

    public boolean release() {
        boolean released = false;

        for (int i = this.initialIndex; i < this.pets.size(); i++) {
            if (this.pets.get(i) != null) {
                this.pets.remove(i);
                released = true;
                break;
            }
        }

        if (!released) {
            for (int j = 0; j < this.initialIndex; j++) {
                if (this.pets.get(j) != null) {
                    this.pets.remove(j);
                    released = true;
                    break;
                }
            }
        }
        return released;
    }

    public boolean hasEmptyRooms() {
        return this.pets.contains(null) || this.pets.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.pets.forEach(pet -> builder.append(pets.toString()).append(System.lineSeparator()));
        return builder.toString();
    }
}
