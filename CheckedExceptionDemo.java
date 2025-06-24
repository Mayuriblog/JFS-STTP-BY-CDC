//CheckedExceptionDemo.java
import java.io.*;
class CheckedExceptionDemo{
	public static void main(String args[])
	{
		try
		{
			FileInputStream fis=new FileInputStream("StudentDetails.txt");
			int i=fis.read(); // reads each character from file and returns its ASCII value
			while(i!=-1)
			{
				System.out.print((char)i);
				Thread.sleep(1000);
				i=fis.read(); //it will return -1 if no character found means ends of the file
			}
		}
		catch(FileNotFoundException ex1)
		{
			ex1.printStackTrace();
		}
		catch(IOException ex1)
		{
			ex1.printStackTrace();
		}
		catch(InterruptedException ex1)
		{
			ex1.printStackTrace();
		}
		System.out.println("End of main method");
	}
}