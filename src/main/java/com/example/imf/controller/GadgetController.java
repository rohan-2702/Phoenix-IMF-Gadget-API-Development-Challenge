package com.example.imf.controller;

import com.example.imf.entity.Gadget;
import com.example.imf.entity.Status;
import com.example.imf.repository.GadgetRepository;
import com.example.imf.service.GadgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/gadgets")
public class GadgetController {

    private final GadgetService gadgetService;
    private final GadgetRepository gadgetRepository;

    public GadgetController(GadgetService gadgetService, GadgetRepository gadgetRepository) {
        this.gadgetService = gadgetService;
        this.gadgetRepository = gadgetRepository;
    }

    @GetMapping
    public List<Gadget> getAllGadgets(){
        return gadgetService.getAllGadget();
    }

    @PostMapping
    public Gadget addGadget(){
        return gadgetService.addGadget();
    }

    @GetMapping("/status")
    public ResponseEntity<List<Gadget>> getGadgetByStatus(@RequestParam(required = false) Status status) {
        try {
            return ResponseEntity.ok(gadgetService.getGadgetsByStatus(status));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.emptyList()); // Return an empty list on bad request
        }
    }

    @PostMapping("/{id}/self-destruct")
    public ResponseEntity<Map<String, String>> selfDestructGadget(@PathVariable UUID id){
        Optional<Gadget> gadget = gadgetRepository.findById(id);
        if (gadget.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Gadget not Found"));
        }

        Gadget gadget1 = gadget.get();
        String confirmationCode = String.format("%06d", new Random().nextInt(1000000));

        gadget1.setStatus(Status.DESTROYED);
        gadgetRepository.save(gadget1);

        return ResponseEntity.ok(Map.of(
                "message", "Self-destruct sequence initiated",
                "confirmation_code", confirmationCode
        ));
    }

    @PatchMapping("/{id}")
    public Optional<Gadget> updateGadget(@PathVariable UUID id,
                                         @RequestParam String newName,
                                         @RequestParam Status newStatus){
        return gadgetService.updateGadget(id, newName, newStatus);
    }

    @DeleteMapping("/{id}")
    public Optional<Gadget> deleteGadget(@PathVariable UUID id){
        return gadgetService.deleteGadget(id);
    }

}
