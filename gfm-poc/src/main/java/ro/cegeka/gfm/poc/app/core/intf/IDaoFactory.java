package ro.cegeka.gfm.poc.app.core.intf;

public interface IDaoFactory {
	
	IDao getInstance(String entityCode); 

}
