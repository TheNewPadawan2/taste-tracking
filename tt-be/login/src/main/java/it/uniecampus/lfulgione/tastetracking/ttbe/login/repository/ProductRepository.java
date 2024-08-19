package it.uniecampus.lfulgione.tastetracking.ttbe.login.repository;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
