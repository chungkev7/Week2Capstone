package co.grandcircus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week2Capstone {

	public static void main(String[] args) {
		
		int userChoice;
		int taskNumber = 1;
		int toQuit = 1;
		String deleteConfirmation;
		boolean isValidDeleteChoice = true;
		String completionConfirmation;
		boolean isValidCompletionChoice = true;
		String quitConfirmation;
		boolean isValidQuitChoice = true;
		
		List<Task> allTasks = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Task Manager!\n");
		
		while (toQuit != 5) {
		System.out.println("1. List tasks");
		System.out.println("2. Add task");
		System.out.println("3. Delete task");
		System.out.println("4. Mark task complete");
		System.out.println("5. Quit");
		
		userChoice = Validator.getInt(scan, "\nWhat would you like to do? (Enter number):", 1, 5);
		
		if (userChoice == 1) {
			System.out.println();
			System.out.printf("%-7s   %-10s %-20s %-30s\n", "Done?", "Due Date", "Team Member", "Description");
			System.out.println();
			for (Task task : allTasks) {
				System.out.println(taskNumber++ + ". " + task);
			}
			taskNumber = 1;
		} else if (userChoice == 2) {
			System.out.println("\nPlease add information for new task below: ");
			String memberName = Validator.getString(scan, "Task member name: ");
			String taskDesc = Validator.getString(scan, "Task Description: ");
			String dateDue = Validator.getStringMatchingRegex(scan, "Due Date: ", "([\\d]{2}[/][\\d]{2}[/][\\d]{4})");
			System.out.println();
			allTasks.add(new Task(dateDue, memberName, taskDesc));
			System.out.println("Task entered! \n");
		} else if (userChoice == 3) {
			while (isValidDeleteChoice) {
			int deleteChoice = Validator.getDeleteInt(scan, "\nWhich task would you like to delete? ");
				if(deleteChoice > allTasks.size() || deleteChoice <0) {
					System.out.println("Sorry, the task number does not exist. ");
				} else {
					System.out.println(allTasks.get(deleteChoice - 1));
					deleteConfirmation = Validator.getString(scan, "Are you sure you want to delete? (y/n)\n").substring(0, 1);
					if (deleteConfirmation.equalsIgnoreCase("y")) {
						allTasks.remove(deleteChoice - 1);
						isValidDeleteChoice = false;
						System.out.println();
					} else if(deleteConfirmation.equalsIgnoreCase("n")) {
						isValidDeleteChoice = false;
					} else {
						System.out.println("That's not a valid choice. Please try again. ");
					}
				}
			}
		} else if (userChoice == 4) {
			while (isValidCompletionChoice) {
			int markComplete = Validator.getTaskDone(scan, "\nWhich task would you like to mark as completed? ");
			if (markComplete > allTasks.size() || markComplete <0) {
				System.out.println("Sorry, the task number does not exist. ");
			} else {
				System.out.println(allTasks.get(markComplete - 1));
				completionConfirmation = Validator.getString(scan, "Are you sure you want to mark as completed? (y/n)\n").substring(0, 1);
				if (completionConfirmation.equalsIgnoreCase("y")) {
					allTasks.get(markComplete - 1).setComplete(true);
					isValidCompletionChoice = false;
					System.out.println();
				} else if(completionConfirmation.equals("n")) {
					isValidCompletionChoice = false;
				} else {
					System.out.println("That's not a valid choice. Please try again. ");
				}
			}
			}
		} else if (userChoice == 5) {
			while (isValidQuitChoice) {
			quitConfirmation = Validator.getString(scan, "Are you sure you want to quit? (y/n)\n").substring(0, 1);
				if (quitConfirmation.equalsIgnoreCase("y")) {
					toQuit = 5;
					isValidQuitChoice = false;
					System.out.println();
				} else if (quitConfirmation.equalsIgnoreCase("n")) {
					isValidQuitChoice = false;
				} else {
					System.out.println("That's not a valid choice. Please try again. ");
				}
			}
		}
		isValidDeleteChoice = true;
		isValidCompletionChoice = true;
		isValidQuitChoice = true;
		}
		
		System.out.println("Have a nice day!");
		scan.close();
	}

}
