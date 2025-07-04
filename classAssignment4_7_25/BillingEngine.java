package classAssignment4_7_25;

import java.util.*;

public class BillingEngine {
	private static BillingEngine instance;
	private List<BillObserver> observers = new ArrayList<>();

	private BillingEngine() {
	}

	public static BillingEngine getInstance() {
		if (instance == null) {
			instance = new BillingEngine();
		}
		return instance;
	}

	public void addObserver(BillObserver obs) {
		observers.add(obs);
	}

	public double generateBill(Customer c, List<CallLog> logs) {
		double total = 0;
		for (CallLog log : logs) {
			total += log.getMinutes() * c.plan.getRate();
		}
		for (BillObserver obs : observers) {
			obs.notify(c, total);
		}
		return total;
	}
}
