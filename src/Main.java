import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Maria", 32, "Brown"));
        persons.add(new Person("Andrei", 19, "Red"));
        persons.add(new Person("Ionel", 40, "Black"));
        persons.add(new Person("Ana", 35, "Blonde"));
        persons.add(new Person("Ionela", 31, "Brown"));

        //2.1
        List<String> personNames = PersonNames(persons);
        System.out.println("Person names: " + personNames);

        //2.2
        Map<String, Integer> nameToAgeMap = makeNameToAgeMap(persons);
        System.out.println("Name to age: " + nameToAgeMap);

        //2.3
        int givenAge = 20;
        List<String> olderPersons = personsOlderThan(persons, givenAge);
        System.out.println("People older than: " + givenAge + ": " + olderPersons);

        //2.4
        Map<String, List<String>> hairColorToNameMap = makeHairColorToNamesMap(persons);
        System.out.println("From hair color to name: " + hairColorToNameMap);

        //2.5
        Map<Integer, List<String>> ageToNamesMap = makeAgeToPersonMap(persons);
        System.out.println("Map from age to names: " + ageToNamesMap);
    }
    private static List<String> PersonNames(List<Person> persons){
        List<String> personNames = new ArrayList<>();
        for (Person person : persons){
            personNames.add(person.getName());
        }
        return personNames;
    }

    private static Map<String, Integer> makeNameToAgeMap(List<Person> persons){
        Map<String, Integer> nameToAgeMap = new HashMap<>();
        for(Person person : persons){
            nameToAgeMap.put(person.getName(), person.getAge());
        }
        return nameToAgeMap;
    }

    private static  List<String> personsOlderThan(List<Person> persons, int givenAge){
        List<String> olderPersons = new ArrayList<>();
        for(Person person : persons){
            if(person.getAge() > givenAge){
                olderPersons.add(person.getName());
            }
        }
        return olderPersons;
    }

    private static Map<String, List<String>> makeHairColorToNamesMap(List<Person> persons) {
        Map<String, List<String>> hairColorToNamesMap = new HashMap<>();
        for (Person person : persons) {
            String hairColor = person.getHairColor();
            hairColorToNamesMap.computeIfAbsent(hairColor, k -> new ArrayList<>()).add(person.getName());
        }
        return hairColorToNamesMap;
    }

    private static Map<Integer, List<String>> makeAgeToPersonMap(List<Person> persons) {
        Map<Integer, List<String>> ageToPersonMap = new HashMap<>();
        for (Person person : persons) {
            int age = person.getAge();
            if (!ageToPersonMap.containsKey(age)) {
                ageToPersonMap.put(age, new ArrayList<>());
            }
            ageToPersonMap.get(age).add(person.getName());
        }
        return ageToPersonMap;
    }

}
