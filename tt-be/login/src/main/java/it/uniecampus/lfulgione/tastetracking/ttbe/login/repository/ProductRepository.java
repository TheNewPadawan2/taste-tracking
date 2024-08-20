package it.uniecampus.lfulgione.tastetracking.ttbe.login.repository;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByDeleteDateIsNull();
    List<ProductEntity> findByNameContainsIgnoreCaseAndDeleteDateIsNull(String name);
    List<ProductEntity> findByTypeAndDeleteDateIsNull(Integer type);
    List<ProductEntity> findByNameContainsIgnoreCaseAndTypeAndDeleteDateIsNull(String name, Integer type);
}
