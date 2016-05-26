package view;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AuthorizationLevel;
import model.User;

public class MainMenu extends Stage {
	private Scene scene;
	User loggedInUser;
	String userName;
	@FXML
	private Text welcomeText;

	public MainMenu(User loggedinUser) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

		setTitle("Library Management System");
		Text target = (Text) root.lookup("#welcomeText");
		target.setText("Welcome " + loggedinUser.getUserId() + "\n"
				+ loggedinUser.getUserRole());
		scene = new Scene(root, 640, 480);

		Button addMemberButton = (Button) root.lookup("#addMemberButton");
		Button addBookCopyButton = (Button) root.lookup("#addBookCopyButton");
		Button checkoutButton = (Button) root.lookup("#checkoutButton");
		Button listmemberButton = (Button) root.lookup("#listMemberButton");
		Button listbookButton = (Button) root.lookup("#listBookButton");
		

		List<AuthorizationLevel> permissionList = loggedinUser.getUserRole()
				.getRoleAuthorizationLevel();

		for (int a = 0; a < permissionList.size(); a++) {
			if (permissionList.get(a).equals(AuthorizationLevel.AddBookCopy)) {
				addBookCopyButton.setVisible(true);
			} else if (permissionList.get(a).equals(
					AuthorizationLevel.AddMember)) {
				addMemberButton.setVisible(true);
			} else if (permissionList.get(a).equals(
					AuthorizationLevel.CheckoutBook)) {
				checkoutButton.setVisible(true);
			//	listmemberButton.setVisible(true);
			//	listbookButton.setVisible(true);
				
			}

		}

		// Add CSS Style Sheet (located in same package as this class).
		String css = this.getClass().getResource("Style.css").toExternalForm();
		scene.getStylesheets().add(css);
		setScene(scene);
		setResizable(false);
		show();

	}

}
