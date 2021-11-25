package repository;

import models.FormStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormStatusRepository extends JpaRepository<FormStatus,Integer> {
}
