package kr.pe.cshop.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.pe.cshop.model.domain.MemoryCard;

@Repository
public interface MemoryCardRepository extends CrudRepository<MemoryCard,String> {

}
