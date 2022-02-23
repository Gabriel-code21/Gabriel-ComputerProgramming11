package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
        listOfFriends.getItems().add(new Friend(txtName.getText(),Integer.parseInt(txtAge.getText()),txtGender.getText(),txtOccupation.getText(), txtCountry.getText()));
        }
    }

}
