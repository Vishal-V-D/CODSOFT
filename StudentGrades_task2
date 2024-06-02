import java.util.Scanner;

public class StudentGrades_task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];

        inputMarks(scanner, marks);
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        char grade = calculateGrade(averagePercentage);

        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    private static void inputMarks(Scanner scanner, int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            int mark;
            do {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                mark = scanner.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                }
            } while (mark < 0 || mark > 100);
            marks[i] = mark;
        }
    }

    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return totalMarks / (double) numberOfSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
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

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
