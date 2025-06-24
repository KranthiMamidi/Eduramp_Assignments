package tcmsAssignment;

import java.util.Date;

public class Complaint {
	private final String description;
	private final Date dateFiled;

	public Complaint(String description) {
		this.description = description;
		this.dateFiled = new Date();
	}

	public String getDescription() {
		return description;
	}

	public Date getDateFiled() {
		return dateFiled;
	}

	@Override
	public String toString() {
		return "[" + dateFiled + "] " + description;
	}
}
