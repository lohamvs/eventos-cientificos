/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.controller;

import com.uff.eventos_cientificos.model.Autor;
import com.uff.eventos_cientificos.repository.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author loham.silva
 */
@RestController
@RequestMapping(value="autores")
public class AutorController {
    
    @Autowired
    AutorRepository repository;
    
    @GetMapping("")
    public List<Autor> getAutores(@RequestParam("volumeId") int volumeId) {
        System.out.println("entrou");
        System.out.println(volumeId);
        return repository.findByVolumeId(volumeId);
    }
    
    @GetMapping("/{autorId}")
    public Autor getAutorById(@PathVariable(value="autorId")int autorId) {
        return repository.findById(autorId);
    }
    
    @PostMapping("")
    public Autor salvaAutor(@RequestBody Autor autor) {
        return repository.save(autor);
    }
    
    @DeleteMapping("")
    public void deletaAutor(@RequestBody Autor autor) {
        repository.delete(autor);
    }
    
    @PutMapping("")
    public Autor atualizaAutor(@RequestBody Autor autor) {
        return repository.save(autor);
    }
}
