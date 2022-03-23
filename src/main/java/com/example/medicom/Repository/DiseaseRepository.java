package com.example.medicom.Repository;

import com.example.medicom.Models.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends CrudRepository<Disease, Long> {
    Disease findByDiseaseName(String diseaseName);
}
