package packageP1;
import java.lang.Integer;
import java.sql.Time;

/*
 * 1. The primitive types are not part of the object hierarchy, and they do not inherit Object.
 * 2. Wrapper class are present inside java.lang package and used to represent primitive data type as Object.
 * 3. Wrappers are Double, Float, Long, Integer, Short, Byte, Character, and Boolean.
 * 4. Wrapper classes offer a wide array of methods that allow you to fully integrate the primitive types into Java’s object hierarchy.
 * 5. Beginning JDK 9, Double, Float, Long, Integer(int num),Integer(String str), Short, Byte, 
 *    Character(char ch), and Boolean(boolean boolValue),Boolean(String boolString) constructors has been deprecated. 
 * 6. Java collections can't store primitives, they can use only objects. So Wrappers are used.   
 * 7. Compiler uses valueOf() method to convert primitive to Object and uses intValue(), doubleValue() 
 *    etc to get primitive value from Object.  
 * 8. valueOf() method is used to convert primitive type to object.
 * 9. Conversion from wrapper object to string can be done using toString() method.
 * 10. When we print reference variable toString method automatically get called. 
 * 11. == compares two string address while as .equals compares the content of two string.
 */

public class WrapperClass {

	public static void main(String[] args) {

		Integer i=33;//autobox an int 
		int j=i;     //auto-unbox
		Integer k=j;
		String s="Hello";
		int a=10,b=20;

		System.out.println(i+" "+j+" "+k+" "+i.byteValue()+" "+	Integer.valueOf(i));
		System.out.println(Integer.parseInt("111")+ " "+Integer.MAX_VALUE+" "+Integer.max(12, 99)+" "+Integer.numberOfLeadingZeros(j));
		System.out.println(Long.highestOneBit(j)+" "+Long.toHexString(j));
		System.out.println(Character.isDigit('S'));

		//toString method belongs to object class and returns string representation of Object.
		System.out.println("String object Concat "+i.toString()+" "+s);

		//primitive to String ---- valueOf() method
		String s1= String.valueOf(a);
		String s2= String.valueOf(b);
		System.out.println("Concat of "+s1+" "+s2+" is "+s1+s2);

		//String to primitive conversion  ---- parseXXX() method
		String p="101";
		String r="201";
		int q=Integer.parseInt(p);
		float t=Float.parseFloat(r);
		System.out.println(q+t);

		//toString method example
		Time t1 = new Time(75);
		System.out.println(t1);
		System.out.println(t1.toString());

		String name="Kulkarni";
		char arr[]=name.toCharArray();
		for (char char1: arr) {
			if (Character.isLetter(char1)) //checks if character is letter or not 
				System.out.print(char1);
		}


	}

}
