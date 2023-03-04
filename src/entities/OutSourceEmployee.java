package entities;

public class OutSourceEmployee extends Employee{
	private double additionalCharge;
	
	public OutSourceEmployee(){
		
	}

	public OutSourceEmployee(String name, Integer hours, Double valuePerHour, double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	public double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public double payment() {
		return super.payment() + additionalCharge * 1.1;
		
		//additionalCharge += additionalCharge * 1.1;
		//double sum = (hours * valuePerHour) + additionalCharge;
		//return sum;
	}
	
	@Override
	public String toString() {
		return super.getName()
				+ " - $"
				+ String.format("%.2f", payment());
	}
}
