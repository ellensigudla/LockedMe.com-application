package LockedMe;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LockedMe {
    private static List<String> directoryList = new ArrayList<>();
    private static final String desktopPath = System.getProperty("user.home") + "\\Desktop\\Ellen";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
        	try {
            System.out.println("Welcome to LockedMe.com");
            System.out.println("Developed by: [ELLEN SIGUDLA]");
            System.out.println("Choose an Option Below:");
            System.out.println("1. List files in ascending order");
            System.out.println("2. Manage files");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listFilesInAscendingOrder();
                    break;
                case 2:
                    manageFiles(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        	}catch(InputMismatchException e){
        		System.out.println("Invalid input. Please enter a valid input.");
        		scanner.nextLine();
            }
            }
        System.out.println("Exiting the application. !!Thank you for using LockedMe.com.");
        }

        
        
    

    private static void listFilesInAscendingOrder() {
        File desktopFolder = new File(desktopPath);
        File[] files = desktopFolder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("The desktop folder is empty.");
        } else {
            directoryList.clear();
            for (File file : files) {
                directoryList.add(file.getName());
            }

            Collections.sort(directoryList);
            System.out.println("Files in ascending order:");
            for (String fileName : directoryList) {
                System.out.println(fileName);
            }
        }
    }

    private static void manageFiles(Scanner scanner) {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\nFile Management Options:");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search for a file");
            System.out.println("4. Return to main menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void addFile(Scanner scanner) {
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();
        File newFile = new File(desktopPath + "\\" + fileName);

        try {
            if (newFile.createNewFile()) {
                System.out.println("File '" + fileName + "' added to the directory.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the file.");
        }
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the file name to delete: ");
        String fileNameToDelete = scanner.nextLine();
        File fileToDelete = new File(desktopPath + "\\" + fileNameToDelete);

        if (fileToDelete.exists() && fileToDelete.delete()) {
            System.out.println("File '" + fileNameToDelete + "' deleted from the directory.");
        } else {
            System.out.println("File not found or unable to delete.");
        }
    }

    private static void searchFile(Scanner scanner) {
        System.out.print("Enter the file name to search: ");
        String fileNameToSearch = scanner.nextLine();
        File searchFile = new File(desktopPath + "\\" + fileNameToSearch);

        if (searchFile.exists()) {
            System.out.println("File '" + fileNameToSearch + "' found in the directory.");
        } else {
            System.out.println("File not found.");
        }
    }
}
