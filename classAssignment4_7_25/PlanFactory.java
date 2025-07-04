package classAssignment4_7_25;

public class PlanFactory {
	public static Plan getPlan(String type) {
		if (type.equalsIgnoreCase("Prepaid"))
			return new PrepaidPlan();
		if (type.equalsIgnoreCase("Postpaid"))
			return new PostpaidPlan();
		throw new IllegalArgumentException("Invalid plan type");
	}
}
