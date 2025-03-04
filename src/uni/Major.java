package uni;

import base.Person;

import java.util.ArrayList;

public class Major {
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity;
    public int numberOfStudents;


    public Major(String name, int capacity){
        this.name = name;
        this.id = majorList.size();
        this.capacity = capacity;
        majorList.add(this);
    }

    public static Major findById(int id){
        for (Major major : majorList){
            if (major.id == id){
                return major;
            }
        }
        return null;
    }

    public void addStudent(){

        if (numberOfStudents < capacity){
            numberOfStudents++;
        }
        System.out.println("error");
    }
}
