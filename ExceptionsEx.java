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
		//multiple object creation in try.
		try(Scanner sc= new Scanner(System.in); Scanner sc1=new Scanner(System.in)) {
			
			System.out.println("Enter your integer :");
			int i=sc.nextInt();
			
			switch(i) {
			case 1://only try  block
				/*try {
					System.out.println("try block");
				}*/ // you can't define only try block
				break;
				
			case 2:// try catch block
				try {
					System.out.println("Try block with catch: "+(1/0));
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 3:// try with 2 catch block
				try {
					System.out.println("Try block with 2 catch block! ");
				}catch(ArithmeticException e) {
					e.printStackTrace();
				}catch (Exception e) { 
				//Can't define exception first and then ArithmeticException,because ArithmeticException is 
				//subclass of Exception and code will never reach ArithmeticException.
					e.getStackTrace();
				}
				break;
				
			case 4:// try  with multiple exception in catch block
				try {
					System.out.println("Multiple exceptions defined in catch block!");
					obj.test(i);
				}catch (BadException |NullPointerException e) { // We can call multiple exception at a time.
					e.printStackTrace();
				}
				break;
				
			case 5: // try block without catch statement
				try {
					System.out.println("Try without catch!");
				}finally {
					System.out.println("finally block without catch!");
				}//finally {} can't define multiple finally block at same level
				break;
				
			case 6:// Nested try catch
				try {
					System.out.println("Nested try-catch!");
				}catch (NullPointerException e){
					try {
						
					}finally {
						try {
							
						}catch(Exception e1) {
							
						}finally { //Nested finally can be declared
							
						}
					}
				}break;
				
			default:
				System.out.println("Default switch case!");
				break;
				
		  } 
			
		}
	}

}
