package DAY1_Session;
import java.lang.*;
class Sample{
    public int a;
    public float x;
    public void Sample(int a,float x)
    {
        this.a=a;
        this.x=x;
    }
    public void display(){
        System.out.println("integer value: "+a);
        System.out.println("float value: "+x);
    }


}
public class SampleDemo {
    public static void main(String args[])
    {
        System.out.println("Welcome to JFS");
        Sample s=new Sample(2,2.5f);
        s.display();
    }
}
