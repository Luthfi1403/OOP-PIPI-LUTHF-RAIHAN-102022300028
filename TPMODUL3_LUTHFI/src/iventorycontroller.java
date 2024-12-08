public class iventorycontroller {
    Import javafx.collections.FXCollections;
    Import javafx.collections.ObservableList;
    Import javafx.fxml.FXML;
    Import javafx.scene.control.*;
    Import javafx.scene.input.MouseEvent;

    public iventorycontroller() {
    }
    
    public class InventoryController {
        @FXML
        private TableView<Album> tableView;
        @FXML
        private TextField albumNameField, artistField, totalField, availableField, rentedField;
        @FXML
        private Button addButton, deleteButton, updateButton, rentButton;
    
        private ObservableList<Album> albumList = FXCollections.observableArrayList();
    
        public void initialize() {
            // Kolom tabel
            TableColumn<Album, String> albumColumn = new TableColumn<>("Album Name");
            albumColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlbumName()));
    
            TableColumn<Album, String> artistColumn = new TableColumn<>("Artist");
            artistColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getArtist()));
    
            TableColumn<Album, Integer> totalColumn = new TableColumn<>("Total");
            totalColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTotal()).asObject());
    
            tableView.getColumns().addAll(albumColumn, artistColumn, totalColumn);
    
            tableView.setItems(albumList);
        }
    
        @FXML
        public void handleAdd() {
            try {
                String albumName = albumNameField.getText();
                String artist = artistField.getText();
                int total = Integer.parseInt(totalField.getText());
                albumList.add(new Album(albumName, artist, total, total, 0));
    
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Album added successfully!");
                alert.show();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input!");
                alert.show();
            }
        }
    
        @FXML
        public void handleDelete() {
            Album selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                albumList.remove(selected);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Album deleted successfully!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select an album!");
                alert.show();
            }
        }
    
        @FXML
        public void handleUpdate() {
            Album selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setAlbumName(albumNameField.getText());
                selected.setArtist(artistField.getText());
                selected.setTotal(Integer.parseInt(totalField.getText()));
    
                tableView.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Album updated successfully!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select an album!");
                alert.show();
            }
        }
    
        @FXML
        public void handleRent() {
            Album selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null && selected.getAvailable() > 0) {
                selected.setAvailable(selected.getAvailable() - 1);
                selected.setRented(selected.getRented() + 1);
    
                tableView.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Album rented successfully!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No available album to rent!");
                alert.show();
            }
        }
    }
    Import javax.swing.table.TableColumn;
Import javax.swing.text.TableView;


}
