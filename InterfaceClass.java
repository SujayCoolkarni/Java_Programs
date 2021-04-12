package packageP1;

public class InterfaceClass extends AB implements Interface {
	@Override
	public void methodex() {
		System.out.println("Overriding unimplmented method from interface in class!");
	}

	public static void main(String[] args) {
		//i=44; // Final variable from interface and can't be reassigned.
		InterfaceClass ob = new InterfaceClass();
		System.out.println("Interface variable :"+i);
		ob.method(); 	// calling default method in interface
		ob.methodex();	// calling overridden method 
		ob.methodex1(); // calling method from abstract class
		ob.Functions(); // calling functions from Inter1 interface
		Interface.interface_Method(); // calling interface static method using interface name

	}

}
