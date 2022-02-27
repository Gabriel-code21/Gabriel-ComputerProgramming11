package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class Controller {

    public ListView<Reminder> listOfReminders;

    public TextField txtLoadFilename;
    public TextField txtSaveFilename;

    public TextField txtReminderName;
    public TextField txtReminderDate;

    public TextField txtPersonName;
    public TextField txtPersonAge;
    public TextField txtPersonOccupation;
    public TextField txtPersonBirthCountry;

    public TextField txtLocationAddress;
    public TextField txtLocationLatitude;
    public TextField txtLocationLongitude;
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

    Reminder tempReminder;

    public void loadFilename(ActionEvent actionEvent) throws IOException {
        System.out.println("ji");
//        FileReader fr = new FileReader((txtLoadFilename.getText()+".txt"));
//        BufferedReader br = new BufferedReader(fr);
//        listOfReminders.getItems().remove(0, listOfReminders.getItems().size());
//        String friend;
//        while((friend = br.readLine()) != null) {
//            String[] characteristics = friend.split("-@##@-"); // used to split words
//            listOfReminders.getItems().add(new Friend(characteristics[0], Integer.parseInt(characteristics[1]), characteristics[2], characteristics[3], characteristics[4]));
//        }
//        br.close();
    }

    public void saveFilename(ActionEvent actionEvent) throws IOException {
        System.out.println("ji");
//        if (!(listOfReminders.getItems().isEmpty())) {
//            FileWriter fw = new FileWriter((txtSaveFilename.getText()+".txt"));
//            BufferedWriter bw = new BufferedWriter(fw);
//            for (Friend f : listOfFriends.getItems()) {
//                bw.write((f.getName() + "-@##@-" + f.getAge() + "-@##@-" + f.getGender() + "-@##@-" + f.getOccupation() + "-@##@-" + f.getCountry()) + "\r");
//            }
//            bw.close();
//        }
    }
    public void createNewReminder(ActionEvent actionEvent) {
        btnCreateReminder.setDisable(true);

        txtReminderName.setDisable(false);
        txtReminderDate.setDisable(false);
        btnFinishReminder.setDisable(false);

        txtPersonName.setDisable(false);
        txtPersonAge.setDisable(false);
        txtPersonOccupation.setDisable(false);
        txtPersonBirthCountry.setDisable(false);
        btnAddPerson.setDisable(false);

        txtLocationAddress.setDisable(false);
        txtLocationLatitude.setDisable(false);
        txtLocationLongitude.setDisable(false);
        txtLocationZip.setDisable(false);
        btnAddLocation.setDisable(false);

        btnAddReminder.setDisable(false);

        tempReminder = new Reminder();
    }

    public void finishReminder(ActionEvent actionEvent) {
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

    public void addPersonToReminder(ActionEvent actionEvent) {
        Person p;
        if (!(txtPersonAge.getText().isEmpty() || txtPersonName.getText().isEmpty() || txtPersonOccupation.getText().isEmpty() || txtPersonBirthCountry.getText().isEmpty())) {
            p = new Person(txtPersonName.getText(), Integer.parseInt(txtPersonAge.getText()), txtPersonOccupation.getText(), txtPersonBirthCountry.getText());
            tempReminder.setPerson(p);

            txtPersonName.setDisable(true);
            txtPersonAge.setDisable(true);
            txtPersonOccupation.setDisable(true);
            txtPersonBirthCountry.setDisable(true);
            btnAddPerson.setDisable(true);

            lblReminderError.setText("Name: "+tempReminder.getPerson().getName()+"\nLocation: "+tempReminder.getPlace().getAddress());

        } else {
        lblPersonError.setText("Fill in all the fields.");
        }
    }

    public void addLocation(ActionEvent actionEvent) {
        Location l;
        if (!(txtLocationAddress.getText().isEmpty() ||txtLocationLatitude.getText().isEmpty() || txtLocationLongitude.getText().isEmpty() || txtLocationZip.getText().isEmpty())) {
            l = new Location(txtLocationAddress.getText(), Integer.parseInt(txtLocationLatitude.getText()), Integer.parseInt(txtLocationLongitude.getText()), txtLocationZip.getText());
            tempReminder.setPlace(l);
            txtLocationAddress.setDisable(true);
            txtLocationLatitude.setDisable(true);
            txtLocationLongitude.setDisable(true);
            txtLocationZip.setDisable(true);
            btnAddLocation.setDisable(true);

            lblReminderError.setText("Name: "+tempReminder.getPerson().getName()+"\nLocation: "+tempReminder.getPlace().getAddress());

        } else {
            lblLocationError.setText("Fill in all the fields.");
        }
    }

    public void addReminderToList(ActionEvent actionEvent) {
        if (btnFinishReminder.isDisabled() && btnAddPerson.isDisabled() && btnAddLocation.isDisabled()) {
            listOfReminders.getItems().add(tempReminder);
            btnCreateReminder.setDisable(true);
            btnAddReminder.setDisable(false);
        }
    }

    public void onItemSelected(MouseEvent mouseEvent) {
        if (listOfReminders.getSelectionModel().getSelectedItem() != null) {
            Reminder r = listOfReminders.getSelectionModel().getSelectedItem();
            reminderOutput.setText("What: "+r.getName()+"\nWhen: "+r.getDate());
            personOutput.setText("Name: "+r.getPerson().getName()+"\nAge: "+r.getPerson().getAge()+"\nOccupation: "+r.getPerson().getOccupation()+"\nBirth Country: "+r.getPerson().getCountryOfBirth());
            locationOutput.setText("Address: "+r.getPlace().getAddress()+"\nLatitude & Longitude: "+r.getPlace().getLatitude()+"° "+r.getPlace().getLongitude()+"°\nZip Code: "+r.getPlace().getZip());
        }
    }
}
