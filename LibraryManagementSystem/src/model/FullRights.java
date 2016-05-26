package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullRights implements IRole, Serializable {

	private String userRole = "FullRights";

	@Override
	public List<AuthorizationLevel> getRoleAuthorizationLevel() {
		// TODO Auto-generated method stub
		List<AuthorizationLevel> authorizationLevels = Arrays
				.asList(AuthorizationLevel.values());

		return authorizationLevels;
	}

	@Override
	public String toString() {
		return "FullRights";
	}
}