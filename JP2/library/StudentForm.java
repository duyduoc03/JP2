package JP2.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StudentForm {
    public TextField sName;
    public TextField sEmail;
    public TextField sPhone;
    public TextField sBirthday;
    public TextArea sAddress;
    public Student editData;

    public void backStudents() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void submit(ActionEvent event) {
        String name = this.sName.getText();
        String email = this.sEmail.getText();
        String phone = this.sPhone.getText();
        String birthday = this.sBirthday.getText();
        String address = this.sAddress.getText();

        try {
            String sql_txt = "";
            if (this.editData == null){
                sql_txt = "insert into students (studentName,dateOfBirth,address,email,phoneNumber) values(?,?,?,?,?)";
            }
            else {
                sql_txt = "update students set studentName=?,dateOfBirth=?,address=?,email=?,phoneNumber=?" +
                        " Where id=" + this.editData.getId();
            }
            Connector conn = new Connector();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,name);
            stt.setString(2,birthday);
            stt.setString(3,address);
            stt.setString(4,email);
            stt.setString(5,phone);
            stt.execute();
            this.backStudents();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setEditData(Student editData) {
        this.editData = editData;

        this.sName.setText(editData.getStudentName());
        this.sEmail.setText(editData.getEmail());
        this.sPhone.setText(editData.getPhoneNumber());
        this.sBirthday.setText(editData.getDateOfBirth().toString());
        this.sAddress.setText(editData.getAddress());
    }
}
