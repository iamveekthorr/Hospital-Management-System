import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorQueries {
    String createDoctorTable(){
        return  "CREATE TABLE IF NOT EXISTS Doctors(DOCTOR_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "DOCTOR_FIRST_NAME TEXT NOT NULL, DOCTOR_LAST_NAME TEXT NOT NULL, " +
                "AGE INTEGER NOT NULL, ROLE VARCHAR(50) NOT NULL DEFAULT 'DIAGNOSTICIAN'," +
                "DEPARTMENT VARCHAR(50) DEFAULT 'GENERAL MEDICINE', PASSWORD LONGTEXT NOT NULL)";
    }

    String insertIntoDoctorsTable(){
        return "INSERT INTO Doctors(DOCTOR_FIRST_NAME, DOCTOR_LAST_NAME, AGE," +
                "DEPARTMENT, PASSWORD)" +
                "VALUES( ? , ? , ? , ? , ? )" ;
    }

    PreparedStatement selectAllDoctors(){
        PreparedStatement selectAllDoctors = null;
        try{
            String selectStatement = "SELECT * FROM Patients";
            selectAllDoctors = CreateConnection.getConn().prepareStatement(selectStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return selectAllDoctors;
    }
}
