import com.sirma.cli.UserInterface;
import com.sirma.fileio.CsvReader;
import com.sirma.fileio.CsvWriter;
import com.sirma.manager.*;

public class StaffManagementApp {
    public static void main(String[] args) {
        CsvReader reader = new CsvReader();
        CsvWriter writer = new CsvWriter();
        UserInterface ui = new UserInterface();
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        ui.displayCommands();
        boolean isRunning = true;
        while (isRunning) {
            int command = ui.start();
            if (command == 0) {
                isRunning = false;
            }
            manager.execute(command);

// Add Employee
// 1, Peter Peterson, IT, Junior Java Developer, 1400.50
// Add Employee
// 2, Ivan Ivanson, IT, Junior Front-End Developer, 1400.00
// Edit 1
// 1, Peter Peterson, IT, Java Developer, 2500.00
// List employees
// Search Department Marketing
// Search Id 1
// Fire 1
// Search Name Peter
// Save &amp; Exit
        }
}

    }