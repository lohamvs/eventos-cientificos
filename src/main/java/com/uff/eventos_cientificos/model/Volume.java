/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author loham.silva
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Volume.buscaTodos",
                query="SELECT v FROM Volume v")
})
public class Volume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int edicao;
    
    @Column(nullable=false, length=32)
    String sigla;
    
    @Column(nullable=false, length=64)
    String cidade;
    
    @Column(name="data_inicio", nullable=false, length=10)
    String dataInicio;
    
    @Column(nullable=false, length=2048)
    String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "volume")
    @JsonManagedReference
    List<Artigo> artigos;
    
    final static String dateFormat = "dd/mm/yyyy"; 
    
    public Volume() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        if(validateDate(dataInicio)) {
            this.dataInicio = dataInicio;
        }
        else System.out.println("Data inválida"); 
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "volume")
    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }
    
    public static boolean validateDate(String date)  
    { 
        try { 
            DateFormat df = new SimpleDateFormat(dateFormat); 
            df.setLenient(false); 
            df.parse(date); 
            return true; 
        } catch (ParseException e) { 
            return false; 
        } 
    }
}
