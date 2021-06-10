import org.jdesktop.swingx.*;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login {
    public static JXFrame FRAME;
    static JXPanel CONTAINER = new JXPanel(new BorderLayout());
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    JXPanel rightSide = new JXPanel(new GridBagLayout());
    // sets the y value for every component on the right JPanel
    int y = rightSide.getComponents().length;
    static int user_id;
    static List<DoctorModel> currentUser;
    JXLabel windowTitle = new JXLabel();
    JXPanel leftSide = new JXPanel();
    JXButton signInBtn = new JXButton();
    JXButton signUpBtn = new JXButton();

    GridBagConstraints constraints = new GridBagConstraints();

    // Constructor
    Login() {

    }
    public static List<DoctorModel> getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(List<DoctorModel> currentUser) {
        Login.currentUser = currentUser;
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
    /**
     * @return null
     * sets login frame and as var FRAME,
     * calls the add components method
     * */
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
    /**
     * @return null,
     * Adds components to setLoginFrame() method,
     * */
    void addComponents() {
        // 1) sets container size for JPanel
        CONTAINER.setPreferredSize(FRAME.getSize());
        // 2) sets padding to JPanel on the right side.
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
        constraints.gridy = y++;
        signInBtn.setText("SIGN IN");
        signInBtn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(signInBtn, constraints); //adds sign in

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
        constraints.gridy = y++;
        constraints.gridx = 0;
        signUpBtn.setText("SIGN UP");
        signUpBtn.setBorder(new EmptyBorder(5, 100, 5, 100));
        rightSide.add(signUpBtn, constraints); // add sign up button to right side

        // Sets size for both JPanels in FRAME
        leftSide.setPreferredSize(new Dimension(350, 500));
        rightSide.setPreferredSize(new Dimension(350, 500));

        // Path to image on the left side
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
        // Adds JPanels to JFrame
        CONTAINER.add(leftSide, BorderLayout.LINE_START);
        CONTAINER.add(rightSide, BorderLayout.LINE_END);
        FRAME.add(CONTAINER, BorderLayout.SOUTH);
    }

    void addBottomSection(@NotNull JXLabel label, JComponent component, JXPanel container,
                          String labelName){
        container.setLayout(new BorderLayout()); // Set layout for section container

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

        rightSide.add(container, constraints); // Adds section container to right JPanel
    }

    /**
     * @return null
     * Sign in view
     * */
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
            boolean shouldWriteIntoDb = new CheckFields( passwordField, logIn, FRAME, textField)
                    .checkPassword("Sign In");
            List<DoctorModel> user = DoctorController.getOneDoctor(phoneNumberText,
                    userPassword);
            if(!shouldWriteIntoDb) {
                System.out.println(user);
                if(user.isEmpty()) {
                    JOptionPane.showMessageDialog(FRAME, "User not found..",
                        "Invalid user credentials",
                        JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                setCurrentUser(user);
                JOptionPane.showMessageDialog(FRAME, "Login successful please wait....",
                        "Successful Login",
                        JOptionPane.INFORMATION_MESSAGE);
                FRAME.dispose();
                new MainWindow();
            }
        });

    }

    /**
     * @return null,
     * Sign up View
     * */
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

        // Adds sections to the Right JPanel
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
        rightSide.add(submitBtn, constraints); // Adds submit button to the JPanel in the signUp page
        submitBtn.addActionListener(e -> {
            boolean shouldWriteIntoDB = new CheckFields(passwordConfirmField, passwordField, submitBtn,
                    FRAME, nameTextField, roleField, phoneField,
                    departmentField, ageField).checkPassword("Sign up");
            List<DoctorModel> user = DoctorController.getOneDoctor(phoneField.getText(),
                    String.valueOf(passwordField.getPassword()));
            if(!shouldWriteIntoDB) {
                // Checks if user already exists in the database
                if (!user.isEmpty()){
                    JOptionPane.showMessageDialog(FRAME, "Invalid credentials for current user," +
                                    " phone number is already in use.",
                            "Failed registration",
                            JOptionPane.INFORMATION_MESSAGE);
                }else {
                    // If no user exists direct the existing user to sign in using their
                    // just entered credentials (Phone Number and Password)
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
                        setUser_id(nextScreen); // Sets current to the variable user_id
                    }
                }
            }
        });

    }
    // Removes all Elements form the JPanel
    void removeElements(){
        for(Component comp : rightSide.getComponents()){
            rightSide.remove(comp);
        }
    }

    // Use SwingWorker to update the UI
    void swingWorkerUpdateUI(){
        //noinspection rawtypes
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
        sw.execute(); // Executes the Swing Worker
    }
}
