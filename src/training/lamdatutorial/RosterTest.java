package training.lamdatutorial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RosterTest
{

    public static void main(String[] args)
    {
        List<Person> roster = getRoster(50);

        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        
        System.out.println("--------------------");
        
        printPersonsWithPredicate(
                roster,
                (Person p) -> p.getGender() == Person.Sex.FEMALE
                            && p.getAge() >= 21
                            && p.getAge() <= 35
            );
        
        System.out.println("--------------------");
        
        processPersons(roster, (Person p) -> p.getGender() == Person.Sex.FEMALE
                            && p.getAge() >= 44
                            && p.getAge() <= 46, p -> p.printPerson());
        
        System.out.println("--------------------");
        
//        processElements(
//                roster,
//                p -> p.getGender() == Person.Sex.MALE
//                    && p.getAge() >= 18
//                    && p.getAge() <= 25,
//                p -> p.getEmailAddress(),
//                email -> System.out.println(email)
//            );
        
        roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
            .map(p -> p.getEmailAddress())
            .forEach(email -> System.out.println(email));
    }

    public static List<Person> getRoster(int amount)
    {
        List<Person> people = new ArrayList<Person>();

        Random random = new Random();

        for (int index = 1; index <= amount; index++)
        {
            Person p = new Person("Person" + String.format("%02d", index), LocalDate.of(2015 - random.nextInt(70), random.nextInt(12) + 1, random.nextInt(28) + 1), random.nextBoolean() ? Person.Sex.MALE : Person.Sex.FEMALE);
            
            p.setEmailAddress(p.getName() + "@roster.com");

            people.add(p);
        }

        return people;
    }

    public static void printPersonsOlderThan(List<Person> roster, int age)
    {
        for (Person p : roster)
        {
            if (p.getAge() >= age)
            {
                p.printPerson();
            }
        }
    }
    
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high)
    {
        for (Person p : roster)
        {
            if (low <= p.getAge() && p.getAge() < high)
            {
                p.printPerson();
            }
        }
    }
    
    public static void printPersons(List<Person> roster, CheckPerson tester)
    {
        for (Person p : roster)
        {
            if (tester.test(p))
            {
                p.printPerson();
            }
        }
    }
    
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester)
    {
        for (Person p : roster)
        {
            if (tester.test(p))
            {
                p.printPerson();
            }
        }
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block)
    {
        for (Person p : roster)
        {
            if (tester.test(p))
            {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block)
    {
        for (Person p : roster)
        {
            if (tester.test(p))
            {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block)
    {
        for (X p : source)
        {
            if (tester.test(p))
            {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}
