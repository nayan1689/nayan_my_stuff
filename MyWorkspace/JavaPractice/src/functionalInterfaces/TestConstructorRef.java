package functionalInterfaces;

public class TestConstructorRef {

	public static void main (String a[]) {
		
		//PersonFactory pf = (String fname, String sname) -> {Person p = new Person(fname, sname);
		//													return p;};
		
		//PersonFactory pf = (String fname, String sname) -> new Person(fname, sname);
		
		PersonFactory pf = Person::new;
		
		Person createPerson = pf.createPerson("Shanyu", "Bitla");
		
	}
}

class Person {
	String firstName;
	String secondName;
	Person (String fName, String sName) {
		this.firstName = fName;
		this.secondName = sName;
	}
} 

@FunctionalInterface
interface PersonFactory<P extends Person> {
	P createPerson (String fName, String sName);
}	
