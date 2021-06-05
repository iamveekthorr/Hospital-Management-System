import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    static List<DoctorModel> getAllDoctors(){
        List<DoctorModel> doctors = null;
        ResultSet resultSet;
        try{
            resultSet = DoctorQueries.selectAllDoctors().executeQuery();
            doctors = new ArrayList<>();
            while(resultSet.next()){
                doctors.add(new DoctorModel(
                        resultSet.getInt("DOCTOR_ID"),
                        resultSet.getString("AGE"),
                        resultSet.getString("PHONE_NUMBER"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("PASSWORD") ));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return doctors;
    }

    static List<DoctorModel> getOneDoctor(String name){
        List<DoctorModel> doctor = null;
        ResultSet resultSet;
        try{
            resultSet = DoctorQueries.selectOneDoctor(name).executeQuery();
            doctor = new ArrayList<>();
            while(resultSet.next()){
                doctor.add(new DoctorModel(resultSet.getInt("DOCTOR_ID")));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return doctor;
    }

    static int createDoctor(String name, String role,
                   String phoneNumber, String age, String department, String password){
        int result = 0;
        try{
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
            String insertStatement = DoctorQueries.insertIntoDoctorsTable();
            PreparedStatement addNewDoctor = CreateConnection.getConn().prepareStatement(insertStatement);
            addNewDoctor.setString(1, name);
            addNewDoctor.setString(2, role);
            addNewDoctor.setString(3, age);
            addNewDoctor.setString(4, department);
            addNewDoctor.setString(5, hashedPassword);
            addNewDoctor.setString(6, phoneNumber);
            result = addNewDoctor.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
