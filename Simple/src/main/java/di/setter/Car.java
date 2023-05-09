package di.setter;

import di.tire.Tire;

public class Car {

	private Tire tire;
	
	public void setTire(Tire tire) {
		
		//Setter 의존성 주입, Setter DI
		this.tire = tire;
		
	}

	public String getTire() {
		return tire.getProduct() + "장착했습니다!";
	}
	
}






