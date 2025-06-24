package tcmsAssignment;

public class Call {
    private final String calledNumber;
    private final int durationSeconds;

    public Call(String calledNumber, int durationSeconds) {
        this.calledNumber = calledNumber;
        this.durationSeconds = durationSeconds;
    }

    public String getCalledNumber() {
        return calledNumber;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        return "Call to: " + calledNumber + ", Duration: " + durationSeconds + " seconds";
    }
}
