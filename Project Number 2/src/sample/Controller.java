package sample;

// Import for JavaFX
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

// Import for data persistence
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Controller {
    // All necessary fields
    public Label lblAmountOfReminders;
    public ListView<Reminder> listOfReminders;

    public TextField txtLoadFilename;
    public TextField txtSaveFilename;

    public TextField txtReminderName;
    public TextField txtReminderDate;

    public TextField txtPersonName;
    public TextField txtPersonOccupation;
    public TextField txtPersonBirthCountry;

    public TextField txtLocationAddress;
    public TextField txtLocationCity;
    public TextField txtLocationProvince;
    public TextField txtLocationZip;

    public Button btnLoad;
    public Button btnSave;
    public Button btnCreateReminder;
    public Button btnFinishReminder;
    public Button btnAddPerson;
    public Button btnAddLocation;
    public Button btnAddReminder;
    
    public Label lblReminderError;
    public Label lblPersonError;
    public Label lblLocationError;

    public Label reminderOutput;
    public Label personOutput;
    public Label locationOutput;

    public Button btnDeleteReminder;

    public Label lblAddReminderError;

    public Reminder tempReminder;


    // Load a file with Reminders in it and add the loaded Reminders to the listOfReminders
    /*
    -@##@- is used it to split the different parameters without encountering issues with the
    user inputting an enter or space character which would mess up the functionality */
    public void loadFilename(ActionEvent actionEvent) throws IOException {
        if (!(txtLoadFilename.getText().isEmpty())) {
            FileReader fr = new FileReader((txtLoadFilename.getText() + ".txt"));
            BufferedReader br = new BufferedReader(fr);
            listOfReminders.getItems().remove(0, listOfReminders.getItems().size());
            String reminder;
            while ((reminder = br.readLine()) != null) {
                String[] characteristics = reminder.split("-@##@-"); // used to split words
                listOfReminders.getItems().add(new Reminder(characteristics[0], characteristics[1], new Person(characteristics[2], characteristics[3], characteristics[4]), new Location(characteristics[5], characteristics[6], characteristics[7], characteristics[8])));
            }
            lblAmountOfReminders.setText("Total Reminders: "+listOfReminders.getItems().size());
            br.close();
        }
    }

    // Save all Reminders in listOfReminders to the given filename
    /*
    -@##@- is used it to split the different parameters without encountering issues with the
    user inputting an enter or space character which would mess up the load functionality */
    public void saveFilename(ActionEvent actionEvent) throws IOException {
        if (!(listOfReminders.getItems().isEmpty()) && !(txtSaveFilename.getText().isEmpty())) {
            FileWriter fw = new FileWriter((txtSaveFilename.getText()+".txt"));
            BufferedWriter bw = new BufferedWriter(fw);
            for (Reminder r : listOfReminders.getItems()) {
                bw.write((r.getName() + "-@##@-" + r.getDate() + "-@##@-" + r.getPerson().getName() + "-@##@-"+ r.getPerson().getOccupation()+ "-@##@-" + r.getPerson().getCountryOfBirth() + "-@##@-" + r.getLocation().getAddress() + "-@##@-" + r.getLocation().getCity() + "-@##@-" + r.getLocation().getProvince() + "-@##@-" + r.getLocation().getZipCode() + "\r"));
            }
            bw.close();
        }
    }

    // Allows for text fields and buttons to be interacted with. Initializes default Reminder object with the, tempReminder
    public void createNewReminder(ActionEvent actionEvent) {
        btnCreateReminder.setDisable(true);
        btnDeleteReminder.setDisable(true);

        txtReminderName.setDisable(false);
        txtReminderDate.setDisable(false);
        btnFinishReminder.setDisable(false);

        txtPersonName.setDisable(false);
        txtPersonOccupation.setDisable(false);
        txtPersonBirthCountry.setDisable(false);
        btnAddPerson.setDisable(false);

        txtLocationAddress.setDisable(false);
        txtLocationCity.setDisable(false);
        txtLocationProvince.setDisable(false);
        txtLocationZip.setDisable(false);
        btnAddLocation.setDisable(false);

        btnAddReminder.setDisable(false);

        btnLoad.setDisable(true);
        btnSave.setDisable(true);
        txtLoadFilename.setDisable(true);
        txtSaveFilename.setDisable(true);

        lblAddReminderError.setText("");

        tempReminder = new Reminder();
    }

    // Adds user input into tempReminder (Name and Date)
    public void completeReminder(ActionEvent actionEvent) {
        if (!(txtReminderName.getText().isEmpty() || txtReminderDate.getText().isEmpty())) {
            tempReminder.setName(txtReminderName.getText());
            tempReminder.setDate(txtReminderDate.getText());

            txtReminderName.setDisable(true);
            txtReminderDate.setDisable(true);
            btnFinishReminder.setDisable(true);

        } else {
            lblReminderError.setText("Fill in all the fields.");
        }
    }

    // Adds user input into the person field in tempReminder
    public void addPersonToReminder(ActionEvent actionEvent) {
        Person p;
        if (!(txtPersonName.getText().isEmpty())) { //|| txtPersonOccupation.getText().isEmpty() || txtPersonBirthCountry.getText().isEmpty())
            if (!(txtPersonOccupation.getText().isEmpty() && txtPersonBirthCountry.getText().isEmpty())) {
                p = new Person(txtPersonName.getText(), txtPersonOccupation.getText(), txtPersonBirthCountry.getText());
                tempReminder.setPerson(p);
            } else if (!(txtPersonOccupation.getText().isEmpty()) && txtPersonBirthCountry.getText().isEmpty()) {
                p = new Person(txtPersonName.getText(), true, txtPersonOccupation.getText());
                tempReminder.setPerson(p);
            } else if (txtPersonOccupation.getText().isEmpty() && !(txtPersonBirthCountry.getText().isEmpty())) {
                p = new Person(txtPersonName.getText(), false, txtPersonBirthCountry.getText());
                tempReminder.setPerson(p);
            } else {
                p = new Person(txtPersonName.getText());
                tempReminder.setPerson(p);
            }

            txtPersonName.setDisable(true);
            txtPersonOccupation.setDisable(true);
            txtPersonBirthCountry.setDisable(true);
            btnAddPerson.setDisable(true);

            lblReminderError.setText("Name: "+tempReminder.getPerson().getName()+"\nLocation: "+tempReminder.getLocation().getAddress());
            lblPersonError.setText("");

        } else {
        lblPersonError.setText("Fill in all the fields.");
        }
    }

    // Adds user input into the place field in tempReminder
    public void addLocationToReminder(ActionEvent actionEvent) {
        Location l;
        if (!(txtLocationAddress.getText().isEmpty() || txtLocationCity.getText().isEmpty() || txtLocationProvince.getText().isEmpty() || txtLocationZip.getText().isEmpty())) {
            l = new Location(txtLocationAddress.getText(), txtLocationCity.getText(), txtLocationProvince.getText(), txtLocationZip.getText());
            tempReminder.setLocation(l);
            txtLocationAddress.setDisable(true);
            txtLocationCity.setDisable(true);
            txtLocationProvince.setDisable(true);
            txtLocationZip.setDisable(true);
            btnAddLocation.setDisable(true);

            lblReminderError.setText("Name: "+tempReminder.getPerson().getName()+"\nLocation: "+tempReminder.getLocation().getAddress());
            lblLocationError.setText("");

        } else {
            lblLocationError.setText("Fill in all the fields.");
        }
    }

    // Add tempReminder to listOfReminders
    public void addReminderToList(ActionEvent actionEvent) {
        System.out.println(tempReminder.isEmpty());
//        if (btnFinishReminder.isDisabled() && btnAddPerson.isDisabled() && btnAddLocation.isDisabled()) {
        if (tempReminder.isEmpty().equals("Complete") && !(tempReminder.getName().equals("Not specified"))) {
            listOfReminders.getItems().add(tempReminder);
            lblAmountOfReminders.setText("Total Reminders: "+listOfReminders.getItems().size());

            btnAddReminder.setDisable(true);

            btnCreateReminder.setDisable(false);
            btnDeleteReminder.setDisable(false);

            btnLoad.setDisable(false);
            btnSave.setDisable(false);
            txtLoadFilename.setDisable(false);
            txtSaveFilename.setDisable(false);

            lblAddReminderError.setText("");
        }
        else {
            lblAddReminderError.setText("Complete all fields.");
        }
    }

    // Displays the reminder and its details when it is clicked on
    public void onItemSelected(MouseEvent mouseEvent) {
        if (listOfReminders.getSelectionModel().getSelectedItem() != null) {
            Reminder r = listOfReminders.getSelectionModel().getSelectedItem();
            reminderOutput.setText("What: "+r.getName()+"\nWhen: "+r.getDate());
            personOutput.setText("Name: "+r.getPerson().getName()+"\nOccupation: "+r.getPerson().getOccupation()+"\nBirth Country: "+r.getPerson().getCountryOfBirth());
            locationOutput.setText("Address: "+r.getLocation().getAddress()+"\nCity & Province: "+r.getLocation().getCity()+", "+r.getLocation().getProvince()+"\nZip Code: "+r.getLocation().getZipCode());
        }
    }

    // Removes/Deletes the selected reminder from the listOfsReminders
    public void deleteReminder(ActionEvent actionEvent) {
        if (listOfReminders.getSelectionModel().getSelectedItem() != null) {
            listOfReminders.getItems().remove(listOfReminders.getSelectionModel().getSelectedItem());
            lblAmountOfReminders.setText("Total Reminders: "+listOfReminders.getItems().size());
        }
    }

    public int amountOfReminders() {
        return listOfReminders.getItems().size();
    }
}
