import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    List<DoctorModel> getAllDoctors(){
        List<DoctorModel> doctors = null;
        ResultSet resultSet;
        try{
            resultSet = new DoctorQueries().selectAllDoctors().executeQuery();
            doctors = new ArrayList<>();
            while(resultSet.next()){
                doctors.add(new DoctorModel(
                        resultSet.getInt("DOCTOR_ID"),
                        resultSet.getInt("AGE"),
                        resultSet.getInt("PHONE_NUMBER"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("PASSWORD") ));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return doctors;
    }

    int addDoctor(String firstName, String lastName, String nextOfKinName,
                   int phoneNumber, int age, int nextOfKinPhoneNumber){
        int result = 0;
        try{
            DoctorQueries newDoctor = new DoctorQueries();
            String insertStatement = newDoctor.insertIntoDoctorsTable();
            PreparedStatement addNewPatient = CreateConnection.getConn().prepareStatement(insertStatement);
            addNewPatient.setString(1, firstName);
            addNewPatient.setString(2, lastName);
            addNewPatient.setString(3, nextOfKinName);
            addNewPatient.setInt(5, phoneNumber);
            addNewPatient.setInt(6, age);
            addNewPatient.setInt(7, nextOfKinPhoneNumber);
            result = addNewPatient.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
