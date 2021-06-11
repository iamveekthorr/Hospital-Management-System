import org.jdesktop.swingx.JXFrame;
import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    static final String SALT = BCrypt.gensalt(12);

    static List<DoctorModel> getAllDoctors() {
        List<DoctorModel> doctors = null;
        ResultSet resultSet;
        try {
            resultSet = DoctorQueries.selectAllDoctors().executeQuery();
            doctors = new ArrayList<>();
            while (resultSet.next()) {
                doctors.add(new DoctorModel(
                        resultSet.getInt("DOCTOR_ID"),
                        resultSet.getString("AGE"),
                        resultSet.getString("PHONE_NUMBER"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("PASSWORD")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doctors;
    }

    static List<DoctorModel> getOneDoctor(String phoneNumber, String password) {
        List<DoctorModel> doctor = null;
        ResultSet resultSet;
        try {
            resultSet = DoctorQueries.selectOneDoctor(phoneNumber).executeQuery();
            doctor = new ArrayList<>();

            while (resultSet.next()) {
                boolean isAuthenticated = BCrypt.checkpw(password, resultSet.getString("PASSWORD"));
                if (isAuthenticated) {
                    doctor.add(new DoctorModel(
                            resultSet.getString("NAME"),
                            true
                    ));
                } else return doctor;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doctor;
    }

    static List<DoctorModel> getDoctorByPhoneNumber(String phoneNumber) {
        List<DoctorModel> doctor = null;
        ResultSet resultSet;
        try {
            resultSet = DoctorQueries.selectOneDoctor(phoneNumber).executeQuery();
            doctor = new ArrayList<>();

            while (resultSet.next()) {
                doctor.add(new DoctorModel(
                        resultSet.getString("NAME"),
                        true
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doctor;
    }


    static int createDoctor(String name, String role,
                            String phoneNumber, String age, String department, String password,
                            JXFrame currentFrame) {
        int result = 0;
        try {
            if (!name.matches("^[a-zA-Z]*$") || !role.matches("^[a-zA-Z]*$")
                    || !department.matches("^[a-zA-Z]*$")) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input field must contain just characters",
                        "Failed registration",
                        JOptionPane.ERROR_MESSAGE);
                return result;
            } else if (!age.matches("\\d+") || !phoneNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input field must contain just digits",
                        "Failed registration",
                        JOptionPane.ERROR_MESSAGE);
                return result;
            } else if (phoneNumber.length() != 11) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid Phone field must be equal to 11 digits",
                        "Failed registration",
                        JOptionPane.ERROR_MESSAGE);
                return result;
            } else if (!password.matches("[a-zA-Z0-9_.-]*$")) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input field must contain " +
                                "a sequence of characters and digits",
                        "Failed registration",
                        JOptionPane.ERROR_MESSAGE);
                return result;
            }
            String hashedPassword = BCrypt.hashpw(password, SALT);
            String insertStatement = DoctorQueries.insertIntoDoctorsTable();
            PreparedStatement addNewDoctor = CreateConnection.getConn().prepareStatement(insertStatement);
            addNewDoctor.setString(1, name);
            addNewDoctor.setString(2, role);
            addNewDoctor.setString(3, age);
            addNewDoctor.setString(4, department);
            addNewDoctor.setString(5, hashedPassword);
            addNewDoctor.setString(6, phoneNumber);
            result = addNewDoctor.executeUpdate();

            return result;


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
