package DAY1_SESSION;
class Jfs{
    int a;
    float x;
    public Jfs(int a,float x)
    {
        this.a = a;
        this.x = x;
    }
    public void display()
    {
        System.out.println("integer value: "+a);
        System.out.println("float value: "+x);
    }
}
public class Sample {
    public static void main(String args[])
    {
        System.out.println("welcome to jfs");
        Jfs j = new Jfs(8,8.5f);
        j.display();
    }
}
