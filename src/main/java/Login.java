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
    public static JXFrame FRAME;
    static JXPanel CONTAINER = new JXPanel(new BorderLayout());
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    JXPanel rightSide = new JXPanel(new GridBagLayout());
    int y = rightSide.getComponents().length;
    static int user_id;
    JXLabel windowTitle = new JXLabel();
    JXPanel leftSide = new JXPanel();
    JXButton signInBtn = new JXButton();
    JXButton signUpBtn = new JXButton();

    GridBagConstraints constraints = new GridBagConstraints();

    // Constructor
    Login() {

    }

    public static JXFrame getFRAME() {
        return FRAME;
    }

    public static int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        Login.user_id = user_id;
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
        rightSide.setBorder(new EmptyBorder(0, 30, 0, 30));

        if (RIGHT_TO_LEFT) {
            CONTAINER.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        if (shouldFill) {
            //natural height, maximum width
            constraints.fill = GridBagConstraints.HORIZONTAL;
        }
        constraints.insets = new Insets(3,0,3,0);
        constraints.ipady = 7;
        constraints.gridx = 0;
        constraints.gridy = 1;
        signInBtn.setText("SIGN IN");
        signInBtn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(signInBtn, constraints);

        if (RIGHT_TO_LEFT) {
            rightSide.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        signInBtn.addActionListener(e -> {
            //noinspection rawtypes
            SwingWorker swingWorker = new SwingWorker(){
                @Override
                protected Boolean doInBackground() {
                       rightSide.remove(signInBtn);
                       rightSide.remove(signUpBtn);
                       SwingUtilities.updateComponentTreeUI(CONTAINER);
                    return null;
                }

                @Override
                protected void done() {
                    signIn();
                    SwingUtilities.updateComponentTreeUI(CONTAINER);
                    super.done();
                }
            };
            swingWorker.execute();
        });

        signUpBtn.addActionListener(e -> {
            //noinspection rawtypes
            SwingWorker swingWorker = new SwingWorker(){
                @Override
                protected Boolean doInBackground() {
                    rightSide.remove(signInBtn);
                    rightSide.remove(signUpBtn);
                    SwingUtilities.updateComponentTreeUI(CONTAINER);
                    return null;
                }
                @Override
                protected void done() {
                    signUp();
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
        FRAME.add(CONTAINER, BorderLayout.SOUTH);
    }

    void addBottomSection(JXLabel label, JComponent component, JXPanel container,
                          String labelName){
        container.setLayout(new BorderLayout());

        // Add label
        label.setText(labelName);
        label.setBorder(new EmptyBorder(0, 0, 0, 30));
        container.add(label, BorderLayout.WEST);

        // Add textArea
        component.setPreferredSize(new Dimension(220, 22));
        container.add(component, BorderLayout.EAST);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 7;
        constraints.gridx = 0;
        constraints.gridy = y++;

        rightSide.add(container, constraints);
    }

    void signIn(){
        windowTitle.setText("Sign In");
        windowTitle.setFont(new Font(CONTAINER.getFont().getName(), Font.PLAIN, 24));
        windowTitle.setOpaque(true);
        rightSide.setOpaque(true);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = y++;
        rightSide.add(windowTitle, constraints);


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = y++;
        JXLabel subHeading = new JXLabel("<html> <p>Sign in to view patent records," +
                "please keep your login credentials confidential as loss of this information " +
                "may lead to serious data breach</p> </html>");
        rightSide.add(subHeading, constraints);


        JXButton logIn = new JXButton("Login");
        JXLabel label, label1;
        label = new JXLabel();
        label1 = new JXLabel();
        JXTextField textField;
        textField = new JXTextField();
        JPasswordField passwordField;
        passwordField= new JPasswordField();
        JXPanel sectionContainer1, sectionContainer;
        sectionContainer1 = new JXPanel();
        sectionContainer = new JXPanel();
        addBottomSection(label1, textField, sectionContainer1, "Phone");
        addBottomSection(label, passwordField, sectionContainer, "Password");

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = y;
        logIn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(logIn, constraints);
        logIn.addActionListener(e -> {
            String phoneNumberText = textField.getText().trim();
            String userPassword = String.valueOf(passwordField.getPassword()).trim();
            Boolean shouldWriteIntoDb = new CheckFields( passwordField, logIn, FRAME, textField)
                    .checkPassword("Sign In");
            if(!shouldWriteIntoDb) {
                DoctorController.getOneDoctor(phoneNumberText, userPassword);
                JOptionPane.showMessageDialog(FRAME, "Login successful please wait....",
                        "Successful Login",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });


    }

    void signUp(){
        windowTitle.setText("Sign Up");
        windowTitle.setFont(new Font(CONTAINER.getFont().getName(), Font.PLAIN, 24));
        windowTitle.setOpaque(true);
        rightSide.setOpaque(true);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = y++;
        rightSide.add(windowTitle, constraints);


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = y++;
        JXLabel subHeading = new JXLabel("<html> <p>Sign up to view patent records," +
                "please keep your login credentials confidential as loss of this information " +
                "may lead to serious data breach</p> </html>");
        rightSide.add(subHeading, constraints);


        JXButton submitBtn = new JXButton("Submit");
        JXLabel label;

        JXTextField nameTextField, ageField, phoneField,
                departmentField, roleField;
        nameTextField = new JXTextField();
        ageField = new JXTextField();
        phoneField = new JXTextField();
        departmentField = new JXTextField();
        roleField = new JXTextField();
        JPasswordField passwordField, passwordConfirmField;
        passwordConfirmField = new JPasswordField();
        passwordField= new JPasswordField();
        JXPanel sectionContainer;

        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, nameTextField, sectionContainer, "Name");
        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, ageField, sectionContainer, "Age");
        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, phoneField, sectionContainer, "Phone");
        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, departmentField, sectionContainer, "Department ");
        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, roleField, sectionContainer, "Role");
        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, passwordField, sectionContainer, "Password");
        sectionContainer = new JXPanel();
        label = new JXLabel();
        addBottomSection(label, passwordConfirmField, sectionContainer, "Confirm");

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = y++;
        submitBtn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(submitBtn, constraints);
        submitBtn.addActionListener(e -> {
            boolean shouldWriteIntoDB = new CheckFields(passwordConfirmField, passwordField, submitBtn,
                    FRAME, nameTextField, roleField, phoneField,
                    departmentField, ageField).checkPassword("Sign up");
            boolean user = DoctorController.getOneDoctor(phoneField.getText(),
                    String.valueOf(passwordField.getPassword())).isEmpty();
            if(!shouldWriteIntoDB) {
                if (!user){
                    JOptionPane.showMessageDialog(FRAME, "Invalid credentials for current user.",
                            "Failed registration",
                            JOptionPane.INFORMATION_MESSAGE);
                }else {
                    int nextScreen = DoctorController.createDoctor(nameTextField.getText().strip()
                            , roleField.getText().strip(),
                            phoneField.getText().trim(), ageField.getText().trim(),
                            departmentField.getText().strip(),
                            String.valueOf(passwordField.getPassword()), FRAME);
                    if (nextScreen != 0){
                        JOptionPane.showMessageDialog(FRAME, "Registration successful please wait....",
                                "Successful registration",
                                JOptionPane.INFORMATION_MESSAGE);
                        removeElements();
                        SwingUtilities.updateComponentTreeUI(rightSide);
                        swingWorkerUpdateUI();
                        setUser_id(nextScreen);
                    }
                }
            }
        });

    }

    void removeElements(){
        for(Component comp : rightSide.getComponents()){
            rightSide.remove(comp);
        }
    }

    void swingWorkerUpdateUI(){
        SwingWorker sw = new SwingWorker<>() {
            @Override
            protected Object doInBackground() throws Exception {
                SwingUtilities.updateComponentTreeUI(rightSide);
                return null;
            }
            @Override
            protected void done() {
                signIn();
                SwingUtilities.updateComponentTreeUI(rightSide);
                super.done();
            }
        };
        sw.execute();
    }
}
