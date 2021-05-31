import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientQueries {
    String createPatientTable(){
        return "CREATE TABLE IF NOT EXISTS Patients(" +
                "PATIENT_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "FIRST_NAME TEXT NOT NULL," +
                "LAST_NAME TEXT NOT NULL," +
                "AGE INTEGER NOT NULL," +
                "PHONE_NUMBER INTEGER(11) NOT NULL, " +
                "NEXT_OF_KIN_NAME TEXT NOT NULL," +
                "NEXT_OF_KIN_PHONE_NUMBER INTEGER(11) NOT NULL," +
                "SYMPTOMS_DESCRIPTION LONGTEXT NOT NULL," +
                "UNDERLYING_ILLNESS VARCHAR(10) DEFAULT 'NO'," +
                "ON_PRESCRIPTION VARCHAR(5) DEFAULT 'NO'," +
                "PRESCRIBED_DRUG LONGTEXT," +
                "CREATED_AT DATETIME DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP," +
                "ATTENDING_DOCTOR INTEGER, FOREIGN KEY (ATTENDING_DOCTOR) REFERENCES Doctors(DOCTOR_ID)," +
                "UNIQUE(PATIENT_ID))" ;
    }

    String insertPatientQuery(){
        return "INSERT INTO Patients(FIRST_NAME, LAST_NAME, AGE, SYMPTOMS_DESCRIPTION," +
                        "PHONE_NUMBER, NEXT_OF_KIN_NAME, NEXT_OF_KIN_PHONE_NUMBER)" +
                        "VALUES( ? , ? , ? , ? , ? , ?, ?)" ;
    }


}
