/* 5 clauses in Exceptions:
   -----------------------
throw - raises Exception
throws - reports exception
try - monitors exceptions
catch - handles exceptions
finally - last block of the method that executes in both normal and abnormal
termination of the method execution.
*/
import java.util.*;
class UncheckedExceptionDemo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		// Example of ArithmeticException and InputMismatchException
      /*  try
		{
			System.out.println("Enter first value ");
			int a=sc.nextInt();sc.nextLine();
			System.out.println("Enter second value ");
			int b=sc.nextInt();sc.nextLine();
			int result=a/b;
			System.out.println("result: "+result);
		}
		catch(ArithmeticException ex1)
		{
			ex1.printStackTrace();
		}
		catch(InputMismatchException ex2)
		{
			ex2.printStackTrace();
		}
			
		// Example on ArrayIndexOutOfBoundsException
		try{
				int a[]={1,2,3,4,5};
				for(int i=0;i<=a.length;i++)
				{
					System.out.println(a[i]+" ");
				}
				
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		} */
		try{
			System.out.println("Enter a value");
			String s1=sc.nextLine();
			int i=Integer.parseInt(s1);
			System.out.println(i);
		}
		catch(NumberFormatException ne)
		{
			ne.printStackTrace();
		}
		System.out.println("End of main method");
	}
}