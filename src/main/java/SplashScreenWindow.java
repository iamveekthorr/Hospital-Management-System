import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SplashScreenWindow extends JFrame {
    JPanel contentPane;
    JLabel imageLabel = new JLabel();

    public SplashScreenWindow(String url) {
        try {
            ImageIcon imageIcon = new ImageIcon(url);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setUndecorated(true);
            setSize(new Dimension(imageIcon.getIconWidth(),imageIcon.getIconHeight()));
            imageLabel.setIcon(imageIcon);
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            this.setLocationRelativeTo(null);
            addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent e)
                {
                    setVisible(false);
                    dispose();
                }
            });
            this.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}