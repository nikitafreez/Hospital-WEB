package com.example.medicom.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String positionName;

    @OneToMany(mappedBy = "position_", fetch = FetchType.EAGER)
    private Collection<Worker> workerCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Collection<Worker> getWorkerCollection() {
        return workerCollection;
    }

    public void setWorkerCollection(Collection<Worker> workerCollection) {
        this.workerCollection = workerCollection;
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Position() {
    }
}
