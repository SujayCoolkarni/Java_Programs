package packageP1;
/*
 * This is custom Exception class
 */
public class BadException extends Exception {
	BadException(){
		System.out.println("Bad word Exception!");
	}
	BadException(int i){
		System.out.println("Bad word Exception for value= "+i);
	}
	
	void exceptionList() {
		int i;
		System.out.println("Defined exception!" +(i=1/0));
	}
}
