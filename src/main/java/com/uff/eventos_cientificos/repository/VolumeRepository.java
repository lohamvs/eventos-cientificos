/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.repository;

import com.uff.eventos_cientificos.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author loham.silva
 */
public interface VolumeRepository extends JpaRepository<Volume, Long> {
    
    Volume findById(int volumeId);
}
