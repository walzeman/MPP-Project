package dataaccess;

import java.util.HashMap;
import java.util.List;

import model.Book;
import model.BookCopy;
import model.LibraryMember;
import model.User;

	public interface DataAccess {
		public void addUser(HashMap<String, User> userMap);
		public HashMap<String, User> getUserMap();
		//public LibraryMember searchMember(String memberId);
		public Book searchBook(String isbn);
			
		///////save methods
		//public void saveNewMember(LibraryMember member);
		//public void updateMember(LibraryMember member);
		
		//save new book
		public void saveNewBook(Book book);
		
		//////read methods 
		public HashMap<String,Book> readBooksMap();
		public HashMap<String,User> readUserMap();
		public HashMap<String, LibraryMember> readMemberMap();
		
		
		public LibraryMember searchMember(String memberId);
		
		//Saving Member
		public void saveMember(LibraryMember member);
		
		//Saving Book
		public void saveBook(Book book);

		
		
		//Get Member Record Entries
//		public List<ArrayList<MemberBooks>> populateTable(LibraryMember member);
		//public List<MemberBooks> populateTable(LibraryMember member);
		public void saveLibraryMember(List<LibraryMember> member);
		public List<LibraryMember> readLibraryMember();
		
		public void saveToStorageBookCopy(HashMap<String, BookCopy> bookCopy);
		public HashMap<String,BookCopy> readFromStorageBookCopy();
	}

