import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Course {
	private static String code;
	private static int credit;
	private static String grade;
	public static String IN_FILE;
	public static String id;
	
	DecimalFormat formmater = new DecimalFormat("##.00");

	static Scanner scanner = new Scanner(System.in);
	static BufferedReader br = null;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Course() {

	}

	public Course(String code, int credit, String grade) {
		this.code = code;
		this.credit = credit;
		this.grade = grade;
	}

	public static String displayMenu() {
		System.out.println("Welcome to Student Info. System.");
		System.out.println("Please select an option:");
		System.out.println("(R)ead a student report");
		System.out.println("(S)how all courses and GPA");
		System.out.println("(E)xit");
		System.out.println("Enter your option >> ");
		String option = scanner.nextLine();

		return option;
	}

	public static void readFile() {

	}

	public static String receiveStudentID() {
		System.out.println("Enter the student ID >> ");
		id = scanner.nextLine();
		return id;
	}

	public static Course[] readInputs(String IN_FILE) {
		IN_FILE = id + ".txt";

		String line;
		int counter = 0;
		Course[] courses = new Course[100];
		double GPA = 0;
		double totalCredits = 0;
		double totalPoints = 0;

		try {
			br = new BufferedReader(new FileReader(IN_FILE));
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(","); // delimiter
				code = tokens[0];
				String temp = tokens[1];
				credit = Integer.parseInt(temp);
				grade = tokens[2];
				


				System.out.println("Course #" + (counter + 1) + ": " + code + "(" + credit + " credit) : " + grade);
				counter++;
				
				
				double points = 0;
				double[] credits = new double[courses.length];

				for (int i = 0; i < 100; i++) {
					switch (grade) {
					case "A+":
						points = 4.3;
						break;
					case "A":
						points = 4;
						break;
					case "A-":
						points= 3.7;
						break;
					case "B+":
						points = 3.3;
						break;
					case "B":
						points = 3;
						break;
					case "B-":
						points = 2.7;
						break;
					case "C+":
						points = 2.3;
						break;
					case "C":
						points = 2;
						break;
					case "C-":
						points = 1.7;
						break;
					case "D+":
						points = 1.3;
						break;
					case "D":
						points = 1;
						break;
					case "F":
						points = 0;
						break;
					default:

					}

				}
				for(int i = 0; i < 100; i++) {
					totalPoints += (credit*points);
					totalCredits += credit;
					GPA = totalPoints/totalCredits;
					
				}

			}
			System.out.println("GPA: "+ String.format("%.2f", GPA));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return courses;
	}


}
