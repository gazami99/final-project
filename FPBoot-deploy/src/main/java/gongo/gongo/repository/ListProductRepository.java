package gongo.gongo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gongo.gongo.entity.ListProduct;

@Repository
public interface ListProductRepository extends JpaRepository<ListProduct, Integer>{
    
    @Query("select lp from list_product as lp where lp.wishlistId = :wishlistId")
    ArrayList<ListProduct> findListProductByWishlist(Long wishlistId);
    // @Query("insert into ... (id, .. , wishlistId, )리스트프로덕트 생성 :wishList")
}
