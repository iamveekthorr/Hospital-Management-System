import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorQueries {
    @NotNull
    @Contract(pure = true)
    static String createDoctorTable(){
        return  "CREATE TABLE IF NOT EXISTS Doctors(DOCTOR_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "DOCTOR_FIRST_NAME TEXT NOT NULL, DOCTOR_LAST_NAME TEXT NOT NULL, " +
                "AGE INTEGER NOT NULL, ROLE VARCHAR(50) NOT NULL DEFAULT 'DIAGNOSTICIAN'," +
                "DEPARTMENT VARCHAR(50) DEFAULT 'GENERAL MEDICINE', PASSWORD LONGTEXT NOT NULL)";
    }

    @NotNull
    @Contract(pure = true)
    static String insertIntoDoctorsTable(){
        return "INSERT INTO Doctors(DOCTOR_FIRST_NAME, DOCTOR_LAST_NAME, AGE," +
                "DEPARTMENT, PASSWORD)" +
                "VALUES( ? , ? , ? , ? , ? )" ;
    }

    static PreparedStatement selectAllDoctors(){
        PreparedStatement selectDoctors = null;
        try{
            String selectStatement = "SELECT * FROM Patients";
            selectDoctors = CreateConnection.getConn().prepareStatement(selectStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return selectDoctors;
    }

    static PreparedStatement selectOneDoctor(){
        PreparedStatement selectDoctor = null;
        String selectDoctorStatement = "SELECT FIRST_NAME FROM Doctors WHERE ID = ?";
        try{
            selectDoctor = CreateConnection.getConn().prepareStatement(selectDoctorStatement);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return selectDoctor;
    }
}
