package ro.cegeka.gfmpoc.test;

import java.io.IOException;
import ro.cegeka.gfmpoc.common.core.impl.DataRecordID;

public interface IEao<T extends DataRecordID> { 
	T read(Integer id) throws IOException;
}
