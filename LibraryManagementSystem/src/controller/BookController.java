package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Book;
import model.BookCopy;
import model.LibraryMember;
import dataaccess.DataAccessFacade;

public class BookController {

	public void checkoutBook(String membId, String ISBN) {

		DataAccessFacade daObj = new DataAccessFacade();
		boolean isAvailable = false;
		LibraryMember lm;
		
		try {
			 lm = daObj.searchMember(membId);
			 System.out.println("after searching member");
			if (lm == null) {
				JOptionPane.showMessageDialog(null, "No such Member exists:"
						+ membId);
				return;
			}

			Book book = daObj.searchBook(ISBN);

			if (book == null) {
				JOptionPane.showMessageDialog(null, "Book does not exist:"
						+ ISBN);
				return;
			}

			isAvailable = book.isAvailable();

			if (!isAvailable) {
				JOptionPane.showMessageDialog(null,
						"No copy available for Book:" + book.getTitle());
				return;
			}

			BookCopy bc = this.getNextAvailableCopy(book);
			int checkoutLength = book.getMaxCheckoutLength();
			System.out.println("System controller check out");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			String checkoutDate = sdf.format(c.getTime());
			c.add(Calendar.DATE, book.getMaxCheckoutLength()); // Adding 21 days
			String dueDate = sdf.format(c.getTime());

			lm.checkout(bc, checkoutDate, dueDate);

			daObj.saveMember(lm);

			daObj.saveBook(book);

			JOptionPane.showMessageDialog(null, "Book Checkout Successful!");
		}

		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Exception Occurred" + ex.getMessage());
		}

	}

	public boolean isAvailable(Book b) {
		return b.isAvailable();
	}

	public BookCopy getNextAvailableCopy(Book b) {
		return b.getNextAvailableCopy();
	}
}
