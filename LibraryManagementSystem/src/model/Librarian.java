package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Librarian implements IRole, Serializable {

	private String userRole = "Librarian";


	@Override
	public List<AuthorizationLevel> getRoleAuthorizationLevel() {
		// TODO Auto-generated method stub
		List<AuthorizationLevel> authorizationLevels = new ArrayList<AuthorizationLevel>();
		authorizationLevels.add(AuthorizationLevel.CheckoutBook);
		return authorizationLevels;
	}

	@Override
	public String toString() {
		return "Librarian";
	}

}
