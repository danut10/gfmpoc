package ro.cegeka.gfmpoc.app.core.intf;

import org.apache.ibatis.annotations.Param;

import ro.cegeka.gfmpoc.common.core.intf.IDataRecord;

public interface IDaoID extends IDao {

	IDataRecord read(@Param("id") Integer id);
	void delete(@Param("id") Integer id);
}
