package view;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.User;
import controller.LoginController;

public class BookListWindow extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		TableView<User> table = new TableView<User>();

		LoginController loginController = new LoginController();
		List<User> members = loginController.readLibraryMember();

		table.setItems(FXCollections.observableList(members));
		TableColumn<User, String> productNameCol = new TableColumn<>(
				String.format("Name"));
		productNameCol.setMinWidth(250);
		productNameCol
				.setCellValueFactory(new PropertyValueFactory<User, String>(
						"userId"));
		productNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		table.getColumns().addAll(productNameCol);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(table, 0, 1);
		Scene scene = new Scene(grid, 640, 480);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
