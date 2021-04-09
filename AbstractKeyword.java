package packageP1;
/*
 * Following example illustrates example of Abstract keyword.
 * 1. We can't create instance of abstract class.
 * 2. A class is called concrete if it does not contain any abstract method and implements all 
 *    abstract method inherited from abstract class or interface it has implemented or extended.
 * 3. Abstract method doesn't have body, you will need to override method in subclass. 
 * 4. Class automatically becomes abstract if any of its method declared as abstract. 
 * 5. Variable can't be declare as abstract.
 * 6. If a class extends an abstract class or interface it has to provide implementation to all its
 *    abstract method to be a concrete class(i.e Methods with implementations) else it has to be
 *    declare as abstract class.
 * 7. We can create object reference for abstract class.
 * 8. Abstract methods can't be private.
 * 9. We can call abstract class constructor by using "super keyword" in subclass constructor.
 */

 abstract interface Hello {
	 default void method1() {
		System.out.println("Abstract interface static method!");
	}
	 int i=10;
}
abstract class AbstractExample {
	abstract void Display();
	static void Method() {
		System.out.println("Abstact class method with body!");
	}
	static { //static block
		System.out.println("This is static block inside abstract class!");
	}
	
	{	//normal block
		System.out.println("Block inside abstract class!");
	}
	void normalMethod() {
		System.out.println("Normal method in abstract class!");
	}
	AbstractExample(String s){
		System.out.println("Abstract class constructor!" +" :"+s);
	}
}
public class AbstractKeyword extends AbstractExample implements Hello{
	AbstractKeyword(String s) {
		super("Called abstractor class constructor");
		//System.out.println("");
		
	}

	// abstract int i; //variable can't be declare as abstract.
	
	@Override
	void Display() {
		// TODO Auto-generated method stub
		System.out.println("Subclass with overridden method!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractExample ob = new AbstractKeyword("Abstract class constructor called using super keyword!");
		Hello hl= new AbstractKeyword("Abstract interface Object reference");
		ob.Display(); 
		ob.normalMethod();
		AbstractExample.Method();
		hl.method1();
		System.out.println("abstract interface variable :"+Hello.i);
		
	}

	
}
