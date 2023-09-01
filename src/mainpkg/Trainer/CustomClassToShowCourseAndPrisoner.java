/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Trainer;

import jailor.Prisoner;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class CustomClassToShowCourseAndPrisoner implements Serializable {
    public ArrayList<Prisoner> prisonerList;
    public String trainingCourse;


    public CustomClassToShowCourseAndPrisoner(String trainingCourse,ArrayList<Prisoner> prisonerList) {
        this.prisonerList = prisonerList;
        this.trainingCourse = trainingCourse;

    }

    public void addPrisoner(Prisoner prisoner) {
        prisonerList.add(prisoner);
    }

    // Method to retrieve prisoners from the course
    public ArrayList<Prisoner> getPrisonersList() {
        return prisonerList;
    }
    
    public int getPrisonersListSize(){
        return this.prisonerList.size();
    
    }

    public ArrayList<Prisoner> getPrisonerList() {
        return prisonerList;
    }

    public String getTrainingCourse() {
        return trainingCourse;
    }
    

    @Override
    public String toString() {
        return "CustomClassToShowCourseAndPrisoner{" + "prisonerList=" + prisonerList + ", trainingCourse=" + trainingCourse + '}';
    }
   
    
}
