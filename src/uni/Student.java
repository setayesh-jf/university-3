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
        this.personID = personID;
        this.enteranceYear = entranceYear;
        this.majorID = majorID;
        this.id = studentList.size();
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
        if (major != null){
        String enteranceYearstr = String.valueOf( enteranceYear);
        String majorIDstr = String.format("%d", majorID);
        String studentNumber = String.format("%d", major.numberOfStudents);
            this.studentID = enteranceYearstr + majorIDstr + studentNumber;
        }
        else {
            System.out.println("error");
        }


    }
}
