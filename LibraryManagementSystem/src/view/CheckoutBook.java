package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import model.Book;
import model.MemberBooks;
import controller.BookController;
import dataaccess.DataAccessFacade;
 
public class CheckoutBook extends Stage{
	
	public CheckoutBook() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CheckoutBookNew.fxml"));
                setTitle("CHECK OUT A BOOK");
        setScene(new Scene(root, 500, 450));
        show();
        
        BookController bcObject=new BookController();
        Button btnCheckout = (Button)root.lookup("#btnCheckout");
        TextField txtMemId=(TextField)root.lookup("#txtMemberId");
        TextField txtISBN =(TextField)root.lookup("#txtISBN");
        
        btnCheckout.setOnAction(evt -> {
        	
           // System.out.println("Checkout button is done");
            
            try {
				if (txtISBN.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null,
							"ISBN cannot be blank");
					return;
				}

				if (txtMemId.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null,
							"Member ID cannot be blank");
					return;
				}
            }
            
            catch(Exception e1){
            	
            }
            
        	String ISBN=txtISBN.getText();
        	String membId=txtMemId.getText();
            bcObject.checkoutBook(membId, ISBN);
            TableView<Book> tview=(TableView)root.lookup("#tblCheckout");
            tview.setEditable(false);
            

    	/*	TableColumn<MemberBooks, String> bookname = new TableColumn<MemberBooks, String>("Book Name");
    		bookname.setMinWidth(100);
    		bookname.setCellValueFactory(new PropertyValueFactory<MemberBooks, String>("bookName"));
    		
    		TableColumn<MemberBooks, String> checkoutdate = new TableColumn<MemberBooks, String>("Checkout Date");
    		checkoutdate.setMinWidth(100);
    		checkoutdate.setCellValueFactory(new PropertyValueFactory<MemberBooks, String>("checkoutDate"));
    		
    		TableColumn<MemberBooks, String> duedate = new TableColumn<MemberBooks, String>("Due Date");
    		duedate.setMinWidth(100);
    		duedate.setCellValueFactory(new PropertyValueFactory<MemberBooks, String>("dueDate")); */
            
            TableColumn<Book, String> bookname = new TableColumn<Book, String>("Book Name");
    		bookname.setMinWidth(100);
    		bookname.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));

    		//tview.getColumns().add(bookname);
    		//tview.getColumns().add(checkoutdate);
    		//tview.getColumns().add(duedate);
    		
    		tview.getColumns().addAll(bookname);
    		Calendar ca=Calendar.getInstance();
    		Date date=new Date();
    		DataAccessFacade da=new DataAccessFacade();
    		Book b = da.readFromStorageBook().get(ISBN);
    		
    		List<Book> booklist=new ArrayList<Book>();
    		booklist.add(b);
    		
    			final ObservableList<MemberBooks> data =
    					FXCollections.observableArrayList(
    							new MemberBooks("The Big Fish",ca.getTime().toString(), date.toString()),
    				            new MemberBooks("Isabella", "Johnson", "isabella.johnson@example.com"),
    				            new MemberBooks("Ethan", "Williams", "ethan.williams@example.com"),
    				            new MemberBooks("Emma", "Jones", "emma.jones@example.com"),
    				            new MemberBooks("Michael", "Brown", "michael.brown@example.com")
    							);
    			tview.setItems(FXCollections.observableList(booklist));
    			//tview.setItems(data); 
    		 
    	
        
        });
	}
    
}
