package model;

import java.util.HashMap;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {

	public static void main(String[] args) {

		HashMap<String, User> users = new HashMap<String, User>();
		DataAccess da = new DataAccessFacade();

		User librarian = new User("yogesh", "yogesh", new Librarian());
		User administrator = new User("abrham", "abrham", new Administrator());
		User fullRights = new User("naveed", "naveed", new FullRights());

		users.put("yogesh", librarian);
		users.put("abrham", administrator);
		users.put("naveed", fullRights);

		da.addUser(users);


	}

}
