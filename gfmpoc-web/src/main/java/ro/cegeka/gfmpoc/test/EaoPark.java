package ro.cegeka.gfmpoc.test;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.cegeka.gfmpoc.common.dataRecords.Park;

@Component
public class EaoPark implements IEao<Park> {

	//@Autowired private App app;
	@Autowired private EsUtil esUtil;
	
	
	@Override
	public Park read(Integer id) throws IOException {
		return esUtil.read(Park.class, "park", id);
		
		/*
		GetRequest getRequest = new GetRequest("park", "doc", id.toString());   
		GetResponse getResponse = app.esClient.get(getRequest);
		String json = getResponse.getSourceAsString();
		Integer recordId = Integer.parseInt(getResponse.getId());
		Park record = app.jsonMapper.readValue(json, Park.class);	
		record.setId(recordId);
		return record;
		*/
	} 
	
}
