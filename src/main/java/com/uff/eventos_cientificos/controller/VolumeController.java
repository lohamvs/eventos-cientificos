/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.controller;

import com.uff.eventos_cientificos.model.Volume;
import com.uff.eventos_cientificos.repository.VolumeRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author loham.silva
 */
@CrossOrigin
@RestController
@RequestMapping(value="/volumes")
public class VolumeController {
    
    @Autowired
    VolumeRepository repository;
    
    @GetMapping("")
    public List<Volume> getVolumes() {
        return repository.findAll();
    }
    
    @GetMapping("/{volumeId}")
    public Volume getVolumeById(@PathVariable(value="volumeId")int volumeId) {
        return repository.findById(volumeId);
    }
    
    @PostMapping("")
    public Volume salvaVolume(@RequestBody Volume volume) {
        return repository.save(volume);
    }
    
    @DeleteMapping("")
    public void deletaVolume(@RequestBody Volume volume) {
        repository.delete(volume);
    }
    
    @PutMapping("")
    public Volume atualizaVolume(@RequestBody Volume volume) {
        return repository.save(volume);
    }
}
