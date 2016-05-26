package controller;

import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class MemberController {

	private static LibraryMember libmember;
	private static Address address;
	private static DataAccess da;
	
	public MemberController(){
		
	}
	
	public static void addMember(String fname, String lname, String phone, String id, String st, String city, String state, String zip){
	   
		address = new Address(st,city,state,zip);
		libmember = new LibraryMember(fname, lname, phone, address, id );
		da = new DataAccessFacade();
		
		List<LibraryMember> memlist = new ArrayList<LibraryMember>();
		
		memlist = da.readLibraryMember();

		memlist.add(libmember);
		 
		da.saveLibraryMember(memlist);
			
	}
	
}
