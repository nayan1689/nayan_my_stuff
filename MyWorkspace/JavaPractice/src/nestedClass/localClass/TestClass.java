package nestedClass.localClass;

public class TestClass {

	public void doSomething (String abc) {
		int test=1;
		class LocalClass{
			public void print(String xyz) {
				System.out.println(test+xyz+abc);
			}
		}
		LocalClass c = new LocalClass();
		c.print("test");
	}
	
	public static void main(String a[]) {
		TestClass t = new TestClass();	
		t.doSomething("Test");
	}
	
}
