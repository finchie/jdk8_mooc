package training.jdk8mooc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util
{
    public static List<Student> getStudents(int amount)
    {
        List<Student> students = new ArrayList<Student>();
        
        Random random = new Random();
        
        for (int index = 0; index < amount; index++)
        {
            Student s = new Student();
            s.setGradYear(random.nextInt(3) + 2010);
            s.setScore(random.nextDouble() * 100);
            
            students.add(s);
        }
        
        return students;
    }
}
