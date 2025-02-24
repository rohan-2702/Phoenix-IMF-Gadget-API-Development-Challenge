package com.example.imf.repository;

import com.example.imf.entity.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GadgetRepository extends JpaRepository<Gadget, UUID> {

}
