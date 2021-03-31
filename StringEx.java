package packageP1;

/* This Program illustrates String class and its method. 
 * 1. String class overrides equals() and hashcode() method . Strings are considered to be equal if 
 *    they contain exactly same character in same order and in same case.
 * 2. toString() method provides String representation of any object and it's declared in Object class
 *    and it's recommended for other class to implement this and provide String representation.
 * 3. The string is represented using the UTF-16 format in Java.
 * 4. Even though all StringBuffer, StringBuilder, and String are from same type hierarchy i.e. they extend from CharSequence interface, 
 *    you cannot cast StringBuilder to StirngBuffer or StringBuilder to String in Java. 
 *    It will throw java.lang.ClasscastException, if you tried to cast even StringBuffer to String in Java.
 * 5. StringBuffer is very good with mutable String but it has one disadvantage all its public methods 
 *    are synchronized which makes it thread-safe but same time slow.
 * 6. StringBuilder is copy of StringBuffer but without synchronization.
 * 7. Use String if you require immutability, use StringBuffer in java if you need mutable + thread-safety 
 *    and use StringBuilder in Java if you require mutable + without thread-safety.
 * 8. creating too many String literals can cause java.lang.OutOfMemory: permgen space.
 * 9. Java by default doesn't put all String objects into the String pool, instead, it gives you the flexibility to explicitly store any arbitrary object in the String pool. 
 *    You can put any object to the String pool by calling the intern() method of java.lang.String class. 
 * 
 */

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer("Hi");
		String str="val";
		String str1="val";
		
		System.out.println(s.toString()+" "+str.hashCode() +" "+str1.hashCode());
		//compareTo: it returns a positive integer if this String comes and a negative integer if this string comes before and zero if both strings is equal.
		System.out.println("Comparison : "+str.compareTo(str1));
		System.out.println(s.toString()+" "+str.hashCode() +" "+str1.hashCode());
		
		//charAt Example
		System.out.println("CharAt :"+str1.charAt(2)); 
		System.out.println("String literal comparison str==str1: "+str==str1);
		
		//Split example
		String colon= "Java:Oracle:C++:C";
		String[] split1=colon.split(":");
		System.out.print("Split : ");
		for (String st:split1) {
		System.out.print(st+" ");
		}
		System.out.println();
		
		//substring example: public String substring(int beginIndex, int endIndex)
		String subs=colon.substring(0,6);
		System.out.println("Substring: "+subs);
		
		//indexOf method
		System.out.println("Index of C: "+colon.indexOf("C++"));
		
		//contains method
		System.out.println("Contains of: "+colon.contains("AB"));
	
		
	}

}
