package JP2.library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Date;

public class Student {
    public Integer id;
    public String studentName;
    public Date dateOfBirth;
    public String address;
    public String email;
    public String phoneNumber;
    public Button editBtn;

    public Student(Integer id, String studentName, Date dateOfBirth, String address, String email, String phoneNumber){
        this.id = id;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.editBtn = new Button("Edit");
        this.editBtn.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentForm.fxml"));
                Parent root = loader.load();
                StudentForm d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            }
            catch (Exception ignored){

            }
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(Button editBtn) {
        this.editBtn = editBtn;
    }
}
