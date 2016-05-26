package dataaccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Book;
import model.BookCopy;
import model.LibraryMember;
import model.User;


public class DataAccessFacade implements DataAccess {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	public static final String USER_LIST = "User_List";
	public static final String MEMBER_LIST = "userList";
	enum StorageType {
		BOOKS, MEMBERS, USERS;
	}
	public void addUser(HashMap<String, User> userMap) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, USER_LIST);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(userMap);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	public HashMap<String, User> getUserMap() {
		ObjectInputStream in = null;
		HashMap<String, User> userMap  = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, USER_LIST);
			in = new ObjectInputStream(Files.newInputStream(path));
			userMap = (HashMap<String, User>)  in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return userMap;
	}
	
	public LibraryMember searchMember(String membId) {

		// Searching if the LibraryMember exists


		//HashMap<String, LibraryMember> userMap = readMemberMap();
		HashMap<String, LibraryMember> userMap =readFromStorageLM();
		LibraryMember libmem = userMap.get(membId);
		return libmem;

	}

	public Book searchBook(String isbn) {
		HashMap<String, Book> booksMap = readFromStorageBook();
		Book b = booksMap.get(isbn);
		return b;
	}

	public HashMap<String, Book> readBooksMap() {
		return (HashMap<String, Book>) readFromStorage(StorageType.BOOKS);
	}

	public HashMap<String, User> readUserMap() {
		return (HashMap<String, User>) readFromStorage(StorageType.USERS);
	}

	public HashMap<String, LibraryMember> readMemberMap() {

		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
	}

	// Saving member checkout record after book checkout
	public void saveMember(LibraryMember member) {
		//HashMap<String, LibraryMember> members = readMemberMap();
		// members.get(member.getMemberId()).setRecord(member.getRecord());
		HashMap<String, LibraryMember> lmHashMap = new HashMap<String, LibraryMember>();
		//Set<String> keys = members.keySet();

		//saveToStorage(StorageType.MEMBERS, members);
		
		lmHashMap.put(member.getMemberId(), member);
		saveToStorageLM(lmHashMap);
	}

	// Saving book copy after book checkout
	public void saveBook(Book book) {
		HashMap<String, Book> books = readBooksMap();
		Set<String> keys = books.keySet();
		for (String val : keys) {
			if (val.equals(book.getIsbn())) {
				books.get(val).setCopies(book.getCopies());
			}
		}

		saveToStorage(StorageType.BOOKS, books);
	}

	// ///load methods - these place test data into the storage area
	// /// - used just once at startup
	// static void loadMemberMap(List<LibraryMember> memberList) {

	static void loadBookMap(List<Book> bookList) {
		HashMap<String, Book> books = new HashMap<String, Book>();
		// extract each book in the bookList, and add (ISBN, each bookItem) as
		// an entry in the HashMap
		bookList.forEach(book -> books.put(book.getIsbn(), book));
		saveToStorage(StorageType.BOOKS, books);
	}

	static void loadUserMap(List<User> userList) {
		HashMap<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getUserId(), user));
		saveToStorage(StorageType.USERS, users);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;

		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {

				}
			}
		}
	}

	public void saveToStorageLM(HashMap<String, LibraryMember> lm) {
		ObjectOutputStream out = null;

		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, "MEMBERS");
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(lm);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {

				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {

		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return retVal;
	}

	public HashMap<String,LibraryMember> readFromStorageLM(){
		ObjectInputStream in = null;
		HashMap<String,LibraryMember> lm = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					"MEMBERS");
			in = new ObjectInputStream(Files.newInputStream(path));
			lm =(HashMap<String,LibraryMember>) in.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return lm;
	}
	
	public void saveNewBook(Book book) {
		HashMap<String, Book> bookMap = readBooksMap();
		String isbn = book.getIsbn();
		bookMap.put(isbn, book);
		saveToStorage(StorageType.BOOKS, bookMap);
	}
	
	public void saveLibraryMember(List<LibraryMember> member) {
		ObjectOutputStream out = null;
		
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, MEMBER_LIST);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	public List<LibraryMember> readLibraryMember(){
		ObjectInputStream in = null;
		List<LibraryMember> member = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, MEMBER_LIST);
			in = new ObjectInputStream(Files.newInputStream(path));
			member = (List<LibraryMember>)in.readObject();
		} catch(Exception e) {
			//e.printStackTrace();
			return null;
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return member;
	}
	
	public void saveToStorageBook(HashMap<String, Book> book) {
		ObjectOutputStream out = null;

		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, "BOOKS");
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(book);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {

				}
			}
		}
	}
	
	public HashMap<String,Book> readFromStorageBook(){
		ObjectInputStream in = null;
		HashMap<String,Book> book = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,
					"BOOKS");
			in = new ObjectInputStream(Files.newInputStream(path));
			book =(HashMap<String,Book>) in.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return book;
	}
	@Override
	public void saveToStorageBookCopy(HashMap<String, BookCopy> bookCopy) {
			ObjectOutputStream out = null;

		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, "COPYS");
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(bookCopy);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {

				}
			}
		}
		
	}
	@Override
	public HashMap<String, BookCopy> readFromStorageBookCopy() {
		
		ObjectInputStream in = null;
		
		HashMap<String,BookCopy> bookCopy = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, "COPYS");
			in = new ObjectInputStream(Files.newInputStream(path));
			bookCopy =(HashMap<String,BookCopy>) in.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return bookCopy;
	
	}
	
}
