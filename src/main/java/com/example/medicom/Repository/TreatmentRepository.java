package com.example.medicom.Repository;

import com.example.medicom.Models.Treatment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {
}
