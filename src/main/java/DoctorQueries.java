import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorQueries {
    @NotNull
    @Contract(pure = true)
    static String createDoctorTable(){
        return  "CREATE TABLE IF NOT EXISTS Doctors(DOCTOR_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "NAME TEXT NOT NULL, PHONE_NUMBER VARCHAR(11) NOT NULL UNIQUE," +
                "AGE VARCHAR(50) NOT NULL, ROLE VARCHAR(50) NOT NULL DEFAULT 'DIAGNOSTICIAN'," +
                "DEPARTMENT VARCHAR(50) DEFAULT 'GENERAL MEDICINE', PASSWORD LONGTEXT NOT NULL)";
    }

    @NotNull
    @Contract(pure = true)
    static String insertIntoDoctorsTable(){
        return "INSERT INTO Doctors(NAME, ROLE, AGE," +
                "DEPARTMENT, PASSWORD, PHONE_NUMBER)" +
                "VALUES( ? , ? , ? , ? , ?, ? )" ;
    }

    static PreparedStatement selectAllDoctors(){
        PreparedStatement selectDoctors = null;
        try{
            String selectStatement = "SELECT * FROM Doctors";
            selectDoctors = CreateConnection.getConn().prepareStatement(selectStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return selectDoctors;
    }

    static PreparedStatement selectOneDoctor(String phone){
        PreparedStatement selectDoctor = null;
        String selectDoctorStatement = "SELECT * FROM Doctors WHERE PHONE_NUMBER = ?";
        try{
            selectDoctor = CreateConnection.getConn().prepareStatement(selectDoctorStatement);
            selectDoctor.setString(1, phone);
//            selectDoctor.setString(2, password);
            return selectDoctor;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return selectDoctor;
    }
}
