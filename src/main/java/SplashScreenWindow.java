import javax.swing.*;
import java.awt.*;

public class SplashScreenWindow extends JFrame implements Runnable{
    JPanel contentPane;
    JLabel imageLabel = new JLabel();
    String url;

    public SplashScreenWindow() {

    }

    @Override
    public void run() {
        try {
            url = "C:\\Users\\Devthorr\\Documents\\splashScreen.gif";
            ImageIcon imageIcon = new ImageIcon(url);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setUndecorated(true);
            setSize(new Dimension(imageIcon.getIconWidth(),imageIcon.getIconHeight()));
            imageLabel.setIcon(imageIcon);
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            this.setLocationRelativeTo(null);
            this.setAlwaysOnTop(true);
            this.setVisible(true);
            Timer timer = new Timer(1000, e -> {
                setVisible(false);
                dispose();
            });
            timer.start();

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}