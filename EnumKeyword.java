package packageP1;
/*
 * Below class illustrates example of Enum keyword
 * 1. Enumeration is introduced in JDK5 
 * 2. Enum constants are implicitly static,public,final, it means you can't change their value once created.
 * 3. Its better to specify them like Constants(All caps letter) in Java.
 * 4. Enum is a type like class and interface and can be used to define a set of Enum constants. 
 * 5. Every Enum in Java extends from java.lang.Enum implicitly and we can't extends Enum class.
 * 6. Enum can have private constructor not public constructor.
 * 7. Enum can implement interface and override ,overload methods.
 * 8. Constructor can't be called using new keyword. 
 */

public class EnumKeyword{

	void method() {
		System.out.println("Child method!");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumMonth mo=EnumMonth.JAN;
		//mo=12; 				//compilation error
		System.out.println();
		mo.method(); 			// calling method from enum using enum reference.
		
		for (EnumMonth mon:EnumMonth.values()) {
			
			switch(mon) {
			case JAN:
				System.out.println("SR.No :"+mon.ordinal()+", Month is: "+mon + " Value is: "+mon.getValueStr());
				break;
			case  FEB:
				System.out.println("SR.No :"+mon.ordinal()+", Month is: "+mon+" Value is: "+EnumMonth.FEB.getValue());
				break;
			case MAR:
				System.out.println("SR.No :"+mon.ordinal()+", Month is: "+mon+ " Value is: "+mon.getValue());
				break;
			case APR:
				System.out.println("SR.No :"+mon.ordinal()+", Month is: "+mon+ " Value is: "+mon.getValue());
				break;
			case JUN:
				System.out.println();
				break;
			default:
				System.out.println("Month not found!!");
				break;
			}
			
		}

		

	}

}
