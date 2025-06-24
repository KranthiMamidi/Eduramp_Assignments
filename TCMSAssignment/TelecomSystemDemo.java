package tcmsAssignment;

public class TelecomSystemDemo {
	public static void main(String[] args) {
		TelecomManagementSystem system = new TelecomManagementSystem();

		system.addCustomer("C001", "Kranthi");
		system.addCustomer("C002", "Mahesh");

		system.recordCall("C001", "9876543210", 120);
		system.recordCall("C001", "1234567890", 300);
		system.recordCall("C002", "5555555555", 60);

		system.subscribeVAS("C001", "Caller Tune");
		system.subscribeVAS("C001", "Missed Call Alert");
		system.subscribeVAS("C002", "Caller Tune");

		system.unsubscribeVAS("C002", "Caller Tune");

		system.fileComplaint("C001", "Network outage in area");
		system.fileComplaint("C002", "Slow internet speed");

		system.viewComplaints("C001");
		system.viewComplaints("C002");

		system.displayAllCustomers();
	}
}
