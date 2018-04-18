package ro.cegeka.gfmpoc.test;

import java.io.IOException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.cegeka.gfmpoc.common.core.impl.DataRecordID;

@Component
public class EsUtil {

	@Autowired private App app;
	
	
	public <T extends DataRecordID> T read(Class<T> clz, String index, Integer id) {
		try {
			GetRequest getRequest = new GetRequest(index, "doc", id.toString());   
			GetResponse getResponse;
			getResponse = app.esClient.get(getRequest);
			String json = getResponse.getSourceAsString();
			Integer recordId = Integer.parseInt(getResponse.getId());
			T record = app.jsonMapper.readValue(json, clz);	
			record.setId(recordId);
			return record;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
