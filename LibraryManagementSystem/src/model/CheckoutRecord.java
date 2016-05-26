package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {
	
	List<CheckoutRecordEntries> recordentry;
	
	public CheckoutRecord()
	{
		recordentry = new ArrayList<>();
	}
	
	public void setRecord(CheckoutRecordEntries record) {
		recordentry.add(record);
	}

	public List<CheckoutRecordEntries> getRecord() {
		return recordentry;
	}

	public void addEntry(CheckoutRecordEntries record)
	{
		setRecord(record);
	}

}

