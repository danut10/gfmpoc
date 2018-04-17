package ro.cegeka.gfmpoc.app.core.intf;

public interface IDaoFactory {
	
	IDao getInstance(String entityCode); 

}
