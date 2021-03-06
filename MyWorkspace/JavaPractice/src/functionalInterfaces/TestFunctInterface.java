package functionalInterfaces;

public class TestFunctInterface {

	public static void main (String a[]) {
		new TestFunctInterface().doConvertion();
	}
	public void doConvertion () {
		
		//Convertor<Integer,String> convertor = i -> Integer.valueOf(i);
		Convertor<Integer,String> convertor = Integer::valueOf;
		Integer convert = convertor.convert("3");
		System.out.println(convert);
	}
		
	
}

@FunctionalInterface
interface Convertor<R,I> {
	R convert (I i);
}