import org.jdesktop.swingx.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login {
    public final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static JXFrame FRAME;
    static JXPanel CONTAINER = new JXPanel(new BorderLayout());

    // Constructor
    Login() {

    }

    public static JXFrame getFRAME() {
        return FRAME;
    }

    void setLoginFrame() {
        FRAME = new JXFrame("Welcome");
        FRAME.setDefaultCloseOperation(EXIT_ON_CLOSE);
        FRAME.setSize(700, 500);
        FRAME.setLocationRelativeTo(null);
        FRAME.setResizable(false);
        FRAME.setDefaultCloseOperation(EXIT_ON_CLOSE);
        FRAME.setVisible(true);
        FRAME.setAutoRequestFocus(true);


        addComponents();
        FRAME.validate();
    }

    void addComponents() {
        CONTAINER.setPreferredSize(FRAME.getSize());
        JXPanel leftSide = new JXPanel();
        JXButton signInBtn = new JXButton();
        JXButton signUpBtn = new JXButton();

        JXLabel labelName = new JXLabel();
        JTextField id = new JXTextField();

        GridBagConstraints constraints = new GridBagConstraints();

        JXPanel rightSide = new JXPanel(new GridBagLayout());
        rightSide.setBorder(new EmptyBorder(0, 20, 0, 10));
        JXLabel windowTitle = new JXLabel();
        windowTitle.setText("Sign In");


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(3,0,3,0);
        constraints.ipady = 7;
        constraints.gridx = 0;
        constraints.gridy = 1;
        signInBtn.setText("SIGN IN");
        signInBtn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(signInBtn, constraints);

        signInBtn.addActionListener(e -> {
//            new SignInAndSignUP().signIn();

            SwingWorker swingWorker = new SwingWorker() {
                @Override
                protected Object doInBackground() {
                       rightSide.remove(signInBtn);
                       rightSide.remove(signUpBtn);
                       SwingUtilities.updateComponentTreeUI(CONTAINER);
                    return null;
                }

                @Override
                protected void done() {
                    rightSide.add(new JXLabel("SIGN IN"));
                    SwingUtilities.updateComponentTreeUI(CONTAINER);
                    super.done();
                }
            };
            swingWorker.execute();
        });



        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 7;
        constraints.gridy = 2;
        constraints.gridx = 0;
        signUpBtn.setText("SIGN UP");
        signUpBtn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(signUpBtn, constraints);


        leftSide.setPreferredSize(new Dimension(350, 500));
        rightSide.setPreferredSize(new Dimension(350, 500));

        String url = "C:\\Users\\Devthorr\\Documents\\leftIMG.png";

        try {
            BufferedImage imageIcon = ImageIO.read(new File(url));
            JXLabel label = new JXLabel(new ImageIcon(imageIcon));
            JXLabel hello = new JXLabel("Hello word");
            hello.setBackground(Color.yellow);
            leftSide.add(hello);
            leftSide.add(label);
        }catch(IOException ex){
            ex.printStackTrace();
        }

        CONTAINER.add(leftSide, BorderLayout.LINE_START);
        CONTAINER.add(rightSide, BorderLayout.LINE_END);
        CONTAINER.setBackground(Color.BLUE);
        FRAME.add(CONTAINER, BorderLayout.SOUTH);
    }


}
