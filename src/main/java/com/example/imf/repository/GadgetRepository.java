package com.example.imf.repository;

import com.example.imf.entity.Gadget;
import com.example.imf.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, UUID> {
    List<Gadget> findByStatus(Status status);
}
