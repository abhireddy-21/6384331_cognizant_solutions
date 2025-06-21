public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Cognizant");
        student.setId("6384331");
        student.setGrade("A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        System.out.println("\n--- Updating student details ---\n");
        controller.setStudentName("Cognizant HandsOn");
        controller.setStudentGrade("O");
        controller.updateView();
    }
}
