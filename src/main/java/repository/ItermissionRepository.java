package repository;

import models.Intermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItermissionRepository extends JpaRepository<Intermission,Integer> {
}
