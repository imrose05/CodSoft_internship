import java.util.Scanner;

public class GradeCalculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Subjects: ");
        int numOfSubjects=sc.nextInt();
        int marks[]=new int[numOfSubjects];
        int totalMarks=0;
        for(int i=0;i<numOfSubjects;i++){
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                i--;
        }
        else{
            totalMarks=totalMarks+marks[i];

        }

    }
    double averagePercentage=(double) totalMarks/numOfSubjects;

    char grade;
    if (averagePercentage >= 90) {
        grade = 'A';
    } else if (averagePercentage >= 80) {
        grade = 'B';
    } else if (averagePercentage >= 70) {
        grade = 'C';
    } else if (averagePercentage >= 60) {
        grade = 'D';
    } else {
        grade = 'F';
    }
    System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
