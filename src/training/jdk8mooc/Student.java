package training.jdk8mooc;

public class Student
{
    private int gradYear;
    private double score;
    
    public int getGradYear()
    {
        return gradYear;
    }
    public void setGradYear(int gradYear)
    {
        this.gradYear = gradYear;
    }
    public double getScore()
    {
        return score;
    }
    public void setScore(double score)
    {
        this.score = score;
    }
    @Override
    public String toString()
    {
        return "Student [gradYear=" + gradYear + ", score=" + score + "]";
    }
    
    
}
