package gongo.gongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gongo.gongo.entity.ProductInfo;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{
    
}
