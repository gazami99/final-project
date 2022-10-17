package kr.pe.cshop.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.cshop.model.dao.SsdRepository;
import kr.pe.cshop.model.domain.SsdDTO;
import kr.pe.cshop.model.entity.Ssd;

@Service
public class SsdServiceImpl implements SsdService {
    
    @Autowired
    SsdRepository ssdRepo;

    public ArrayList<SsdDTO> getSsdAll() throws Exception {
        ArrayList<Ssd> all = (ArrayList<Ssd>) ssdRepo.findAll();
		ArrayList<SsdDTO> allDTO = new ArrayList<SsdDTO>();
		
		for(Ssd i : all) {
			allDTO.add(SsdDTO.builder().sn(i.getSn()).brand(i.getBrand()).name(i.getName()).price(i.getPrice()).build());
		}
		return allDTO;
    }

    public ArrayList<SsdDTO> getSsdByBrand(String brand) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<SsdDTO> getSsdByName(String name) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
