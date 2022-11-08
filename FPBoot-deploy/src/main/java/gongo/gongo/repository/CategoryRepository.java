package gongo.gongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gongo.gongo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
