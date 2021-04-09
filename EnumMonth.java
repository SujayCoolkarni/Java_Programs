package packageP1;

/*
 *  1. This is enum which implements EnumInterface method. 
 *  2. It shows that we can pass object,primitive another enum constant in Constant. 
 *  3. We can implement abstract methods in each constant.
 */
class EnumNumbers{
	
}
enum EnumAlphabet{
	A, B,C,D;
}
public enum EnumMonth implements EnumInterface{
	JAN("sujay"), FEB(2), MAR(EnumAlphabet.A), APR(new EnumNumbers()),JUN{
		public void METHOD() {
			System.out.println("JUN METHOD!");
		}
	},
	JUL{
		void METHOD1() {
			System.out.println("JUL METHOD!");
		}
	};

	private int val;
	private String str;
	EnumMonth(int value) { 
		this.val= value; 
	}
	EnumMonth(String str) { 
		this.str= str; 
	}
	EnumMonth(){
		System.out.println("Default constructor!");
	}
	
	EnumMonth(EnumAlphabet a) {  //Enum EnumAlphabet constructor
		// TODO Auto-generated constructor stub
	}
	
	EnumMonth(EnumNumbers enumNumbers) { //class EnumNumbers constructors
		// TODO Auto-generated constructor stub
	}
	void method() {
		System.out.println("Enum Method!");
	}
	 int getValue() {
		 return this.val;
	 }
	 
	 String getValueStr() {
		 return this.str;
	 }
	
	@Override
	public void interfaceMethod() {
		// TODO Auto-generated method stub
		System.out.println("Overrride Enum Interface Method!");
	}
}
