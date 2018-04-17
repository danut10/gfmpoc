package ro.cegeka.gfmpoc.common.core.intf;


public interface IDataRecord extends IDataObject {
	
	default String getRecordTitle() { return null; }
	default String getRecordContent() { return null; }
}
