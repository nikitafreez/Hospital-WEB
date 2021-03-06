package com.example.medicom.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 50, message = "От 2 до 50 символов")
    private String diseaseName;

    @Size(max = 200, message = "Не больше 200 символов")
    private String diseaseDescription;

    @OneToMany(mappedBy = "disease_", fetch = FetchType.EAGER)
    private Collection<Treatment> treatmentCollection;

    public Collection<Treatment> getTreatmentCollection() {
        return treatmentCollection;
    }

    public void setTreatmentCollection(Collection<Treatment> treatmentCollection) {
        this.treatmentCollection = treatmentCollection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseDescription() {
        return diseaseDescription;
    }

    public void setDiseaseDescription(String diseaseDescription) {
        this.diseaseDescription = diseaseDescription;
    }

    public Disease(String diseaseName, String diseaseDescription) {
        this.diseaseName = diseaseName;
        this.diseaseDescription = diseaseDescription;
    }

    public Disease() {
    }
}
