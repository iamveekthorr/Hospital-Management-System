import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXTextField;

import javax.swing.*;

public class CheckFields extends SwingWorker<Boolean, Object> {
    JXTextField[] fields;
    JPasswordField passwordField, passwordConfirm;
    JXButton btnConfirm;
    JXFrame currentFame;

    // Default Constructor
    CheckFields() {

    }

    // Constructor for sign up screen
    CheckFields(JPasswordField passwordField, JPasswordField passwordConfirm, JXButton btn,
                JXFrame currFrame, JXTextField... textAreas) {
        this.currentFame = currFrame;
        setFields(textAreas);
        setPasswordField(passwordField);
        setBtnConfirm(btn);
        setPasswordConfirm(passwordConfirm);
    }
    // Constructor for login screen
    CheckFields(JPasswordField passwordField, JXButton btn,
                JXFrame currFrame, JXTextField... textAreas) {
        this.currentFame = currFrame;
        setFields(textAreas);
        setPasswordField(passwordField);
        setBtnConfirm(btn);
    }

    public JPasswordField getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(JPasswordField passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JXButton getBtnConfirm() {
        return btnConfirm;
    }

    public void setBtnConfirm(JXButton btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    public JXTextField[] getFields() {
        return fields;
    }

    public void setFields(JXTextField[] fields) {
        this.fields = fields;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        return false;
    }

    @Override
    protected void done() {
        super.done();
    }


    public boolean checkPassword(String determinant) {
        // 1) Gets all fields as an array and check if they are empty
        JXTextField[] jxTextFields = getFields();
        for (JXTextField field : jxTextFields) {
            if (field.getText().trim().isBlank() || field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(currentFame, "All fields are required.",
                        "Required fields",
                        JOptionPane.WARNING_MESSAGE);
                field.requestFocusInWindow();
                return true;
            }
        }
        // Check is user is on the login screen
        if (determinant.equalsIgnoreCase("Sign up")) {
            if (String.valueOf(getPasswordField().getPassword()).trim().isEmpty() ||
                    String.valueOf(getPasswordField().getPassword()).trim().isBlank()
                    || String.valueOf(getPasswordConfirm().getPassword()).isEmpty() ||
                    String.valueOf(getPasswordConfirm().getPassword()).isBlank()) {
                JOptionPane.showMessageDialog(currentFame, "This Field is required",
                        "Empty Field",
                        JOptionPane.WARNING_MESSAGE);
                return true;
            }
            if (!String.valueOf(getPasswordField().getPassword()).trim()
                    .equalsIgnoreCase(String.valueOf(getPasswordConfirm().getPassword()).trim())) {
                JOptionPane.showMessageDialog(currentFame, "Password Mismatch, please check to correct.",
                        "Password Mismatch",
                        JOptionPane.WARNING_MESSAGE);
            } else return false;
            return true;
        } else { // If user is on the sign up screen
            if(String.valueOf(getPasswordField().getPassword()).trim().isEmpty()
                    || String.valueOf(getPasswordField().getPassword()).trim().isBlank()){
                JOptionPane.showMessageDialog(currentFame, "This Field is required",
                        "Empty Field",
                        JOptionPane.WARNING_MESSAGE);
                return true;
            }
        }

        return false;
    }
}
