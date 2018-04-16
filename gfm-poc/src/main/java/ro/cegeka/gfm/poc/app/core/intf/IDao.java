package ro.cegeka.gfm.poc.app.core.intf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import ro.cegeka.gfm.poc.common.core.impl.DataQuery;
import ro.cegeka.gfm.poc.common.core.intf.IDataRecord;


public interface IDao  {

	int readRecordCount(@Param("qry") DataQuery qry);
	List<IDataRecord> readList();
	List<IDataRecord> readList(@Param("qry") DataQuery qry);
	List<IDataRecord> readList(@Param("qry") DataQuery qry, RowBounds rb);

	void update(@Param("record") IDataRecord record);
	void create(@Param("record") IDataRecord record);

}
