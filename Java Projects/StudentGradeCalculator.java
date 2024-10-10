import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to calculate the total marks from the scores
    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate the average percentage
    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    // Method to assign a grade based on the average percentage
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Main method to control the flow of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student's name
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();

        // Get the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store the marks obtained in each subject
        int[] marks = new int[numSubjects];

        // Get the marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
        }

        // Calculate the total marks
        int totalMarks = calculateTotalMarks(marks);

        // Calculate the average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        // Calculate the grade
        char grade = calculateGrade(averagePercentage);

        // Display the result
        System.out.println("\nStudent: " + name);
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
