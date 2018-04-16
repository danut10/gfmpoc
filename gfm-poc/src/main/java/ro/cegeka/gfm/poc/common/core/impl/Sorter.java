package ro.cegeka.gfm.poc.common.core.impl;


public class Sorter {
	public String sorterField;
	public String sorterDirection;
	
	public Sorter() { }
	
	public Sorter(String fieldName, String direction) {
		this.sorterField = fieldName;
		this.sorterDirection = direction;
	}
	
	public String getSorterField() { return sorterField; }
	public Sorter setSorterField(String fieldName) { this.sorterField = fieldName; return this; }

	public String getSorterDirection() { return sorterDirection; }
	public Sorter setSorterDirection(String direction) { this.sorterDirection = direction; return this; }
}

