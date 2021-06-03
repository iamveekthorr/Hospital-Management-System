import org.jdesktop.swingx.JXFrame;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SignInAndSignUP {


    void signIn(){
        Login.getFRAME().dispose();
        JXFrame signInFrame = new  JXFrame();
        signInFrame.setVisible(true);
        signInFrame.setSize(700, 500);
        signInFrame.setLocationRelativeTo(null);
        signInFrame.setResizable(false);
        signInFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        signInFrame.setVisible(true);
        signInFrame.setAutoRequestFocus(true);


    }

}
