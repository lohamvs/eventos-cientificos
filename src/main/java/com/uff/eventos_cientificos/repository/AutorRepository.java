/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.repository;

import com.uff.eventos_cientificos.model.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author loham.silva
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {
    
    Autor findById(int autorId);
    
    @Query("SELECT a FROM Autor a WHERE a.artigo.volume.id = ?1")
    List<Autor> findByVolumeId(int volumeId);
}
