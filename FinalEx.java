package packageP1;
/*
 *  Following program illustrates Final keyword examples.
 *  1. You can't override final class .Ex: Can't extends Final class 
 *  2. Can't override final method.
 *  3. Can't override final variable.
 *  4. You can override final class variables which are non-final.
 *  5. You can create objects for final class. 
 *  6. Final with class just limits the inheritance.
 */

final class Final_Test{
	int i =10;
}

class Final_Test1{
	final int k=10;
	final void calc() {
		System.out.println("Final method");
	}
	
}

public class FinalEx extends Final_Test1{
	
	FinalEx(){
		//super.k=33; // final variable can't override
	}
	//void calc() {} //Can't override final method
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Final_Test ob= new Final_Test();
		ob.i=50;
		System.out.println("final class variable :"+ob.i);
		
		Final_Test1 ob1=new Final_Test1();
		System.out.println(" Final method call");
		//ob1.k=55; Can't override final method
		
	}

}
