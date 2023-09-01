package mainpkg.Trainer;

import mainpkg.dg.Request;
import jailor.Prisoner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import login.LogInPageController;
import mainpkg.ITOfficers.Ticket;
import user.AuthorityUser;

public class Trainer implements Serializable {

    public static void addNewTrainingCourse(TrainingProgramCourses trainingProgramCourses) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("TrainingCourses.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(trainingProgramCourses);

            showAlert("New training courses added successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to add new training courses!");
            }
        }
    }

    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static ArrayList<TrainingProgramCourses> showCourse() {
        ArrayList<TrainingProgramCourses> courseList = new ArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TrainingCourses.bin"))) {
            while (true) {
                try {
                    TrainingProgramCourses course = (TrainingProgramCourses) ois.readObject();
                    System.out.println(course);
                    courseList.add(course);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return courseList;
    }
    public static ObservableList<Prisoner> showPrisoner(){
        
              ObservableList<Prisoner> prisonerList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Prisoner.bin"))) {
            while (true) {
                try {
                    Prisoner tempPrisoner = (Prisoner) ois.readObject();
                    System.out.println(tempPrisoner);
                    prisonerList.add(tempPrisoner);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return prisonerList;
    }
    
    
    
    

    public static boolean addPrisonerToCourse(String courseName, ArrayList<Prisoner> selectedPrisoners) {
        System.out.println("MethodCalled");

        CustomClassToShowCourseAndPrisoner prisonerCourseList = new CustomClassToShowCourseAndPrisoner(courseName, selectedPrisoners);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("prisonerCourseList.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(prisonerCourseList);
            System.out.println(prisonerCourseList);

            return true;
        } catch (IOException e) {
            System.err.println("Error adding prisoner course list: " + e.getMessage());
            return false;
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) { // Close the FileOutputStream as well
                    fos.close();
                }
            } catch (IOException ex) {
                System.err.println("Error closing streams: " + ex.getMessage());
            }
        }
    }
    
        public static ObservableList<PieChart.Data> prisonerCountPieChart() throws FileNotFoundException, IOException, ClassNotFoundException, ClassNotFoundException {

        ObservableList<PieChart.Data> tempList = FXCollections.observableArrayList();
        
         ObjectInputStream ois = null;
        CustomClassToShowCourseAndPrisoner temp = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("prisonerCourseList.bin"));

            while (true) {
                temp = (CustomClassToShowCourseAndPrisoner) ois.readObject();
                tempList.add(new PieChart.Data(temp.trainingCourse, temp.getPrisonersListSize()));
                System.out.println("Done");                   
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
//        
//        tempList.add(new PieChart.Data("CSE", 10));
//        tempList.add(new PieChart.Data("EEE", 20));
//        tempList.add(new PieChart.Data("BBA", 60));
        
        
        return tempList;
        

                    
        }
        
        
    public static void sendRequest(Request request) {
   
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            File file = new File("RequestList.bin");
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            System.out.println(request);
            oos.writeObject(request);

            showAlert("Request is added successfully in the list!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                showAlert("Error: Failed to add request in the list!");
            }
        }
    }
        
public static  ObservableList<PieChart.Data> pieChart(){
    ObservableList<PieChart.Data> tempPieChart= FXCollections.observableArrayList();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prisonerCourseList.bin"))) {
            while (true) {
                try {
                    CustomClassToShowCourseAndPrisoner tempCustom = (CustomClassToShowCourseAndPrisoner) ois.readObject();
                    System.out.println(tempCustom);
                    tempPieChart.add(new PieChart.Data(tempCustom.trainingCourse,tempCustom.getPrisonersListSize() ));
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempPieChart;
    }

    public static  ObservableList<CustomClassToShowCourseAndPrisoner> courseAndPrisonerList(){
         ObservableList<CustomClassToShowCourseAndPrisoner> tempList= FXCollections.observableArrayList();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prisonerCourseList.bin"))) {
            while (true) {
                try {
                    CustomClassToShowCourseAndPrisoner tempCustom = (CustomClassToShowCourseAndPrisoner) ois.readObject();
                    System.out.println(tempCustom);
                    tempList.add(tempCustom );
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }
        return tempList;
    
    
    }
}        
        
//}

                  
              
        
            
       



        
        

        
        

        
        

        
        


