package rmit.rmitsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rmit.rmitsb.model.Category;


import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c where c.cateId = ?1")
    Optional<Category> findCateById(Long cateId);

    @Query("SELECT c FROM Category c where c.cateType = ?1")
    Optional<Category> findCateByType(String cateType);

}