package cloning;

public class TestShallowCloning {

	public static void main (String a[]) {
		Person person = new Person("Nayan", 27, new Address("Bhiwandi", "Aunjurphata"), new Education("National", "B.N.N"));
		Person clonedCopy = person.clone();
		clonedCopy.address.city = "Mumbai";
		clonedCopy.education.college = "N.E.S";
		System.out.println(person);
		System.out.println(clonedCopy);
	}
	
	
}

class Person  implements Cloneable{
	String name;
	int age;
	Address address;
	Education education;
	
	Person (String name, int age, Address address, Education education) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.education = education;
	}
	
	public Person clone () {
		try {
			Person person = (Person)super.clone();
			person.education = person.education.clone();
			return person;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String toString () {
		return " " + this.name + this.age + this.address.toString() + this.education.toString();
	}
	
}

class Address {
	String city;
	String street;
	
	Address (String city, String street) {
		this.city = city;
		this.street =  street;
	}
	
	public String toString () {
		return " \n staus in " + this.city + " , " + this.street;
	}
}

class Education implements Cloneable{
	String school;
	String college;
	
	Education (String school, String college) {
		this.school = school;
		this.college = college;
	}
	
	public Education clone () {
		try {
			return (Education)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String toString () {
		return "\n Studied in: " + this.school + " and " + this.college;
	}
}
