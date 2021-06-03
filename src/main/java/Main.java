import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import org.jdesktop.swingx.JXFrame;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatDarkFlatIJTheme());
            FlatLightLaf.install();
            JXFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put( "Component.focusWidth", 0 );
            UIManager.put( "Component.innerFocusWidth", 0 );
            SwingUtilities.invokeAndWait(() -> new SplashScreenWindow().run());
            new Login().setLoginFrame();
        }catch(InvocationTargetException | InterruptedException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


    }
}