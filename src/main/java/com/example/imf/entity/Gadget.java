package com.example.imf.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Gadget {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String decommissionedAt;

    public Gadget(){}

    public Gadget(String name, Status status){
        this.name = name;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDecommissionedAt() {
        return decommissionedAt;
    }
    public void setDecommissionedAt(String decommissionedAt) {
        this.decommissionedAt = decommissionedAt;
    }

    @Override
    public String toString() {
        return "Gadget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';    }

}
