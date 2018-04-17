package ro.cegeka.gfmpoc.common.dataRecords;

import ro.cegeka.gfmpoc.common.core.impl.DataRecordID;

public class AU extends DataRecordID {

	private String type;
	private String name;
	private Float price;
	private Park park;
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public Float getPrice() { return price; }
	public void setPrice(Float price) { this.price = price; }
	
	public Park getPark() { return park; }
	public void setPark(Park park) { this.park = park; }
	
	
}
