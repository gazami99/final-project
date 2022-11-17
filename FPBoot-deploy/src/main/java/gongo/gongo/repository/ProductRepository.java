package gongo.gongo.repository;

import java.util.ArrayList;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gongo.gongo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    // @Query("select p from Product as p inner join product_info as pi on p.name = pi.name where pi.brand = :brand'")
    // ArrayList<Product> findProductByBrand(@Param("brand") String brand);
    
    @Query("select p, pi.category from Product as p inner join product_info as pi on p.name = pi.name where pi.category = :cat")
    ArrayList<Product> findProductByCat(PageRequest pageRequest, @Param("cat") String cat);

    // 검색어로 조회 로직
    @Query("select p from Product as p inner join product_info as pi on p.name = pi.name where pi.name like %:input%") //or upper(pi.brand) like upper(%:input%)")
    ArrayList<Product> findProductByInput(PageRequest pageRequest, @Param("input") String input);

    
}

