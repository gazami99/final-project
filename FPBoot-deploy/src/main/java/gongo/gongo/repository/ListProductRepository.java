package gongo.gongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gongo.gongo.entity.ListProduct;

public interface ListProductRepository extends JpaRepository<ListProduct, Integer>{
    
}
