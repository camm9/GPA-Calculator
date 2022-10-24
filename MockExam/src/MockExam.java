
public class MockExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String option = " ";
		String exitOption = "E";
		String id;
		Course[] courses = new Course[100];
		double GPA;
		
		while(true) {
			option = Course.displayMenu();
			if(option.equals(exitOption)) {
				break;
			}
			if(option.equals("R")) {
				id = Course.receiveStudentID();
				courses = Course.readInputs(id);
		
			}
		
		}
		
	}

}
