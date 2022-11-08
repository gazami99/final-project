package gongo.gongo.repository;

import org.springframework.data.repository.CrudRepository;

import gongo.gongo.entity.ProductInfo;

public interface ProductInfoRepository extends CrudRepository<ProductInfo, String>{
    
}
