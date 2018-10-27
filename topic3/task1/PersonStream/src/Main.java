import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        /*
        #2 Create a collection of Persons
        */
        List<Person> persons = Arrays.asList(new Person("Gena", 20),
                                             new Person("Vasia", 25),
                                             new Person("Olia", 33),
                                             new Person("Sasha", 40),
                                             new Person("Igor", 18));

        /*
        #3 Create two instances of Comparator&lt;Person&gt; interface using lambda expressions: first one for
        comparing by name, second one – by age
        */
        Comparator<Person> nameComparator = (person1, person2) -> person1.getName().compareTo(person2.getName());
        Comparator<Person> ageComparator = (person1, person2) -> person1.getAge() - person2.getAge();

        /*sort them using these comparators.*/
        persons.sort(ageComparator);
        /*Use forEach method for printing information about all the persons.*/
        persons.forEach((person) -> System.out.println(person.toString()));
        System.out.println("\n\n");
        persons.sort(nameComparator);
        persons.forEach((person) -> System.out.println(person.toString()));
    }
}
