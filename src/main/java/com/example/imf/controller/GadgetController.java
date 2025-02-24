package com.example.imf.controller;

import com.example.imf.entity.Gadget;
import com.example.imf.entity.Status;
import com.example.imf.service.GadgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/gadgets")
public class GadgetController {

    private final GadgetService gadgetService;

    public GadgetController(GadgetService gadgetService) {
        this.gadgetService = gadgetService;
    }

    @GetMapping
    public List<Gadget> getAllGadgets(){
        return gadgetService.getAllGadget();
    }

    @PostMapping
    public Gadget addGadget(){
        return gadgetService.addGadget();
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
