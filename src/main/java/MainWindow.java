import org.jdesktop.swingx.JXFrame;

public class MainWindow extends JXFrame{
    MainWindow(){
        this.setVisible(true);
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Hospital Management System");
    }


}
