package packageP1;
 
/*
 *  Below class is example of Static keyword
 *  1. We can use static keyword in-front of import statement ,methods, variables, block.
 *  2. Static variables are accessed using class and object name but preferred is by using class name.
 *  3. Static methods are accessed using class name.
 *  4. Static blocks executes only once when class is loaded and even so many instances created.
 *  5. Class can be abstract,final,public but not static.
 *  6. Can't use non-static variable inside static block/method.
 */

class StaticEx{
	static int val=10;
	String name="SK";
	
	static{
		System.out.println("First block to execute!");
		//System.out.println(name); can't use static variable inside block
	}
	
	static int  method() {
		System.out.println("Called Static method fromm StaticEx class!");
		//System.out.println(name); can't use non-static variable inside static method
		return val;
	}
	
	int return_method() {
		System.out.println(val); // static variable used inside non-static method
		return 0;
	}
	
	
}
public  class StaticKeyword {
	static void  method1() {
		System.out.println("Called Static method fromm StaticKeyword class!");
		//return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StaticEx obj= new StaticEx();
		//StaticKeyword obj1=new StaticKeyword();
		
		System.out.println("Object call for static variables :"+obj.val);
		System.out.println("Static call for static variables using class name:"+StaticEx.val);
		
		
		StaticEx.method(); // With invoking using class-name
		obj.method(); // with invoking using object  
		method1();    // as method is static in same class, no need to invoke using object,class
		
		
	}

}
