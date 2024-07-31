public class Test {
    public static void main(String[] args) throws Exception {
        Student st1 = new Student("Priyanshu Kumar Jha", "1109", "B+");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(st1, view);

        controller.updateView();

        controller.setStudentName("Shiv narayan Jha");
        controller.setStudentGrade("B");
        controller.setStudentId("1129");

        controller.updateView();
    }
}
