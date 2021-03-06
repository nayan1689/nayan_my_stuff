package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * In the below example if Car does not implement serialization and RacingCar does then
 * it will throw ClassNotFound Exception while de-serializing 
 * if there is not default constructor
 * **/

public class TestSerialization {
	
	public static void main (String a[]) {
		
		RacingCar car = new RacingCar(200, 350, "1800cc");
		car.seriableObj(car);
		car.deSerializeObj();
	}
}

class Car {
	String engineCapacity;
	Car (String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	
	Car () {
		this.engineCapacity = "";
	}
}

class RacingCar extends Car implements Serializable {
	int maxSpeed;
	int maxAcceleratoin;
	
	RacingCar (int maxSpeed, int maxAcceleratoin, String engineCapacity) {
		super(engineCapacity);
		this.maxSpeed = maxSpeed;
		this.maxAcceleratoin = maxAcceleratoin;
	}
	
	public String toString () {
		return maxAcceleratoin + " -- " + maxSpeed + "--" + engineCapacity;
	}
	
	public void seriableObj (RacingCar car) {
		try (FileOutputStream fo = new FileOutputStream("C:/objsStore/superCar.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			) {
			oo.writeObject(car);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void deSerializeObj () {
		try (FileInputStream fi = new FileInputStream("/objsStore/superCar.ser");
			ObjectInputStream oi = new ObjectInputStream(fi)) {
			RacingCar car = (RacingCar)oi.readObject();
			System.out.println(car.toString());
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}