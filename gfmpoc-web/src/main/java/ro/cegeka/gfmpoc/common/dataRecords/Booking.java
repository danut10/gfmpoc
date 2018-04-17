package ro.cegeka.gfmpoc.common.dataRecords;

import java.util.Date;

import ro.cegeka.gfmpoc.common.core.impl.DataRecordID;

public class Booking extends DataRecordID {

	private Date from;
	private Date to;
	private String customer;
	private AU au;
	
	public Date getFrom() { return from; }
	public void setFrom(Date from) { this.from = from; }
	
	public Date getTo() { return to; }
	public void setTo(Date to) { this.to = to; }
	
	public String getCustomer() { return customer; }
	public void setCustomer(String customer) { this.customer = customer; }
	
	public AU getAu() { return au; }
	public void setAu(AU au) { this.au = au; }
	
	
}
