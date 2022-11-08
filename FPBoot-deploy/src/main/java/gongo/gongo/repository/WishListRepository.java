package gongo.gongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gongo.gongo.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Integer>{
    
}
