import org.jdesktop.swingx.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Arrays;

public class MainWindow extends JXFrame{
    int yPosition = yPosition(super.rootPane);
    static Dimension ScreenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    JXPanel topPanel, bottomPanel, containerPanel;
    GridBagConstraints gridBagConstraints = new GridBagConstraints();


    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    MainWindow(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ScreenSize);
        this.setLocationRelativeTo(null);
        this.setTitle("Hospital Management System");
        this.setExtendedState(MAXIMIZED_BOTH);

        addMenubar();
        addMainPanels();
    }


    void addMenubar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu patientAdmission, patientHistory, takePatientBill, dischargePatient;
        patientAdmission = new JMenu("Patient Admission");
        patientHistory = new JMenu("Patient History");
        takePatientBill = new JMenu("Take Bill");
        dischargePatient = new JMenu("Discharge Patient");
        JMenu[] menuBarElements = {patientAdmission, patientHistory,
                takePatientBill, dischargePatient};

        Arrays.stream(menuBarElements).forEach(menuBar::add);
        this.setJMenuBar(menuBar);


    }

    void addMainPanels(){
        topPanel = new JXPanel();
        bottomPanel = new JXPanel();
        containerPanel = new JXPanel(new GridBagLayout());
        containerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        // Testing
        containerPanel.setPreferredSize(new Dimension((int) ScreenSize.getWidth(),
                (int) ScreenSize.getHeight()));
        topPanel.setBackground(Color.yellow);
        bottomPanel.setBackground(Color.GREEN);

        if (shouldFill) {
            //natural height, maximum width
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        }
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = yPosition++ ;
        gridBagConstraints.insets = new Insets(3,0,3,0);
        topPanel.setPreferredSize(new Dimension((int) ScreenSize.getWidth(), 250));
        topPanel.setBorder(new EmptyBorder(10, 10, 10,10));
        containerPanel.add(topPanel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = yPosition++;
        bottomPanel.setPreferredSize(new Dimension(500, 250));
        containerPanel.add(bottomPanel, gridBagConstraints);
        addElementsToTopPanels();
        addElementsToBottomPanels();

        this.add(containerPanel);
    }

    void addElementsToTopPanels(){
        Font font;
        topPanel.setLayout(new GridBagLayout());
        JXPanel topRightPanel = new JXPanel(), topLeftPanel;
        int innerYPosition = yPosition(topPanel);

        topRightPanel.setLayout(new GridBagLayout());
        topRightPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        // Sets inner panel to transparent
        topRightPanel.setBackground(new Color(0, 0, 0, 0));

        // Patient information label
        JXLabel patientInfoTitle = new JXLabel("PATIENT INFORMATION");
        patientInfoTitle.setBorder(new EmptyBorder(0, 0, 0, 50));
        font = patientInfoTitle.getFont();
        patientInfoTitle.setFont(font.deriveFont(font.getStyle() | Font.BOLD)); // Sets font to bold
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 2.0;   //request any extra horizontal space
        gridBagConstraints.anchor = GridBagConstraints.PAGE_START; //bottom of space
        gridBagConstraints.gridx = 0;

        gridBagConstraints.gridy = innerYPosition;
        topRightPanel.add(patientInfoTitle, gridBagConstraints);

        // Delete patient Button
        JXButton addNewPatientBtn  = new JXButton("New");
        addNewPatientBtn.setBorder(new EmptyBorder(3, 30, 3,30));
        gridBagConstraints.insets = new Insets(0, 10, 0 , 5);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = innerYPosition;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.weightx = 0.5;
        topRightPanel.add(addNewPatientBtn, gridBagConstraints);

        // Add new button
        JXButton deletePatient = new JXButton("Delete");
        deletePatient.setBorder(new EmptyBorder(3, 30, 3,30));
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = innerYPosition;
        gridBagConstraints.weightx = 0.5;
        topRightPanel.add(deletePatient, gridBagConstraints);

        JXLabel nameLabel = new JXLabel("Name");

        JXTextField nameTextField = new JXTextField();
        nameTextField.setPreferredSize(new Dimension(300, 50));

        JXPanel container, holder, sectionContainer;
        container = new JXPanel();
        holder = new JXPanel();
        sectionContainer = new JXPanel();
//        addTitleAndComboBox(nameLabel, nameTextField, "Name",container, holder,topRightPanel, sectionContainer);

        container = new JXPanel();
        holder = new JXPanel();
        sectionContainer = new JXPanel();
//        addTitleAndComboBox(nameLabel, nameTextField, "Color",container, holder, topRightPanel, sectionContainer);

        // Right side
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = yPosition;
        gridBagConstraints.weightx = 0.5;
        topPanel.add(topRightPanel, gridBagConstraints);



        // Left side
        topLeftPanel = new JXPanel();
        topLeftPanel.add(new JXLabel("TEsting"));
        topLeftPanel.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = yPosition;
        gridBagConstraints.weightx = 0.5;
        topPanel.add(topLeftPanel, gridBagConstraints);

    }

    void addElementsToBottomPanels(){
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JXLabel("Testing"), BorderLayout.WEST);
        bottomPanel.add(new JXLabel("Testing"), BorderLayout.EAST);
    }


    static int yPosition(JComponent component){
        return component.getComponents().length;
    }

    void addTitleAndComboBox(JXLabel fieldLabel, JXTextField textField, String fieldName,
                             JXPanel sectionPanelOne, JXPanel sectionPanelTwo,  JXPanel sectionHolderPanel, JXPanel topRightPanel){
        sectionHolderPanel.setLayout(new BorderLayout());
        sectionPanelOne.setLayout(new BorderLayout());
        sectionPanelTwo.setLayout(new BorderLayout());

        fieldLabel.setBorder(new EmptyBorder(0, 0, 0, 30));
        fieldLabel.setText(fieldName);

        // Adds components to sections
        sectionPanelTwo.add(fieldLabel, BorderLayout.WEST);
        sectionPanelTwo.add(textField, BorderLayout.EAST);

        sectionPanelOne.add(fieldLabel, BorderLayout.WEST);
        sectionPanelOne.add(textField, BorderLayout.EAST);

        // Adds sections to mani panel
        sectionHolderPanel.add(sectionPanelOne, BorderLayout.WEST);
        sectionHolderPanel.add(sectionPanelTwo, BorderLayout.EAST);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = yPosition(topRightPanel);
        topRightPanel.add(sectionHolderPanel, gridBagConstraints);
    }
}
