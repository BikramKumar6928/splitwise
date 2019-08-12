package structurePackage;

import java.util.List;

public abstract class Group {
	private List<Expense> members;
	private String groupName;

	public Group(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return groupName;
	}
}
