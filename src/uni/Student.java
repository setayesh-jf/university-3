package uni;
import java.util.ArrayList;
public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int enteranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID){
        this.id = studentList.size() + 1;
        this.personID = personID;
        this.enteranceYear = entranceYear;
        this.majorID = majorID;
        studentList.add(this);

        Major major = Major.findById(majorID);
        if (major != null){
            major.addStudent();
        }
        setStudentCode();
    }

    public static Student findById(int id){
        for (Student student : studentList){
            if (student.id == id){
                return student;
            }
        }
        return null;
    }

    public void setStudentCode(){
        Major major = Major.findById(majorID);
        if (major != null) {
            this.studentID = String.format("%d%02d%03d", enteranceYear, majorID, major.numberOfStudents);
        } else {
            System.out.println("Error: Major not found.");
        }


    }
}