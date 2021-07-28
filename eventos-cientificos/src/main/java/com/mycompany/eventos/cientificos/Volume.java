/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventos.cientificos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author loham.silva
 */
public class Volume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int edicao;
    
    @Column(nullable=false, length=32)
    String sigla;
    
    @Column(nullable=false, length=64)
    String cidade;
    
    @Column(nullable=false, length=10)
    String dataInicio;
    
    @Column(nullable=false, length=2048)
    String descricao;
    
    @OneToMany(mappedBy = "volume")
    List<Artigo> artigos;
    
    final static String dateFormat = "yyyy-mm-dd"; 
    
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
