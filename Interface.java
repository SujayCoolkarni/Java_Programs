package packageP1;
/*
 *  1. We can't define object of interface and interface doesn't contain private or protected methods.
 *  2. All variables declared inside interface is implicitly public final variable or constants.
 *  3. All methods declared inside Java Interfaces are implicitly public and abstract, even if you don't use public or abstract keyword.
 *  4. One of the major reason for introducing default methods in interfaces is to enhance the Collections API in Java 8 to support lambda expressions.
 *  5. We can't use implements keyword for another interface, we need to use extends keyword.
 *  6. One interface can inherit another by use of the keyword extends, by this way we can achieve multiple inheritance.
 *  7. from Java 8 onwards we can define default,static methods in interfaces.
 *  8. A class can implement more than one interface.
 *  9. An interface can be declared a member of a class or another interface. Such an interface is called a member interface or a nested interface. 
 *     A nested interface can be declared as public, private, or protected.
 *  10. Beginning with JDK 9, an interface can include a private method. A private interface method can be called only by
 *      a default method or another private method defined by the same interface.  
 *       
 *  @author: Sujay Kulkarni
 */

interface Inter1{
	private void test() {
		System.out.println("Private method in Interface Inter1");
	}
	abstract interface NestedAbIn{
		private void test1() {

		}
	}

	default void Functions() {
		System.out.println("Function method from Inter 1");
		try {
			test();  //we can call private method from default method from same interface
		}finally {
			System.out.println("finally block in interface Functions method!");
		}
	}

}

interface Inter2{
	default void Functions() {
		System.out.println("Function method from Inter 2");
	}
}
abstract interface InterfaceEx1 extends Inter1,Inter2 {
	default void method() {
		System.out.println("Default method in InterfaceEx1 ");

	}

	static void function() {
		System.out.println("Static method in InterfaceEx1");
	}

	abstract void methodex();
	abstract void methodex1();

	@Override
	default void Functions() {
		Inter1.super.Functions();
	}


	// if extended interface has same method name then we can define only either of the method.
	// i.e, Functions from Inter 1 or Functions from Inter 2

	//	@Override
	//	default void Functions() {
	//		Inter2.super.Functions();
	//	}

}

abstract class AB implements InterfaceEx1 {

	static class ABC{
	}

	//Nested interface inside class can be declared as private,public ,protected
	protected abstract interface NestedIn{
		abstract void nestedMethod() ;
	}

	@Override
	public void methodex1() {
		System.out.println("Abstract method implemenation of InterfaceEx1 interface");
	}
}
public interface Interface extends InterfaceEx1 ,AB.NestedIn{ // inheritance 
	int i=10;
	static void interface_Method() {
		System.out.println("Interface method!");
	}
	@Override
	public default void nestedMethod() {

	}
}
