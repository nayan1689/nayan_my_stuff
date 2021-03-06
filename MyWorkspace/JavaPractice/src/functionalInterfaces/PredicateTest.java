package functionalInterfaces;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main (String a[]) {
		Predicate<String> predicate = s -> s.length() == 3;
		System.out.println(predicate.and(s -> s.startsWith("f")).test("foo"));
	}
}
