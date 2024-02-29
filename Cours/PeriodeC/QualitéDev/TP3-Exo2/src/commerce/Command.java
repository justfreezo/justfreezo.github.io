package commerce;

public class Command {
	private double price, weight;
	private boolean card;
	
	public Command(double price, double weight, boolean card) {
		this.price = price;
		this. weight = weight;
		this.card = card;
	}
	public double delivery() {
		double d = 0.;
		if(weight >= 5. && price <= 100.) {
			d = weight;
		}
		return d;
	}
	
	public double reduction () {
		double r = 1.;
		if(price >= 200) {
			r = 0.9;
		}
		if(card) {
			r *= 0.97;
		}
		if(price >= 200. && card && weight < 5.) {
			r = 0.85;
		}
		return r;
	}
	
	public double total(){
		return price * reduction() + delivery();  // R6
	}
}