package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class Controller {

    public ListView<Friend> listOfFriends = new ListView<>();
    public TextField txtName;
    public TextField txtAge;
    public TextField txtGender;
    public TextField txtOccupation;
    public Button btnSubmitCreation;
    public Button btnCreateFriend;
    public Button btnDeleteFriend;
    public Label lblErrorOccurred;

    public Label lblFriendInfo;
    public Label lblName;
    public Label lblAge;
    public Label lblGender;
    public Label lblOccupation;
    public Label lblCountry;
    public TextField txtCountry;

    public TextField txtLoadFileName;
    public Button btnLoadFriendsFromFile;
    public TextField txtSaveCurrentFriends;
    public Button btnSaveCurrentFriends;


    public void viewFriend(MouseEvent mouseEvent) {
//        System.out.println(listOfFriends.getItems().isEmpty());
        if (!(listOfFriends.getItems().isEmpty()) && !(listOfFriends.getSelectionModel().getSelectedItem() == null)) {
            btnDeleteFriend.setDisable(false);
//            btnCreateFriend.setDisable(true);
            lblFriendInfo.setText("Friend Information");
            Friend temp = listOfFriends.getSelectionModel().getSelectedItem();
            listOfFriends.getSelectionModel().getSelectedItem();
            lblName.setText("Name: "+temp.getName());
            lblAge.setText("Age: "+temp.getAge());
            lblGender.setText("Gender: "+temp.getGender());
            lblOccupation.setText("Occupation: "+temp.getOccupation());
            lblCountry.setText("Country of Residence: "+temp.getCountry());
        }
    }

    public void createFriend(ActionEvent actionEvent) {
        btnCreateFriend.setDisable(true);
        btnDeleteFriend.setDisable(true);

        txtName.setDisable(false);
        txtAge.setDisable(false);
        txtGender.setDisable(false);
        txtOccupation.setDisable(false);
        txtCountry.setDisable(false);
        btnSubmitCreation.setDisable(false);

        txtLoadFileName.setDisable(true);
        txtSaveCurrentFriends.setDisable(true);
        btnLoadFriendsFromFile.setDisable(true);
        btnSaveCurrentFriends.setDisable(true);
    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp = listOfFriends.getSelectionModel().getSelectedItem();
        listOfFriends.getItems().remove(listOfFriends.getSelectionModel().getSelectedItem());
        btnCreateFriend.setDisable(false);
    }

    public void addToList(ActionEvent actionEvent) {
        if (txtName.getText().isEmpty() || txtAge.getText().isEmpty() || txtGender.getText().isEmpty() || txtOccupation.getText().isEmpty() || txtCountry.getText().isEmpty()) {
            lblErrorOccurred.setText("Fill in all fields before submitting!");
        } else {
            btnCreateFriend.setDisable(false);
            txtName.setDisable(true);
            txtAge.setDisable(true);
            txtGender.setDisable(true);
            txtOccupation.setDisable(true);
            txtCountry.setDisable(true);
            btnSubmitCreation.setDisable(true);

            txtLoadFileName.setDisable(false);
            txtSaveCurrentFriends.setDisable(false);
            btnLoadFriendsFromFile.setDisable(false);
            btnSaveCurrentFriends.setDisable(false);

            listOfFriends.getItems().add(new Friend(txtName.getText(),Integer.parseInt(txtAge.getText()),txtGender.getText(),txtOccupation.getText(), txtCountry.getText()));
        }
    }

    // Load Friends From a File - the reason -@@- is used it because it is very unique and won't be used as part of the users input. This is better than a space or an enter.
    public void loadFriends(ActionEvent actionEvent) throws IOException {
        FileReader fr = new FileReader((txtLoadFileName.getText()+".txt"));
        BufferedReader br = new BufferedReader(fr);
        listOfFriends.getItems().remove(0, listOfFriends.getItems().size());
        String friend;
        while((friend = br.readLine()) != null) {
            String[] characteristics = friend.split("-@@-"); // used to split words
            listOfFriends.getItems().add(new Friend(characteristics[0], Integer.parseInt(characteristics[1]), characteristics[2], characteristics[3], characteristics[4]));
        }
        br.close();
    }

    // Save friends to a file - the reason -@@- is used it because it is very unique and won't be used as part of the users input. This is better than a space or an enter.
    public void saveFriendsToFile(ActionEvent actionEvent) throws IOException {
        if (!(listOfFriends.getItems().isEmpty())) {
            FileWriter fw = new FileWriter((txtSaveCurrentFriends.getText()+".txt"));
            BufferedWriter bw = new BufferedWriter(fw);
            for (Friend f : listOfFriends.getItems()) {
                bw.write((f.getName() + "-@@-" + f.getAge() + "-@@-" + f.getGender() + "-@@-" + f.getOccupation() + "-@@-" + f.getCountry()) + "\r");
            }
            bw.close();
        }
    }
}
