package training.jdk8mooc;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Comparator;

public class Lesson1_1
{

    public static void main(String[] args)
    {
        List<Student> students = Util.getStudents(100);
        
        OptionalDouble highestScore2011;// = 0.0;
        
        Predicate<Student> f = s -> s.getGradYear() == 2011;
        Function<Student, Double> m = s -> s.getScore();
        
        highestScore2011 = students
                            .stream()
                            .peek(System.out::println)
                            .filter(s -> s.getGradYear() == 2011)
//                            .peek(System.out::println)
                            .mapToDouble(s -> s.getScore())
//                            .peek(System.out::println)
                            .max();
        
        System.out.println("High score is " + highestScore2011.orElse(-1.0));

    }

}
