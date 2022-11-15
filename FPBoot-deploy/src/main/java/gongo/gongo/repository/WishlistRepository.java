package gongo.gongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gongo.gongo.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{
    
    // save 저장 (memberId / wishlistId)

    // delete 삭제 (deleteById)



}
