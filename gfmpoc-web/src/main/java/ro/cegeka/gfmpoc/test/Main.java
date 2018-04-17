package ro.cegeka.gfmpoc.test;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.cegeka.gfmpoc.common.dataRecords.Park;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		String ctxFile = "conf/applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(ctxFile);
		EaoPark eao = ctx.getBean(EaoPark.class);
		Park park = eao.read(1);
		((ClassPathXmlApplicationContext) ctx).close();
	}
	
	@SuppressWarnings("unused")
	private void esTest() throws IOException {
		String esServer = "search-gfm-7blxtd3khouaolbdoki5ztd4ea.us-east-1.es.amazonaws.com";
		HttpHost esUrl = new HttpHost(esServer, 80, "http");

		//RestClient restClient = RestClient.builder(esUrl).build();
		//restClient.close();
		
		RestClientBuilder restClientBuilder = RestClient.builder(esUrl);
		RestHighLevelClient esClient = new RestHighLevelClient(restClientBuilder);
		
		//CreateIndexRequest request = new CreateIndexRequest("park");
		//CreateIndexResponse createIndexResponse = esClient.indices().create(request);
		
		/*
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("name", "Haven Essex 12");
		jsonMap.put("city", "Colchester 12");
		IndexRequest indexRequest = new IndexRequest("park", "doc", "1").source(jsonMap);
		IndexResponse indexResponse = esClient.index(indexRequest);
		*/
		
		GetRequest getRequest = new GetRequest("park","doc", "1");   
		GetResponse getResponse = esClient.get(getRequest);
		//String responseString = getResponse.getSourceAsString();
		//Map<String, Object> responseMap = getResponse.getSourceAsMap();
		//DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		//ObjectMapper jsonMapper = new ObjectMapper().setDateFormat(dateFormat);	
		//filter = (IDataFilter) jsonMapper.readValue(json, cls);
		
				
		esClient.close();
				
	}

}
