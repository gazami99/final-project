package kr.pe.cshop.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.pe.cshop.model.entity.Gpu;

@Repository
public interface GpuRepository extends CrudRepository<Gpu, String> {
    
    
}
