package gongo.gongo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gongo.gongo.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

    // @Query("select p from Product as p inner join product_info as pi on p.name = pi.name")
    // ArrayList<Product> findProducts();
   
    // @Query("select p from Product as p inner join product_info as pi on p.name=pi.name where p.id<5")
    // ArrayList<Product> find


    @Query("select p from Product as p inner join product_info as pi on p.name = pi.name where pi.brand like '%:brand%'")
    ArrayList<Product> findProductByBrand(@Param("brand") String brand);
    
    @Query("select p from Product as p inner join product_info as pi on p.name = pi.name inner join category as c on pi.category = c.name where c.name = :cat")
    ArrayList<Product> findProductByCat(@Param("cat") String cat);
    
    @Query("select p from Product as p inner join product_info as pi on p.name = pi.name where upper(p.name) like upper('%:name%')")
    ArrayList<Product> findProductByName(@Param("name") String name);
    
}

