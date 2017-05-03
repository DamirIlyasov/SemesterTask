package com.ilyasov.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ServiceType> serviceTypes;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Worker> workers;

//    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Schedule> schedules;

//    public List<Schedule> getSchedules() {
//        return schedules;
//    }
//
//    public void setSchedules(List<Schedule> schedules) {
//        this.schedules = schedules;
//    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
