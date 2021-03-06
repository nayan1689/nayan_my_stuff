package nestedClass.staticInner;

import java.util.ArrayList;

// To access static member outside class: Outer.Inner.staticMember
// To access non static member outside class: new Outer.Inner().nonStaticMember
	
public class Outer {

	// To access static member: Inner.staticMember
	// To access non static member: new Inner().nonStaticMember
	
	private static String text = "test";
	
	private static class Inner {
		
		private String text = "test2";

		//Can access static member of outside class
		//can not access non static member of outside class
		private void accessMembers () {
			System.out.println(new Inner().printText());
			System.out.println(Outer.Inner.delimeter());
		}
		
		private String printText () {
			return Outer.text+delimeter()+text;
		}
		
		private static String delimeter() {
			return " ";
		}
	}
	
	private String getInnerText() {
		return new Inner().printText() + Inner.delimeter();
	}
	
	public static void main (String a[]) {
		
		ArrayList list = new ArrayList();
		
		Outer.Inner inner = new Outer.Inner();
		System.out.println(inner.printText());
		System.out.println(Outer.Inner.delimeter());
		
	}
}
