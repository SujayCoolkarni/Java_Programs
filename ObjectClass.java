package packageP1;
/*
 * Object class examples:
 * 1.Class Object is the root of the class hierarchy. Every class has Object as a superclass. 
 *   All objects, including arrays, implement the methods of this class.
 * 2.If two objects are equal ,their hash code values should be the same.
 */

public class ObjectClass {

	public static void main(String[] args) {

		ObjectClass obj= new ObjectClass();
		System.out.println(obj.getClass());//getClass method returns the class to which object belongs.
		System.out.println(obj.hashCode());//hashCode method represents unique id of the object.
		System.out.println(obj.toString());//toString method Gives string representation of object.
		System.out.println(obj.equals(obj));//equals method compares two objects for equality.


	}

}
