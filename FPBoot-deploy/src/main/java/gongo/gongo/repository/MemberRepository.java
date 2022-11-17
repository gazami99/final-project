package gongo.gongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gongo.gongo.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

    @Query("select wl.id from Wishlist as wl inner join Member as m on wl.member = m.id where wl.member = :mId")
    Long findWishlistIdByMemberId(@Param("mId") String mId);
    

}
