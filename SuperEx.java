package packageP1;

/* 1. Super statement should be first in child class constructor!
 * 2. Super can be used to access parent variables from child class 
 *    when both class have same variable name.
 * 3. Super can be used to access parent class method having same name. 
 * 
 */
class SuperEx1{
	int variable=20;
	SuperEx1(){
		System.out.println("Normal constructor!");
	}
	
	SuperEx1(int value){
		int var3=value;
		System.out.println("Paremetrized constructor! value passed: "+var3);
	}
	
	void method() {
		System.out.println("Inside Method");
	}
}

public class SuperEx extends SuperEx1{
	int var=super.variable;
	SuperEx(){
		super();
		System.out.println("Child class Constructor!!");
	}
	SuperEx(int c){
		super(c);
		System.out.println("Child class paremetrized Constructor!!");
	}
	void method() {
		System.out.println("Child class method");
		super.method();
		System.out.println("Inside Method");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperEx1 ob =new SuperEx1();
		ob.method();
		System.out.println("===========");
		SuperEx ob1 =new SuperEx();
		ob1.method();
		System.out.println(ob1.var);
		System.out.println("------------");
		
		
	}

}

