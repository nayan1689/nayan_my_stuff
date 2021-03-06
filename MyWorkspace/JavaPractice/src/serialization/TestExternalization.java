package serialization;

import java.io.*;

public class TestExternalization {

	public static void main (String a[]) {
		TestExternalization test = new TestExternalization();
		test.seriableObj(new NewCar(200, 300, "1800cc"));
		test.deSerializeObj();
	}
	
	public void seriableObj (NewCar car) {
		try (FileOutputStream fo = new FileOutputStream("C:/objsStore/superCar.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			) {
			car.writeExternal(oo);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void deSerializeObj () {
		try (FileInputStream fi = new FileInputStream("/objsStore/superCar.ser");
			ObjectInputStream oi = new ObjectInputStream(fi)) {
			NewCar car = new NewCar();
			car.readExternal(oi);
			System.out.println(car.toString());
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class NewCar implements Externalizable {

	int maxSpeed;
	int maxAcceleratoin;
	String engineCapacity = "";
	
	NewCar (int maxSpeed, int maxAcceleratoin, String engineCapacity) {
		this.maxSpeed = maxSpeed;
		this.maxAcceleratoin = maxAcceleratoin;
		this.engineCapacity = engineCapacity;
	}
	
	public NewCar() {
		// TODO Auto-generated constructor stub
	}

	public String toString () {
		return maxAcceleratoin + " -- " + maxSpeed + "--" + engineCapacity;
	}
	
	@Override
	public void writeExternal(ObjectOutput oo) throws IOException {
		oo.writeInt(maxSpeed);
		oo.writeInt(maxAcceleratoin);
		oo.writeObject(engineCapacity);
		
	}

	@Override
	public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
		this.maxSpeed = oi.readInt();
		this.maxAcceleratoin = oi.readInt();
		this.engineCapacity = (String)oi.readObject();
		
	}
}
