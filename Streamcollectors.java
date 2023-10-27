
package javatutorial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streamcollectors {

    public static void main(String[] args) {

        List<PersonD> people = new ArrayList<>();
        people.add(new PersonD("Ganesh", "Sharma", 25));
        people.add(new PersonD("Ram", "Bhandari", 35));
        people.add(new PersonD("Runa", "Sahi", 45));
        people. add (new PersonD("Umesh", "Pandey", 20));
        people.add(new PersonD("Ganesh", "Sharma", 25));

        // Filtering: Get people older than 25
        List<PersonD> above25 = people.stream()
                .filter(x -> x.getAge() > 25)
                .collect(Collectors.toList());
        above25.forEach(x -> System.out.println(x.displayName()));

        // Program 2
        // Filtering based on name; Ganesh
        List<PersonD> filterOnName = people.stream()
                .filter(x -> x.displayName().contains("Ganesh"))
                .collect(Collectors.toList());
        filterOnName.forEach(x -> System.out.println(x.displayName()));

        // Program 3
        // Collecting only the names in one list
        List<String> names = people.stream().map(x -> x.firstName).collect(Collectors.toList());
        names.forEach(x -> System.out.println(x));

        // Program 4
        double averageAge = people.stream()
                .mapToInt(PersonD::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average Age: " + averageAge);

        // Program 5
        // Sorting people in ascending order by age
        List<PersonD> sortedPeople = people.stream()
                .sorted(Comparator.comparing(PersonD::getAge))
                .collect(Collectors.toList());

        System.out.println("Sorted People by Age:");
        sortedPeople.forEach(person -> System.out.println(person.displayName() + " (" + person.getAge() + " years old)"));

        
        // Program 5
        
        // Count the number of people with the same age
        Map<Integer, Long> ageCounts = people.stream()
                .collect(Collectors.groupingBy(PersonD::getAge, Collectors.counting()));

        System.out.println("\nCount of People with the Same Age:");
        ageCounts.forEach((age, count) -> System.out.println(age + " years old: " + count + " person(s)"));

        // Program 6
        // Names of the first 3 people where age > 30
        List<String> firstThreeNamesAbove30 = people.stream()
                .filter(person -> person.getAge() > 30)
                .limit(3)
                .map(PersonD::displayName)
                .collect(Collectors.toList());

        System.out.println("\nNames of First 3 People with Age > 30:");
        firstThreeNamesAbove30.forEach(System.out::println);

        
        //Program 7
        // Distinct name list
        List<String> distinctNames = people.stream()
                .map(PersonD::displayName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nDistinct Names:");
        distinctNames.forEach(System.out::println);
    }
}

class PersonD {
    String firstName;
    String lastName;
    int age;

    public PersonD(String fn, String ln, int ag) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = ag;
    }

    public String displayName() {
        return (this.firstName + " " + this.lastName);
    }

    public int getAge() {
        return this.age;
    }}
	
