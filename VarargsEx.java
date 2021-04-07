package packageP1;

import java.util.Arrays;

/* Below class explains Varargs in java.
 * 1. Before varargs (jdk5) variable arguments used to handle in two ways. One using overloading, second
 *    using put the arguments in array and then pass the arguments.
 * 2. Vararg should be last one in parameter list if method contains more than one argument.
 * 3. Only one varargs is allowed in method.
 * 4. Vararg Methods can also be overloaded but overloading may lead to ambiguity.
 * 
 */

public class VarargsEx {
	// void method(int val1,int val2, int...var,float...var1) {} //invalid

	int val1,val2;
	String[] var;
	static void method(int val1,int val2, String...var) {
		System.out.println("==================");
		System.out.println("Int values : "+ val1 +" "+val2);
		System.out.println("String values: ");
		for (String s:var) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println("==================");
	}
	
	static String[] method2(String...str) {
		//String val[]=new String[str.length];
		//val=str;
		return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. way to pass varargs");
		method(1,2,new String[]{"hi","Hello"});
		
		System.out.println("2. way to pass varargs");
		method(1,2,"hi","Hello");
		
		String[] str1=method2("Hello","sujay");
		System.out.println(Arrays.toString(str1));
		
	}

}
