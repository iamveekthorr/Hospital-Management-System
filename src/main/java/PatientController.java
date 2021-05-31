import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientController {
    List<PatientModel> getAllPatients(){
        List<PatientModel> patient = null;
        ResultSet resultSet;
        try{
            String selectStatement = "SELECT * FROM Patients";
            PreparedStatement selectAllPatients = CreateConnection.getConn().prepareStatement(selectStatement);
            resultSet = selectAllPatients.executeQuery();
            patient = new ArrayList<>();
            while(resultSet.next()){
                patient.add(new PatientModel(
                        resultSet.getInt("PATIENT_ID"),
                        resultSet.getInt("AGE"),
                        resultSet.getInt("PHONE_NUMBER"),
                        resultSet.getInt("NEXT_OF_KIN_PHONE_NUMBER"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("NEXT_OF_KIN_NAME") ));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return patient;
    }

    int addPatient(String firstName, String lastName, String nextOfKinName, String symptomsDescription,
                   int phoneNumber, int age, int nextOfKinPhoneNumber){
        int result = 0;
        try{
            PatientQueries newPatient = new PatientQueries();
            String insertStatement = newPatient.insertPatientQuery();
            PreparedStatement addNewPatient = CreateConnection.getConn().prepareStatement(insertStatement);
            addNewPatient.setString(1, firstName);
            addNewPatient.setString(2, lastName);
            addNewPatient.setString(3, nextOfKinName);
            addNewPatient.setString(4, symptomsDescription);
            addNewPatient.setInt(5, phoneNumber);
            addNewPatient.setInt(6, age);
            addNewPatient.setInt(7, nextOfKinPhoneNumber);
            result = addNewPatient.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    ResultSet getOnePatient(@NotNull Connection conn){
        try{
            String getPatient = "SELECT * FROM Patients WHERE ID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(getPatient);
            return preparedStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
