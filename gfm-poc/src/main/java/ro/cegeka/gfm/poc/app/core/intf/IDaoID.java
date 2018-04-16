package ro.cegeka.gfm.poc.app.core.intf;

import org.apache.ibatis.annotations.Param;

import ro.cegeka.gfm.poc.common.core.intf.IDataRecord;


public interface IDaoID extends IDao {

	IDataRecord read(@Param("id") Integer id);
	void delete(@Param("id") Integer id);
}
