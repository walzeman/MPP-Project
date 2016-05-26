package model;

import java.io.Serializable;
import java.util.Date;

public class CheckoutRecordEntries implements Serializable {
	
	BookCopy copy;
	String checkoutDate;
	String dueDate;
	
	CheckoutRecordEntries(BookCopy copy, String checkoutDate, String dueDate)
	{
		this.copy = copy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	
	public static CheckoutRecordEntries createEntry(BookCopy bc, String checkoutDate, String dueDate)
	{
		return new CheckoutRecordEntries(bc,checkoutDate,dueDate);
	}

	public BookCopy getCopy() {
		return copy;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public String getDueDate() {
		return dueDate;
	}
	
}
