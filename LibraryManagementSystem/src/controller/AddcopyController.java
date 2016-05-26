package controller;

import java.util.HashMap;

import model.Book;
import model.BookCopy;
import dataaccess.DataAccessFacade;

public class AddcopyController {
	
	private static DataAccessFacade da = new DataAccessFacade();
	
	public static void addCopy(Book b, int numCopies){
		
		HashMap<String,BookCopy> bookCopyHashMap=new HashMap<String,BookCopy>();
		bookCopyHashMap = da.readFromStorageBookCopy();
		
		for(int i=1; i<= numCopies; i++){
		
			bookCopyHashMap.put(b.getIsbn()+"_"+ i, new BookCopy(b,i)); 
			
		}
		
	    da.saveToStorageBookCopy(bookCopyHashMap);
		

					
	}


}
