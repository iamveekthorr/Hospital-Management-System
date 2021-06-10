import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class MainWindow extends JXFrame{
    int yPosition = this.getComponents().length;
    static Dimension ScreenSize =  Toolkit.getDefaultToolkit().getScreenSize();
    JXPanel topPanel, bottomPanel, containerPanel;

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
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

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
        JXPanel sectionPanel = new JXPanel();
        JXLabel patientInfoTitle = new JXLabel("Testing");
        JXButton addNewPatientBtn = new JXButton("New");
        sectionPanel.add(patientInfoTitle);
        sectionPanel.add(addNewPatientBtn);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(addNewPatientBtn, BorderLayout.EAST);
    }

    void addElementsToBottomPanels(){
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JXLabel("Testing"), BorderLayout.WEST);
        bottomPanel.add(new JXLabel("Testing"), BorderLayout.EAST);
    }
}
