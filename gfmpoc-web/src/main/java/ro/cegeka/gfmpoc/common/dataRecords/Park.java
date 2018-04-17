package ro.cegeka.gfmpoc.common.dataRecords;

import ro.cegeka.gfmpoc.common.core.impl.DataRecordID;

public class Park extends DataRecordID {

	private String name;
	private String city;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	
	
	
}
