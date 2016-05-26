package model;

import dataaccess.DataAccessFacade;
//import project.Model.LibraryMember;
//import project.View.CheckoutBook;

public class Test {

	public static void main(String[] args) {
  //      Application.launch(CheckoutBook.class, args);
     //   System.out.println("Main method done");
        
        Address add=new Address("1000 N 4th St","Fairfield","Iowa","52557");
        Address add1=new Address("1001 N 4th St","Fairfield","Iowa","52558");
      // LibraryMember lm=new LibraryMember("Yogesh","goyal","999999999",add,"500");
     //   LibraryMember lm1=new LibraryMember("Naveed","M","999999999",add1,"501");
        
        DataAccessFacade da = new DataAccessFacade();
		//da.saveMember(lm);
		//da.saveMember(lm1);
	//	HashMap<String,LibraryMember> lmHashMap=new HashMap<String,LibraryMember>();
	//	lmHashMap.put(lm.getMemberId(), lm);
	//	lmHashMap.put(lm1.getMemberId(), lm1);
	//	da.saveToStorageLM(lmHashMap);
		//System.out.println("Reading record for 501:\n"+"  "+da.searchMember("501"));
	//	System.out.println(da.readFromStorageLM().values());
		
		
/*
		List<Address> addresses = new ArrayList<Address>() {
			{
				add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
				add(new Address("51 S. George", "Georgetown", "MI", "65434"));
				add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
				add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
				add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
				add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
				add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
				add(new Address("501 Central", "Mountain View", "CA", "94707"));
			}
		};
		@SuppressWarnings("serial")
		 List<Author> allAuthors = new ArrayList<Author>() {
			{
				add(new Author("Joe", "Thomas", "641-445-2123", addresses.get(0), "A happy man is he."));
				add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
				add(new Author("Nirmal", "Pugh", "641-919-3223", addresses.get(1), "Thinker of thoughts."));
				add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
				add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
			}
		};
		
		
		//Book(int id, String isbn, String title, int maxCheckoutLength, List<Author> authors)
		@SuppressWarnings("serial")
		List<Book> allBooks = new ArrayList<Book>(){
			{
		
				add(new Book("23-11451", "The Big Fish", 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
				add(new Book("28-12331", "Antartica", 7, Arrays.asList(allAuthors.get(2))));
				add(new Book("99-22223", " Java SE 8", 14, Arrays.asList(allAuthors.get(3))));
				add(new Book("48-56882", "Jimmy's First Day of School", 4, Arrays.asList(allAuthors.get(4))));
				
			}
		};
		
		HashMap<String,Book> bookHashMap=new HashMap<String,Book>();
		bookHashMap.put(allBooks.get(0).getIsbn(), allBooks.get(0));
		bookHashMap.put(allBooks.get(1).getIsbn(), allBooks.get(1));
		bookHashMap.put(allBooks.get(2).getIsbn(), allBooks.get(2));
		bookHashMap.put(allBooks.get(3).getIsbn(), allBooks.get(3));
*/		
	//	da.saveToStorageBook(bookHashMap);
		
	    System.out.println(da.readFromStorageBook());
		
	//	System.out.println(da.readFromStorageBookCopy());
		//System.out.println(" size = "+da.readFromStorageBookCopy().size());
		
	//	Book b1=da.searchBook("28-12331");
	//	System.out.println(b1.getTitle());
    }
}
