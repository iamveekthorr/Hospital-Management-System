import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXTextField;

import javax.swing.*;

public class CheckFields extends SwingWorker<Boolean, Object> {
    JXTextField[] fields;
    JPasswordField passwordField, passwordConfirm;
    JXButton btnConfirm;
    JXFrame currentFame;

    CheckFields() {

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

//    CheckFields(JPasswordField passwordField, JXButton btn,
//                JXFrame currFrame, JXTextField... textAreas) {
//        this.currentFame = currFrame;
//        setFields(textAreas);
//        setPasswordField(passwordField);
//        setBtnConfirm(btn);
//    }

    CheckFields(JPasswordField passwordField, JPasswordField passwordConfirm, JXButton btn,
                JXFrame currFrame, JXTextField... textAreas) {
        this.currentFame = currFrame;
        setFields(textAreas);
        setPasswordField(passwordField);
        setBtnConfirm(btn);
        setPasswordConfirm(passwordConfirm);
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


    Boolean checkPassword() {
        for (JXTextField field : getFields()) {
                if (field.getText().equalsIgnoreCase(" ")) {
                    System.out.println(field.getText());
                    System.out.println(field);
                    JOptionPane.showMessageDialog(currentFame, "All fields are required.",
                            "Required fields",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println(true);
                    break;
                }
        }
        if(!String.valueOf(getPasswordField().getPassword())
                .equalsIgnoreCase(String.valueOf(getPasswordConfirm().getPassword())))
        {
            JOptionPane.showMessageDialog(currentFame, "Password Mismatch, please check to correct.",
                            "Password Mismatch",
                            JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }
}
