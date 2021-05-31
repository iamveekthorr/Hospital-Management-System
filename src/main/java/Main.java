import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                String url = "C:\\Users\\Devthorr\\Documents\\splashScreen.gif";
                SplashScreenWindow splash  = new SplashScreenWindow(url);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
        SwingUtilities.invokeLater(CreateConnection::new);
    }
}
