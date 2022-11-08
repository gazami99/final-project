package gongo.gongo.config;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class DatasourceConfiguration {
	
    @Value("${spring.datasource.primary.endpoint}")
    private String rdsHost;
    
    @Value("${spring.datasource.primary.rds-url}")
    private String rdsUrl;
    
    @Value("${spring.datasource.primary.rds-password}")
    private String rdsPw;
    
    @Value("${spring.datasource.primary.rds-username}")
    private String rdsName;
    
    @Value("${spring.datasource.secondary.url}")
    private String url;
    
    @Value("${spring.datasource.secondary.username}")
    private String Name;
    
    @Value("${spring.datasource.secondary.password}")
    private String Pw;
    

	
	@Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties getPrimaryDataSource() { 
		
        DataSourceProperties sourceProperty = new DataSourceProperties();
        sourceProperty.setUrl(rdsUrl);
        sourceProperty.setUsername(rdsName);
        sourceProperty.setPassword(rdsPw);


		try {
			
			System.out.println("Checking Primary Network socket");
			
	    	InetAddress addr;
			addr = InetAddress.getByName(rdsHost);
	    	int port = 3306;
	    	
	    	SocketAddress sockaddr = new InetSocketAddress(addr, port);
	    	Socket sock = new Socket();
	    	sock.connect(sockaddr, 2000);
	    	
	    	if(sock.isConnected()) {		
	    		sock.close();
	    		System.out.println("success to connect AWS-RDS Welcome");
	    		return sourceProperty;
	    	}
	    	sock.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
			
			System.out.println("fail to connect AWS-RDS");
			System.out.println("reconnect to localhost");
			sourceProperty.setUrl(url);
	        sourceProperty.setUsername(Name);
	        sourceProperty.setPassword(Pw);
		} 
	        
			return sourceProperty;
		
    
    }

}
