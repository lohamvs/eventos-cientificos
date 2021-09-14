/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.controller;

import com.uff.eventos_cientificos.model.Artigo;
import com.uff.eventos_cientificos.model.Volume;
import com.uff.eventos_cientificos.repository.ArtigoRepository;
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
@RequestMapping(value="volumes")
public class ArtigoController {
    
    @Autowired
    ArtigoRepository repository;
    
    @Autowired
    VolumeRepository volumeRepository;
    
    @GetMapping("/{volumeId}/artigos")
    public List<Artigo> getArtigos(@PathVariable(value="volumeId")int volumeId) {
        return repository.findByVolumeId(volumeId);
    }
    
    @GetMapping("/{volumeId}/artigos/{artigoId}")
    public Artigo getArtigoById(@PathVariable(value="volumeId")int volumeId, @PathVariable(value="artigoId")int artigoId) {
        return repository.findById(artigoId);
    }
    
    @PostMapping("/{volumeId}/artigos")
    public Artigo salvaArtigo(@PathVariable(value="volumeId")int volumeId, @RequestBody Artigo artigo) {
        Volume volume = volumeRepository.findById(volumeId);
        artigo.setVolume(volume);
        return repository.save(artigo);
    }
    
    @DeleteMapping("/{volumeId}/artigos")
    public void deletaArtigo(@PathVariable(value="volumeId")int volumeId, @RequestBody Artigo artigo) {
        repository.delete(artigo);
    }
    
    @PutMapping("/{volumeId}/artigos")
    public Artigo atualizaArtigo(@PathVariable(value="volumeId")int volumeId, @RequestBody Artigo artigo) {
        Volume volume = volumeRepository.findById(volumeId);
        artigo.setVolume(volume);
        return repository.save(artigo);
    }
}
