package ro.cegeka.gfmpoc.test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class App {
	
	public RestHighLevelClient esClient;
	public ObjectMapper jsonMapper;
	
	@Autowired 
	private EsInfo esInfo;
	
	@PostConstruct
	public void init() {
		HttpHost esUrl = new HttpHost(esInfo.getHostname(), esInfo.getPort(), esInfo.getProtocol());
		RestClientBuilder restClientBuilder = RestClient.builder(esUrl);
		esClient = new RestHighLevelClient(restClientBuilder);
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		jsonMapper = new ObjectMapper().setDateFormat(dateFormat);	
		jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@PreDestroy
	public void close() {
		try {
			esClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

}
