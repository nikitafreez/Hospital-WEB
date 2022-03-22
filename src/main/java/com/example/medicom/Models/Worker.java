package com.example.medicom.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;

    private String Surname;

    private String Patronymic;

    private String PassSeria;

    private String PassNum;

    private String INN;

    private Date birthDate;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "position_id")
    private Position position_;

    @OneToMany(mappedBy = "worker_", fetch = FetchType.EAGER)
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getPassSeria() {
        return PassSeria;
    }

    public void setPassSeria(String passSeria) {
        PassSeria = passSeria;
    }

    public String getPassNum() {
        return PassNum;
    }

    public void setPassNum(String passNum) {
        PassNum = passNum;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public Position getPosition_() {
        return position_;
    }

    public void setPosition_(Position position_) {
        this.position_ = position_;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Worker(String name, String surname, String patronymic, String passSeria, String passNum, String INN, Date birthDate, Position position_) {
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        PassSeria = passSeria;
        PassNum = passNum;
        this.INN = INN;
        this.birthDate = birthDate;
        this.position_ = position_;
    }

    public Worker() {
    }
}
