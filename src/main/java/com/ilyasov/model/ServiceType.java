package com.ilyasov.model;

import javax.persistence.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

@Entity
@Table
public class ServiceType  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Worker> workers;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Schedule> schedules;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
