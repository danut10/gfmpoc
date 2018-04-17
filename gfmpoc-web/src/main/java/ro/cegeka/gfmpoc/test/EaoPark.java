package ro.cegeka.gfmpoc.test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.cegeka.gfmpoc.common.dataRecords.Park;

@Repository
public class EaoPark implements IEao<Park> {

	@Autowired
	private EsInfo esInfo;
	
	@Override
	public Park read(Integer id) throws IOException {
		//String esServer = "search-gfm-7blxtd3khouaolbdoki5ztd4ea.us-east-1.es.amazonaws.com";
		HttpHost esUrl = new HttpHost(esInfo.getHostname(), esInfo.getPort(), esInfo.getProtocol());
		RestClientBuilder restClientBuilder = RestClient.builder(esUrl);
		RestHighLevelClient esClient = new RestHighLevelClient(restClientBuilder);
		GetRequest getRequest = new GetRequest("park","doc", "1");   
		GetResponse getResponse = esClient.get(getRequest);
		String json = getResponse.getSourceAsString();
		Integer recordId = Integer.parseInt(getResponse.getId());
		esClient.close();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		ObjectMapper jsonMapper = new ObjectMapper().setDateFormat(dateFormat);	
		Park record = jsonMapper.readValue(json, Park.class);	
		record.setId(recordId);
		return record;
	} 
	
}
