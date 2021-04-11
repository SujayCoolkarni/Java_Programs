package packageP1;
import java.util.Scanner;
/*
 * Below class is example of exception handling.
 * 1. In java, exception feature handling is implemented using throwable,Exception,RuntimeException.
 * 2. All exception are derived from throwable class.
 * 3. All the Exception which are direct sub Class of Exception but not inherit RuntimeException are Checked Exception.
 * 4. Checked Exception requires to be handled at compile time using try, catch and finally keywords 
 *    or else compiler will flag error. 
 * 5. All exceptions derived from java.lang.Exception classes are checked exception, exception those which extends RuntimeException, 
 *   these are known as unchecked exception in Java. 
 * 6. If you throw an exception in your code you must declare it using the throws keyword in your method declaration.
 * 
 */

public class ExceptionsEx {
	public void test(int var) throws BadException {
		if (var==1 || var==2)
			throw new BadException(var);
		else if (var==3 || var==4)
			throw new BadException();
		else 
			System.out.println("You are good buddy!");
	}
	public static void main(String[] args) {
		
		ExceptionsEx obj=new ExceptionsEx();
		
		try(Scanner sc= new Scanner(System.in);) {
			System.out.println("Enter your integer :");
			int i=sc.nextInt();
			obj.test(i);
			
		} catch (BadException |NullPointerException e) { // We can call multiple exception at a time.
			e.printStackTrace();
		}
	}

}
