/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.repository;

import com.uff.eventos_cientificos.model.Artigo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author loham.silva
 */
public interface ArtigoRepository extends JpaRepository<Artigo, Long>{
    
    Artigo findById(int artigoId);
    
    List<Artigo> findByVolumeId(int volumeId);
}
