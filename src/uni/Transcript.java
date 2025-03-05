package uni;
import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript (int studentID){
        this.studentID = studentID;
    }

    public void setGrade (int presentedCourseID, double grade){
        PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
        if (presentedCourse != null && presentedCourse.studentIds.contains(studentID)){
            transcript.put(presentedCourseID, grade);
        }
        System.out.println("error, Student nemitoneh dar class bashe");
    }

    public void printTranscript(){
        Person student = Person.findByID(studentID);
        if (student != null){
            System.out.println("Name: " + student.name);
            System.out.println("StudentNumber: " + studentID);
        }
        for (Integer courseID : transcript.keySet()){
            PresentedCourse presentedCourse = PresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null){
                    System.out.println(course.title + ": " + transcript.get(courseID));
                }
            }

        }
    }

    public double getGPA(){
        double nomreha = 0.0;
        int Units = 0;
        for (Integer courseID : transcript.keySet()){
            PresentedCourse presentedCourse = PresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    nomreha =+ transcript.get(courseID) * course.units;
                    Units =+ course.units;
                }
            }
        }
        return Units == 0 ? 0.0 : nomreha / Units;
    }

}