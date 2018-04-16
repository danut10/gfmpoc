package ro.cegeka.gfm.poc.common.dataRecords;

import java.util.Date;

import ro.cegeka.gfm.poc.common.core.impl.DataRecordID;

public class Offer extends DataRecordID {

	private String parkName;
	private String accommodation;
	private Date dtFrom;
	private Date dtTo;
	private Double price;
	
	public String getParkName() { return parkName; }
	public void setParkName(String parkName) { this.parkName = parkName; }
	
	public String getAccommodation() { return accommodation; }
	public void setAccommodation(String accommodation) { this.accommodation = accommodation; }
	
	public Date getDtFrom() { return dtFrom; }
	public void setDtFrom(Date dtFrom) { this.dtFrom = dtFrom; }
	
	public Date getDtTo() { return dtTo; }
	public void setDtTo(Date dtTo) { this.dtTo = dtTo; }
	
	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }
	
	
	

	


}

