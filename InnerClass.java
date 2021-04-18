package packageP1;
/*
 * Inner Classes
 * 1. In order to create instance of Inner class, an instance of outer class is required.
 * 2. Static can be declared inside static or top-level.
 * 3. Static nested class cannot access non-static (instance) data member or method and it can access 
 *    static data members of outer class including private.
 * 4. We can create object of private class.
 * 5.A class that have no name is known as anonymous inner class in java. 
 *   It should be used if you have to override method of class or interface.
 * 
 */

interface Anonymous{
	void anonymous();
}

class Inner{
	int default_var=10;
	private int private_var=20;
	public int public_var=30;
	protected int protected_var=40;
	static int stat_variable=91;

	private class Private_Inner{
		private int variable=99;
		int stat_var=66;
		class test{
			public void method() {
				Private_Inner obj= new Private_Inner(); //object of private class
				System.out.println("Private class variables :"+obj.stat_var+" "+variable);
				System.out.println("Private class public method");
			}
		}
	}
	static class InnerStatic{
		static int var=20;
		class InnerStaticInner{
			void stat_default() {
				System.out.println("static class static variable :" +stat_variable);
				System.out.println("Static class default method");
			}
		}
	}
	class InnerInner{
		class InnerInnerInner{
			class InnerInnerInnerInner{
				int num=private_var+protected_var;
				Private_Inner pi =new Private_Inner();
				Private_Inner.test ob= pi.new test();
				void InnerMethod() {
					System.out.println("Private class variable :"+pi.variable);
					ob.method();
				}
			}
		}
	}
}

public class InnerClass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inner in =new Inner();
		Inner.InnerInner in1=in.new InnerInner();
		Inner.InnerInner.InnerInnerInner in2=in1.new InnerInnerInner();
		Inner.InnerInner.InnerInnerInner.InnerInnerInnerInner ob = in2.new InnerInnerInnerInner();
		ob.InnerMethod();
		System.out.println("Addition is :"+ob.num);


		//Object creation of inner static class
		Inner.InnerStatic is1 = new Inner.InnerStatic();
		//Object creation of non inner static class
		Inner.InnerStatic.InnerStaticInner is2=is1.new InnerStaticInner(){//Anonymous class
			@Override
			void stat_default() {
				System.out.println("Inside anonymous class!");
			}
		};
		is2.stat_default();

		Anonymous an= new Anonymous() { //interface 
			@Override
			public void anonymous() {
				System.out.println("Anonymous class method implementation!");
			}
		};

		an.anonymous();
	}

}
