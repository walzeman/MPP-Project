package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Administrator implements IRole, Serializable{

	private String userRole = "Administrator";
	@Override
	public List<AuthorizationLevel> getRoleAuthorizationLevel() {
		// TODO Auto-generated method stub
		List<AuthorizationLevel> authorizationLevels = new ArrayList<AuthorizationLevel>();
		authorizationLevels.add(AuthorizationLevel.AddBookCopy);
		authorizationLevels.add(AuthorizationLevel.AddMember);
		return authorizationLevels;
		
	}
	@Override
	public String toString() {
		return "Administrator";
	}

}
