package gongo.gongo.service;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MLService {

    private WebClient webClient;
    
    @PostConstruct
    public void initWebClient() {
    	webClient = WebClient.create("http://localhost:5000/gongo/search");
    }
    
    public String keywordSearching(String purpose, String price) throws SQLException {
        
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                .path("/keyword/{purpose}/{price}")
                 .build(purpose,price))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
    

