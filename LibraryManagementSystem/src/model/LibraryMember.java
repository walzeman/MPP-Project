package model;

import java.io.Serializable;

final public class LibraryMember extends Person implements Serializable {
	
	String memberId;
	CheckoutRecord record; 
	
	public LibraryMember(String f, String l, String t, Address a, String memberId)
	{
		super(f, l, t, a);
		this.memberId = memberId;
		this.record = new CheckoutRecord();
	}

	public void checkout(BookCopy bc, String checkoutDate, String dueDate)
	{
		bc.changeAvailability();
		CheckoutRecordEntries entry = CheckoutRecordEntries.createEntry(bc, checkoutDate, dueDate);
		CheckoutRecord record = new CheckoutRecord();
		record.addEntry(entry);
		
	}
	
	public String getMemberId() {
		return memberId;
	}

	public String toString()
	{
		return "(" + this.getMemberId() + ", " + getFirstName() + " " + getLastName() + ", " + getTelephone() + ")	"; 
	}

	public void setRecord(CheckoutRecord record)
	{
		this.record = record;
	}
	
	public CheckoutRecord getRecord() {
		return record;
	}

	private static final long serialVersionUID = 7508481940058530471L;

}


