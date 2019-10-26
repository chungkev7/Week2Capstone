package co.grandcircus;

public class Task {
	
	private String memberName;
	private String taskDescription;
	private String dueDate;
	private boolean isCompleted;
	
	public Task() {
		memberName = "";
		taskDescription = "";
		dueDate = "";
		isCompleted = false;
	}
	
	public Task(String date, String name, String description) {
		isCompleted = false;
		dueDate = date;
		memberName = name;
		taskDescription = description;
	}
	
	public void setMemberName(String name) {
		this.memberName = name;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setTaskDescription(String description) {
		this.taskDescription = description;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public void setDueDate(String date) {
		this.dueDate = date;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public String toString() {
		return String.format("%-7s%-10s %-20s %-30s\n", isCompleted, dueDate, memberName, taskDescription);
	}
	
	public void setComplete(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public boolean setComplete() {
		return isCompleted;
	}
}
