/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg.Trainer;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class TrainingProgramCourses implements Serializable{
    private int courseId;
    private String courseName;
    private String courseType;
    private String courseDuration;
    private int courseCapacity;
    private String schedule;
    private String courseDescription;


    public TrainingProgramCourses(int courseId, String courseName, String courseType, String courseDuration, int courseCapacity, String schedule,String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDuration = courseDuration;
        this.courseCapacity = courseCapacity;
        this.schedule = schedule;
        this.courseDescription = courseDescription;
        
        
        
    }

    public int getCourseId() {
        return courseId;
        
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }


    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
  
        sb.append(courseName);
        return sb.toString();
    }
 
    
    
    
}
