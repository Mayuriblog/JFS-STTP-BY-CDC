import java.io.*;
class FISFOS{

public static void main(String args[])throws Exception
{
FileInputStream fis=new FileInputStream("StudentDetails.txt");
FileOutputStream fos=new FileOutputStream("StudentDetails_out.txt");
int i=fis.read();
while(i!=-1)
{
fos.write(i);
System.out.println((char)i);
i=fis.read();
}
fos.close();
fis.close();
}
}