package com.ecn.iemjava.repository;

import com.ecn.iemjava.models.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form,Integer> {
}
