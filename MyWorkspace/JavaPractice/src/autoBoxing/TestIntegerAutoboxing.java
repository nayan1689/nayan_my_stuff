package autoBoxing;

public class TestIntegerAutoboxing {

	public void test() {
		
		int i1 = 1;
		int i2 = 1;
		System.out.println(i1 == i2);
		
		Integer i3 = 1;// auto boxing 
		int i4 = 1;
		System.out.println(i3 == i4); // auto unboxing
		
		Integer i5 = 1;// auto boxing
		Integer i6 = 1;// auto boxing, here it will return cache object since value is between -128 to 127 
		System.out.println(i5 == i6);
		
		Integer j1 = new Integer(1);
		int j2 = 1;
		System.out.println(j1 == j2); //auto unboxing
		
		Integer j3 = new Integer(1);
		Integer j4 = 1; // auto boxing
		System.out.println(j3 == j4);// auto unboxing
		
		Integer j5 = new Integer(1);
		Integer j6 = new Integer(1);
		System.out.println(j5 == j6);
		
	}
	
	public static void main(String[] args) {
		new TestIntegerAutoboxing().test();
	}

}
