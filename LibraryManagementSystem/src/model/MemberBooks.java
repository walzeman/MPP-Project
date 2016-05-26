package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
 
public class MemberBooks
{
    public SimpleStringProperty bookName = new SimpleStringProperty("<Name>"); 
    public SimpleStringProperty checkoutDate = new SimpleStringProperty();
    public SimpleStringProperty dueDate = new SimpleStringProperty();
 
    public MemberBooks(String bookName , String checkoutDate,String dueDate){
    	this.bookName=new SimpleStringProperty(bookName);
    	this.checkoutDate=new SimpleStringProperty(checkoutDate);
    	this.dueDate=new SimpleStringProperty(dueDate);
    }
    
    public String getBookName() {
        return bookName.get();
    }
 
    public String getCheckoutDate() {
        return checkoutDate.get();
    }
 
    public String getDueDate() {
        return dueDate.get();
    }
    
    public void setBookName(String name) {
        bookName.set(name);
    }
 
    public void setCheckoutDate(String date) {
        checkoutDate.set(date);
    }
 
    public void setDueDate(String date) {
        dueDate.set(date);
    }
}