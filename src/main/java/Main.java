import Alarm.AlarmLevel;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Patient p = new Patient(1,"John Smith", 35);

        SwingUtilities.invokeLater(() -> {
            new UI().initialise();
        });

        while (true) {
            p.updateVitals();
            System.out.println(p.PatientDisplay());
            Thread.sleep(1000);
        }


    }
}