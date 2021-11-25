package repository;

import models.IntermissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermissionStatusRepository extends JpaRepository<IntermissionStatus,Integer> {
}
