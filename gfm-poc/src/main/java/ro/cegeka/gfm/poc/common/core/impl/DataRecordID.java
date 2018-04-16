package ro.cegeka.gfm.poc.common.core.impl;

import ro.cegeka.gfm.poc.common.core.intf.IDataRecord;

public class DataRecordID implements IDataRecord {

	protected Integer id;

	public Integer getId() { return this.id; }
	public DataRecordID setId(Integer id) { this.id = id; return this; }
	
	public boolean isNew() { return (this.id == null); }

}
