package di.autowired;

import org.springframework.beans.factory.annotation.Autowired;

import di.tire.Tire;

public class Car {
	
	@Autowired
//	@Qualifier("sTire")
//	private Tire sTire;
	private Tire gTire;
	
	public String getInfo() {
		return gTire.getProduct() + "장착!!!";
	}
	
	public Tire getTire() {
		return gTire;
	}

	public void setTire(Tire tire) {
		this.gTire = tire;
	}
	
}
