package classAssignment4_7_25;

public class SMSNotifier implements BillObserver {
	public void notify(Customer c, double amount) {
		System.out.println("[SMS] Dear " + c.name + ", your bill is ₹" + amount);
	}
}
