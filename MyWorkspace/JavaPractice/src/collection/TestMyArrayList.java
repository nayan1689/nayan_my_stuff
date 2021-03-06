package collection;

import java.util.Arrays;

public class TestMyArrayList {
	
	public static void main (String a[]) {
		MyList<Integer> myList = new MyList<>();
		myList.add(1);myList.add(2);myList.add(3);
		myList.add(4);myList.add(5);myList.add(6);
		myList.add(11);myList.add(12);myList.add(13);
		myList.add(14);myList.add(15);myList.add(16);
		
		myList.get(2);
		myList.get(8);
		
		myList.remove(3);
		myList.remove(9);
		
		myList.get(2);
		myList.get(8);
		
	}
	
}

class MyList<E> {
	
	int modCount;
	int size;
	
	private transient Object[] elements;
	
	public void add (E e) {
		if (elements == null) {
			elements = new Object[10];
		}
		modCount++;
		//checking if list exhausted
		if (size == elements.length) {
			int newSize = size + (elements.length / 2);
			elements = Arrays.copyOf(elements,newSize);
		}
		
		elements[size++] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E get (int index) {
		if (index < 0 || index >= elements.length) {
			throw new RuntimeException("invalid index");
		} 
		return (E) elements[index];
	}
	
	public boolean remove (Object o) {
		
		boolean removed = false;
		for (int i = 0; i < elements.length; i++) {
			if (o.equals(elements[i])) {
				remove(i);
				removed=true;
			}
		}
		
		return removed;
	}
	
	@SuppressWarnings("unchecked")
	public E remove (int index) {
		if (index < 0 || index >= elements.length) {
			throw new RuntimeException("invalid index");
		}
		E e = (E)elements[size--];
		System.arraycopy(elements, index, elements, index - 1, (size - index + 1));
		return e;
		
	}
	
	
}