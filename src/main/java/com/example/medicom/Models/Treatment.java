package com.example.medicom.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String treatmentDate;


    private Float treatmentSum;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "worker_id")
    private Worker worker_;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "patient_id")
    private Patient patient_;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "disease_id")
    private Disease disease_;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Float getTreatmentSum() {
        return treatmentSum;
    }

    public void setTreatmentSum(Float treatmentSum) {
        this.treatmentSum = treatmentSum;
    }

    public Worker getWorker_() {
        return worker_;
    }

    public void setWorker_(Worker worker_) {
        this.worker_ = worker_;
    }

    public Patient getPatient_() {
        return patient_;
    }

    public void setPatient_(Patient patient_) {
        this.patient_ = patient_;
    }

    public Disease getDisease_() {
        return disease_;
    }

    public void setDisease_(Disease disease_) {
        this.disease_ = disease_;
    }

    public Treatment(String treatmentDate, Float treatmentSum, Worker worker_, Patient patient_, Disease disease_) {
        this.treatmentDate = treatmentDate;
        this.treatmentSum = treatmentSum;
        this.worker_ = worker_;
        this.patient_ = patient_;
        this.disease_ = disease_;
    }

    public Treatment() {
    }
}
