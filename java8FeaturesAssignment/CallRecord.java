package assignment.callJava8Assignment;

import java.time.LocalDateTime;

public class CallRecord {
	private String callerNumber;
	private String receiverNumber;
	private LocalDateTime startTime;
	private int durationSeconds;
	private String operator;
	private String location;

	public CallRecord(String callerNumber, String receiverNumber, LocalDateTime startTime, int durationSeconds,
			String operator, String location) {
		this.callerNumber = callerNumber;
		this.receiverNumber = receiverNumber;
		this.startTime = startTime;
		this.durationSeconds = durationSeconds;
		this.operator = operator;
		this.location = location;
	}

	public String getCallerNumber() {
		return callerNumber;
	}

	public String getReceiverNumber() {
		return receiverNumber;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public int getDurationSeconds() {
		return durationSeconds;
	}

	public String getOperator() {
		return operator;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return String.format("Caller: %s, Receiver: %s, Start: %s, Duration: %ds, Operator: %s, Location: %s",
				callerNumber, receiverNumber, startTime, durationSeconds, operator, location);
	}
}
