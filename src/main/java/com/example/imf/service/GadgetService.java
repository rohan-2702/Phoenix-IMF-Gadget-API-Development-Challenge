package com.example.imf.service;

import com.example.imf.entity.Gadget;
import com.example.imf.entity.Status;
import com.example.imf.repository.GadgetRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class GadgetService {

    private final GadgetRepository gadgetRepository;
    private Random random = new Random();

    public GadgetService(GadgetRepository gadgetRepository){
        this.gadgetRepository = gadgetRepository;
    }

    public List<Gadget> getAllGadget(){
        List<Gadget> gadgets = gadgetRepository.findAll();
        for (Gadget gadget : gadgets) {
            int probability = 50 + random.nextInt(51); // Random success rate 50-100%
            System.out.println(gadget.getName() + " - " + probability + "% success probability");
        }
        return gadgets;
    }

    public Gadget addGadget(){
        String codename = generateCodeName();
        Gadget gadget = new Gadget(codename, Status.AVAILABLE);
        return gadgetRepository.save(gadget);
    }

    public Optional<Gadget> updateGadget(UUID id, String newName, Status newStatus){
        Optional<Gadget> gadget = gadgetRepository.findById(id);
        gadget.ifPresent(gadget1 -> {
            gadget1.setName(newName);
            gadget1.setStatus(newStatus);
            gadgetRepository.save(gadget1);
        });
        return gadget;
    }

    public Optional<Gadget> deleteGadget(UUID id){
        Optional<Gadget> gadget = gadgetRepository.findById(id);
        gadget.ifPresent(g -> {
            g.setStatus(Status.DECOMMISSIONED);
            g.setDecommissionedAt(LocalDateTime.now().toString());
            gadgetRepository.save(g);
        });
        return gadget;
    }

    private String generateCodeName(){
        String[] codenames = {" The Nightingale", "The Kraken", "Ghost Falcon", "Iron Hawk"};
        return codenames[random.nextInt(codenames.length)];
    }
}
