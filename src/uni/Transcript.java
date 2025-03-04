package uni;
import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript (int studentID){
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }

    public void setGrade (int presentedCourseID, double grade){
        PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
        if (presentedCourse != null && presentedCourse.studentIds.contains(studentID)){
            transcript.put(presentedCourseID, grade);
        }
        System.out.println("error");
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
                    nomreha = nomreha + transcript.get(courseID) * course.units;
                    Units = Units + course.units;
                }
            }
        }
        if (Units != 0){
            return nomreha / Units;
        }
        else {
            return 0.0;
        }
    }

}
