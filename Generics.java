/* This class demonstrate usage of generics.
 * 1. Beginning with JDK 10, you cannot use var as the name of a type parameter.
 * 2. The process of removing generic type information while substituting is called erasure.
 * 3. Bound can include both a class type and one or more interfaces. In this case, the class type must be specified first.
 * 4. When specifying a bound that has a class and an interface, or multiple interfaces, 
 *    use the & operator to connect them. This creates an intersection type.  
 * 5. Lower bound wildcard : <? super subclass>
 * 6. Upper bound wildcard: <? extends superclass>
 * 7. Syntax of generic method: <type-param-list > ret-type meth-name (param-list){}
 * 8. It is possible for constructors to be generic, even if their class is not.
 * 9. String and Date both implement the Comparable interface.Comparable implementations provide a natural ordering 
 *    for a class, which allows objects of that class to be sorted automatically.
 * 10. Comparable interface implements compareTo and comparator interface implements compare method.
 * 11. In general, if a class implements a generic interface, then that class must also be generic, at least to the extent that 
 *     it takes a type parameter that is passed to the interface. i.e class MyClass<T extends Comparable<T>> implements MinMax<T> {
 * 12. In a generic hierarchy, any type arguments needed by a generic superclass must be passed up the hierarchy by all subclasses. 
 * 13. Generic Restrictions:
 *     -Type Parameters Can’t Be Instantiated ex. Ob= new T();
 *     -Restrictions on Static Members. No static member can use a type parameter declared by the enclosing class. 
 * 	   -Generic Array Restrictions. First, you cannot instantiate an array whose element type is a type parameter. Ex. ob=new T[10];
 *      Second, you cannot create an array of type-specific generic references. Ex. Gen<Integer> num[]=new Gen<Integer>[10];
 * 	   -Generic Exception Restriction. A generic class cannot extend Throwable. This means that you cannot create generic exception classes.
 * 13. You can cast one instance of a generic class into another only if the two are otherwise compatible 
 *      and their type arguments are the same. Ex. (Gen<Integer>) iOb2 
 * 
 */
package packageP1;

class Gen <T>{
	T ob;

	Gen<?> gens[] = new Gen<?>[10]; //is valid syntax.
	Gen(T obj){ //constructor 
		ob=obj;
	}

	T getOb() {
		return ob;
	}


	void showType() {
		System.out.println("Type of T is :"+ob.getClass().getName());
	}

}
class Gener<T extends Number>{
	T[] nums;
	Gener(T[] arr){ //constructor 
		nums=arr;
	}
	double avg() {
		double sum=0.0;
		for (int i =0;i<10;i++) {
			sum+=nums[i].doubleValue();

		}
		return sum/nums.length;
	}

}

class Gene <T,V>{
	T ob;
	V ob1;
	Gene(T obj,V obj1){ //constructor 
		ob=obj;
		ob1=obj1;
	}

	T getOb() {
		return ob;
	}
	V getOb2() {
		return ob1;
	}

	void showType() {
		System.out.println("Type of T is :"+ob.getClass().getName());
		System.out.println("Type of V is :"+ob1.getClass().getName());
	}

}


class Generi{
	private double val;

	<T extends Number>Generi(T obec){ //constructor with upper bound
		val=obec.doubleValue();
	}


	void showType() {
		System.out.println("Val is :"+val);
	}
}

//Generic interfaces 
interface MinMax<T extends Comparable<T>>{
	T min();
	T max();
}

//T is declared by Generics and then passed to MinMax. Because MinMax requires a type that implements
//Comparable, the implementing class (Generics in this case) must specify the same bound.

public class Generics<T extends Comparable<T>> implements MinMax<T>{

	T[] num;
	Generics(T[] o){
		num=o;
	}

	@Override
	public T min() {
		T v =num[0];
		for(int i=0;i<num.length;i++) {
			if(num[i].compareTo(v)<0)
				v=num[i];
		}
		return v;
	}


	@Override
	public T max() {
		T v =num[0];
		for(int i=0;i<num.length;i++) {
			if(num[i].compareTo(v)>0)
				v=num[i];
		}
		return v;
	}
	public static void main(String[] args) {
		//String
		Gen <String> s1=new Gen<>("Hello");
		s1.showType();
		System.out.println(s1.getOb());

		//Integer
		Gen <Integer> i1=new Gen<Integer>(Integer.valueOf(100));
		int val=i1.getOb();
		System.out.println("Integer value: "+val);
		i1.showType();

		//Can't cast Double to Integer viz.
		//Gen<Integer> d1=new Gen<Double>(200);
		Gen<Number> d1=new Gen<Number>(201111111011L);
		d1.showType();


		Gene<String, Integer> s2=new Gene<String,Integer>("Hello",88);
		s2.showType();
		System.out.println(s2.getOb());
		System.out.println(s2.getOb2());

		Integer nums[]= {1,2,3,4,5,6,7,8,9,10};
		Gener<Integer> object1= new Gener<>(nums);
		double value=object1.avg();
		System.out.println(value+" Value for bounded type");

		Generi gn= new Generi(100);
		Generi gn1= new Generi(100.341);
		gn.showType();
		gn1.showType();

		Integer[] inum= {1,2,4,3,9,6,7,8};
		Character[] ich= {'a','m','w','z'};
		Generics<Integer> iob=new Generics<Integer>(inum);
		Generics<Character> cob=new Generics<Character>(ich);

		System.out.println(iob.min()+" min and "+iob.max()+" max");
		System.out.println(cob.min()+" min and "+cob.max()+" max");
	}




}
