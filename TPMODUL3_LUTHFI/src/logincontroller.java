import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController<Stage> {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    public <usernameField> void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("password")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.getScene().setRoot(loader.load());
            } catch (Exception e) {
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Username or Password");
            alert.showAndWait();
        }
    }
}
