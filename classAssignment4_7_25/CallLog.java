package classAssignment4_7_25;

import java.time.LocalDateTime;

public class CallLog {
	String caller, receiver;
	LocalDateTime start, end;
	long durationSeconds;

	public CallLog(String caller, String receiver, int seconds) {
		this.caller = caller;
		this.receiver = receiver;
		this.start = LocalDateTime.now();
		try {
			Thread.sleep(seconds * 1000L);
		} catch (Exception e) {
		}
		this.end = LocalDateTime.now();
		this.durationSeconds = seconds;
	}

	public long getMinutes() {
		return (long) Math.ceil(durationSeconds / 60.0);
	}

	public String toString() {
		return caller + " ➝ " + receiver + " | " + durationSeconds + "s";
	}
}
