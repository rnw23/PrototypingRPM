import DailyReport.DailyReport;
import RPM.Patient;
import UI.UI;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws Exception {

        Patient p = new Patient(1, "John Smith", 35);

        SwingUtilities.invokeLater(() -> {
            new UI().initialise();
        });

        for (int i = 0; i < 60; i++) { // e.g., 60 seconds for testing
            p.updateVitals();
            System.out.println(p.PatientDisplay());
            Thread.sleep(1000);
        }

        DailyReport report = new DailyReport(p);

        // --- Build filename: DailyReport_(Date)_(Patient name).xlsx ---
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String safeName = p.getName().trim().replaceAll("\\s+", "_").replaceAll("[^a-zA-Z0-9_\\-]", "");
        String filename = "DailyReport_" + date + "_" + safeName + ".xlsx";

        report.exportExcel(filename);

        System.out.println("Daily report generated successfully: " + filename);
    }
}