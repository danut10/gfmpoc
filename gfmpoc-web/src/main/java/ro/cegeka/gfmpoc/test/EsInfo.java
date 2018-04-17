package ro.cegeka.gfmpoc.test;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class EsInfo {

	private String hostname;
	private String protocol;
	private byte port;
	
	@PostConstruct
	private void init() {
		this.hostname = "search-gfm-7blxtd3khouaolbdoki5ztd4ea.us-east-1.es.amazonaws.com";
		this.protocol = "http";
		this.port = 80;
	}
	
	public String getHostname() { return hostname; }
	public void setHostname(String hostname) { this.hostname = hostname; }
	
	public String getProtocol() { return protocol; }
	public void setProtocol(String protocol) { this.protocol = protocol; }
	
	public byte getPort() { return port; }
	public void setPort(byte port) { this.port = port; }

}
