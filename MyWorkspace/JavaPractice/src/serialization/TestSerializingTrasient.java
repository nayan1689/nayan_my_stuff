package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * If serialization of transient variable
 * 
 * */
public class TestSerializingTrasient {

	public static void main (String a[]) {
		
		TestSerializingTrasient test = new TestSerializingTrasient();
		test.seriableObj(new myRacingCar(200, 300, "1800cc"));
		test.deSerializeObj();
	}
	
	public void seriableObj (RacingCar1 car) {
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
			RacingCar1 car = (RacingCar1)oi.readObject();
			System.out.println(car.toString());
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


class RacingCar1 implements Serializable {
	private static final long serialVersionUID = 1L;
	int maxSpeed;
	int maxAcceleratoin;
	transient String engineCapacity = "";
	
	RacingCar1 (int maxSpeed, int maxAcceleratoin, String engineCapacity) {
		this.maxSpeed = maxSpeed;
		this.maxAcceleratoin = maxAcceleratoin;
		this.engineCapacity = engineCapacity;
	}
	
	public String toString () {
		return maxAcceleratoin + " -- " + maxSpeed + "--" + engineCapacity;
	}
	
}

class myRacingCar extends RacingCar1 {
	private static final long serialVersionUID = -9183000956773051272L;

	myRacingCar(int maxSpeed, int maxAcceleratoin, String engineCapacity) {
		super(maxSpeed, maxAcceleratoin, engineCapacity);
	}
	private void writeObject(ObjectOutputStream oo) throws IOException {
		oo.writeInt(maxSpeed);
		oo.writeInt(maxAcceleratoin);
		oo.writeObject(engineCapacity);
	}
	
	private void readObject(ObjectInputStream oi) throws IOException, ClassNotFoundException {
		this.maxSpeed = oi.readInt();
		this.maxAcceleratoin = oi.readInt();
		this.engineCapacity = (String)oi.readObject();
	}
}