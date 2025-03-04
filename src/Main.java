import base.Person;
import uni.Major;
import uni.Student;
import uni.Professor;
import uni.Course;
import uni.PresentedCourse;
import uni.Transcript;

public class Main {
    public  static void main (String[] args) {
        Major math = new Major("Mathematics", 60);
        Major cs = new Major("Computer Sience", 60);

        Person person1 = new Person("Farhad Khosravi", "0321516777");
        Person person2 = new Person("Roza Rahmati", "0313325879");
        Person person3 = new Person("Reza Norozi", "0417788906");
        Person person4 = new Person("Ava Beighi", "0332256712");
        Person person5 = new Person("Saeid Rezaii", "0331426789");

        Student student1 = new Student(person1.id, 1401, math.id);
        Student student2 = new Student(person2.id, 1402, math.id);
        Student student3 = new Student(person3.id, 1403, cs.id);

        for (Student student : Student.studentList){
            System.out.println("Name: " + Person.findByID(student.personID).name);
            System.out.println("Student Number: " + student.studentID);
        }

        Professor professor1 = new Professor(person4.id, cs.id);
        Professor professor2 = new Professor(person5.id, math.id);

        for (Professor professor : Professor.professorList){
            System.out.println("Name: " + Person.findByID(professor.personID).name);
            System.out.println("Professor ID: " + professor.id);
        }

        Course course1 = new Course("Advanced Programming", 4);
        Course course2 = new Course("Mabani Ehtemal", 3);
        Course course3 = new Course("Mabani olomriazi", 3);

        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, professor1.id, 60);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, professor1.id, 50);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, professor2.id, 70);

        presentedCourse1.addStudent(student1.id);
        presentedCourse1.addStudent(student2.id);

        presentedCourse2.addStudent(student1.id);
        presentedCourse2.addStudent(student2.id);
        presentedCourse2.addStudent(student3.id);

        presentedCourse3.addStudent(student3.id);

        Transcript transcript1 = new Transcript(student1.id);
        transcript1.setGrade(presentedCourse1.id, 20);
        transcript1.setGrade(presentedCourse2.id, 18.95);

        Transcript transcript2 = new Transcript(student2.id);
        transcript2.setGrade(presentedCourse1.id, 16.55);
        transcript2.setGrade(presentedCourse2.id, 17);

        Transcript transcript3 = new Transcript(student3.id);
        transcript3.setGrade(presentedCourse2.id, 19.75);
        transcript3.setGrade(presentedCourse3.id, 18.90);

        transcript1.printTranscript();
        System.out.println("GPA: " + transcript1.getGPA());

        transcript2.printTranscript();
        System.out.println("GPA: " + transcript2.getGPA());

        transcript3.printTranscript();
        System.out.println("GPA: " + transcript3.getGPA());
    }

}