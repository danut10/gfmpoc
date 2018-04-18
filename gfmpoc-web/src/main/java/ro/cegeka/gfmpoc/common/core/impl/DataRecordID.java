package ro.cegeka.gfmpoc.common.core.impl;

import java.util.Date;

import ro.cegeka.gfmpoc.common.core.intf.IDataRecord;

public class DataRecordID implements IDataRecord {

	protected Integer id;
	protected Date lastUpdated; 
	
	/*
	 * getters & setters
	 */
	
	public Integer getId() { return this.id; }
	public DataRecordID setId(Integer id) { this.id = id; return this; }
	
	public Date getLastUpdated() { return lastUpdated; }
	public void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }
	
	public boolean isNew() { return (this.id == null); }

}
