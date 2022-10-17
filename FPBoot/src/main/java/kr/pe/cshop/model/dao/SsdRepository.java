package kr.pe.cshop.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.pe.cshop.model.entity.Ssd;

@Repository
public interface SsdRepository extends CrudRepository<Ssd, String> {
    
    Ssd findSsdBySn(String sn);
    
    Ssd findSsdByBrand(String sn);
    
    Ssd findSsdByName(String sn);
   
}


