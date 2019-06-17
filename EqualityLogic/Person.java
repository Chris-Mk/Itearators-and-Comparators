package EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Person p = (Person) obj;
            return this.getName().equals(p.getName()) && this.getAge() == p.getAge();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
    }

    @Override
    public int compareTo(Person person) {
        if (this.getName().compareTo(person.getName()) == 0) {
            return Integer.compare(this.getAge(), person.getAge());
        } else {
            return this.getName().compareTo(person.getName());
        }
    }
}
