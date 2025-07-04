package classAssignment4_7_25;

public class Customer {
	String name;
	String phone;
	Plan plan;

	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public void activatePlan(String planType) {
		this.plan = PlanFactory.getPlan(planType);
	}

	public String toString() {
		return name + " (" + phone + ") - " + (plan != null ? plan.getType() : "No Plan");
	}
}
