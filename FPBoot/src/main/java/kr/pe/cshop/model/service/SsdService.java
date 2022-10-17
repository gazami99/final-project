package kr.pe.cshop.model.service;

import java.util.ArrayList;

import kr.pe.cshop.model.domain.SsdDTO;

public interface SsdService {
    
    ArrayList<SsdDTO> getSsdAll() throws Exception;
	
	ArrayList<SsdDTO> getSsdByBrand(String brand) throws Exception;
	
    ArrayList<SsdDTO> getSsdByName(String name) throws Exception;

}
