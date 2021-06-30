package packageP1;
/*
 * 1. A lambda expression is, essentially, an anonymous (that is, unnamed) method. However, this method is not executed on its own. 
 * 	Instead, it is used to implement a method defined by a functional interface. Thus, a lambda expression 
 *  results in a form of anonymous class. Lambda expressions are also commonly referred to as closures.
 * 2. A functional interface is an interface that contains one and only one abstract method. This abstract method specifies the intended purpose of the interface. 
 *    Thus, a functional interface typically represents a single action. For example, Runnable is a functional interface because it defines only one method: run( ).
 * 3. Functional interface sometimes referred as SAM. i.e, Single Abstract Method.
 * 4. Lambda operator or arrow operator (->) which is verbalize as "becomes" or "goes to".
 * 5. The type and number of the lambda expression’s parameters must be compatible with the method’s parameters; the return types must be compatible; 
 *    and any exceptions thrown by the lambda expression must be acceptable to the method.
 * 6. If you need to explicitly declare the type of a parameter, then all of the parameters must have declared types.
 *    ex. (int n,d) is illegal. (int n,int d) is legal.
 * 7. Lambda expression can't be generic but the functional interface associated with a lambda expression can be generic.
 * 8. To pass a lambda expression as an argument, the type of the parameter receiving the lambda expression
 *    argument must be of a functional interface type compatible with the lambda.
 * 9. We can add default and static method in functional interface but it can contain only single abstract method.
 * 10. Extending different functional interfaces with the same default method can be problematic.
 * 11. A lambda expression can throw an exception. However, it if throws a checked exception, then that exception must be compatible
 * 	   with the exception(s) listed in the throws clause of the abstract method in the functional interface.
 * 
 * 
 */

import java.io.IOException;
import java.io.PrintWriter;

interface Lambda{
	double getValue();

}

interface myInterface{
	boolean evenorodd(int n);
}

interface myInterface1{
	int evenorodd(int n);
}


//Extending functional interface 
interface Extension extends Lambda{
	boolean evenorodd(int n);
}

interface Division{
	boolean divisible(int n,int d);
}

//Functional interface can contain implementations in default methods, or in static methods. 
//Generic functional interface with lambda expression.
@FunctionalInterface
interface GenericInterface<T>{
	T GeneFunc(T t);

	//default method 
	public default void printing(String text) {
		System.out.println(text.charAt(0));
	}

	//static method
	public static void print(String text, PrintWriter writer) throws IOException {
		writer.write(text);
	}

}

//Extending multiple functional interface
interface Extended<T> extends GenericInterface<T>,myInterface1{
	int test(int num);
}

//Exception interface
interface ExceptionEx{
	double function(double[] n)throws NullArrayException;
}

class NullArrayException extends Exception{
	NullArrayException(){
		super("Array is empty!!");
	}
}

public class LambdaEx {

	//pass functional interface as a first parameter
	static String LambdaArg(GenericInterface<String> gt,String s) {
		return gt.GeneFunc(s);
	}

	static {

		System.out.println("This is static block inside class!");
	}

	public static void main(String[] args) throws NullArrayException {
		// interface reference
		Lambda ref;

		ref=()-> 123.45;//assign double value to reference
		System.out.println("Value is : "+ref.getValue());

		ref=()->Math.random()*100;
		System.out.println("Value is : "+ref.getValue());

		//ref=()->"Sk"; Error while assigning string.

		//Single Parameterized lambda function
		myInterface mi=(n)->(n%2)==0;
		int val=10;
		if(mi.evenorodd(val)) {
			System.out.printf("%d is even!",val);
			System.out.println();
		}else {
			System.out.printf("%d is odd!",val);
			System.out.println();
		}

		myInterface my=(int n)->n>=0; //we can explicitly mention parameter type as well (int n).

		if(my.evenorodd(val)) {
			System.out.printf("%d is positive!",val);
			System.out.println();
		}else {
			System.out.printf("%d is negative!",val);
			System.out.println();
		}

		int val1=2;
		//double Parameterized lambda function
		Division dv=(n,d)->(n%d)==0;

		if(dv.divisible(val, val1)) {
			System.out.printf("%d is divisible by %d!",val ,val1);
			System.out.println();
		}else {
			System.out.printf("%d is not divisible by %d!",val ,val1);
			System.out.println();
		}


		//block lambdas
		myInterface1 mFact =(n)->{
			int result=1;
			for(int i=2;i<=val;i++)
				result=result*i;
			return result;

		};

		System.out.println("Factorial is :"+mFact.evenorodd(val));

		//Generic Lambda 
		GenericInterface<Integer> gi=(n)->{
			int result=1;
			for(int i=2;i<=val;i++)
				result=result*i;
			return result;

		};

		System.out.println("Factorial using Generic is :"+gi.GeneFunc(val));

		String str="Value";
		GenericInterface<String> gstr=(n)->{
			String str1="";

			for (int i=n.length()-1;i>=0;i--) {
				str1=str1+n.charAt(i);

			}

			return str1;
		};
		System.out.println("Reversed string is: "+gstr.GeneFunc(str));


		//passing Lambda expression as an argument
		String outStr=LambdaArg((stri)->stri.toUpperCase(),str);
		System.out.println("Upper case value : "+outStr);

		//passing Lambda expression as an block argument
		String revStr=LambdaArg((DoesntMatter)->{
			String str1="";

			for (int i=str.length()-1;i>=0;i--) {
				str1=str1+str.charAt(i);

			}
			return str1;}
		,str);

		System.out.println("Lambda expression argument reverse string : "+revStr.toUpperCase());

		//Default method in functional interface using lambda
		GenericInterface<String> gt=(st)->st.toLowerCase();
		System.out.print("first character using default method in functional interface is :");
		gt.printing(str);
		System.out.println();


		/* Below code will give error as interface must be functional.
		 * So you can extend interface but it should contain only one abstract method
		 * and Extending different functional interfaces with the same default method can be problematic.
		 */

		/*Extension evod=(n)->(n%2)==0;
		int num=10;
		if(mi.evenorodd(val)) {
			System.out.printf("%d is even!",val);
			System.out.println();
		}else {
			System.out.printf("%d is odd!",val);
			System.out.println();
		}*/


		double[] num= {1.123,1.456,6.43,7.98};
		//Exception for lambda expressions.You can declare n or double[] n after lambda operator.
		ExceptionEx ex=(n)->{

			//we can define instance block inside lambda block expression
			{
				System.out.println("This is intance block in lambda expression");
			}

			//we can call static method from lambda block
			method();

			double avg=0,sum=0;
			if(n.length==0) //if array is empty it will throw an exception
				throw new NullArrayException();
			else {
				for (int i=0;i<num.length;i++) {
					sum=sum+num[i];
				}
				avg=(sum/num.length);

				//following statement is illegal because we are trying to modify str which is declared 
				//outside of lambda expression. Outside local variables are considered as final.
				//str="value1";


				return avg;
			}

		};

		System.out.println("Avg of double array is: "+ex.function(num));

		//Following line will throw exception
		System.out.println("Avg of double array is: "+ex.function(new double[0]));


	}

	//method for lambda expression.
	static void method() {
		System.out.println("Calling method from lambda expression");

	}
}