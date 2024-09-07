package it.uniecampus.lfulgione.tastetracking.ttbe.login.repository;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByDeleteDateIsNullOrderByNameAsc();
    List<ProductEntity> findByNameContainsIgnoreCaseAndDeleteDateIsNullOrderByNameAsc(String name);
    List<ProductEntity> findByTypeAndDeleteDateIsNullOrderByNameAsc(Integer type);
    List<ProductEntity> findByNameContainsIgnoreCaseAndTypeAndDeleteDateIsNullOrderByNameAsc(String name, Integer type);
    Optional<ProductEntity> findOneByName(String name);
}
