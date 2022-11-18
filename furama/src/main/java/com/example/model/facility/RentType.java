package com.example.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue
    private Integer id;
    private String note;

    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private Set<Facility> facilities;

    public RentType() {
    }

    public RentType(Integer id, String note, Set<Facility> facilities) {
        this.id = id;
        this.note = note;
        this.facilities = facilities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
