package it.uniecampus.lfulgione.tastetracking.ttbe.login.repository;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
