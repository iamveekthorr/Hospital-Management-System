import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import org.jdesktop.swingx.JXFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            JXFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new FlatDarkFlatIJTheme());
            FlatSolarizedLightIJTheme.install();
            UIManager.put( "Component.focusWidth", 0 );
            UIManager.put( "Component.innerFocusWidth", 0 );
            UIManager.put( "Button.arc", 0 );
            SwingUtilities.invokeLater(CreateConnection::new);
            SwingUtilities.invokeLater(new SplashScreenWindow());
            SwingUtilities.invokeLater(() -> new Login().setLoginFrame());
        }catch( UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


    }
}
