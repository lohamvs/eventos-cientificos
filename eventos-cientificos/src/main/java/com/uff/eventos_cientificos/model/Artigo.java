/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.eventos_cientificos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author loham.silva
 */
@Entity
@NamedQuery(name="Artigo.buscaPorVolume",
                query="SELECT a FROM Artigo a WHERE a.volume.id = ?1")
public class Artigo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int ordem;
    
    @Column(nullable=false, length=2)
    String idioma;

    @Column(nullable=false)
    String tituloOriginal;

    @Column(nullable=false)
    String tituloIngles;
    
    @Column(nullable=false, length=2048)
    String resumoOriginal;
    
    @Column(nullable=false, length=2048)
    String resumoIngles;
    
    // Palavras chave separadas pelo caracter ";"
    @Column(nullable=false)
    String palavrasChaveOriginais;
    
    // Palavras chave separadas pelo caracter ";"
    @Column(nullable=false)
    String palavrasChaveIngles;
    
    int quantidadePaginas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artigo")
    @JsonManagedReference
    List<Autor> autores;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="volume_id", nullable=false)
    @JsonBackReference
    Volume volume;
    
    public Artigo() {}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        if(idioma.matches("pt|en|es")) { 
            this.idioma = idioma;
        } 
        else System.out.println("Idioma inválido");
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTituloIngles() {
        return tituloIngles;
    }

    public void setTituloIngles(String tituloIngles) {
        this.tituloIngles = tituloIngles;
    }

    public String getResumoOriginal() {
        return resumoOriginal;
    }

    public void setResumoOriginal(String resumoOriginal) {
        this.resumoOriginal = resumoOriginal;
    }

    public String getResumoIngles() {
        return resumoIngles;
    }

    public void setResumoIngles(String resumoIngles) {
        this.resumoIngles = resumoIngles;
    }

    public String getPalavrasChaveOriginais() {
        return palavrasChaveOriginais;
    }
    
    public void getPalavrasChaveOriginais(String palavrasChaveOriginais) {
        this.palavrasChaveOriginais = palavrasChaveOriginais;
    }
    
    List<String> getListaPalavrasChaveOriginais() {
        return Arrays.asList(this.palavrasChaveOriginais.split(";"));
    }

    public void setListaPalavrasChaveOriginais(List<String> listaPalavrasChaveOriginais) {
        String joinPalavrasChaveOriginais = String.join(";", listaPalavrasChaveOriginais);
        this.palavrasChaveOriginais = joinPalavrasChaveOriginais;
    }

    public String getPalavrasChaveIngles() {
        return palavrasChaveIngles;
    }
    
    public void getPalavrasChaveIngles(String palavrasChaveIngles) {
        this.palavrasChaveIngles = palavrasChaveIngles;
    }
    
    List<String> getListaPalavrasChaveIngles() {
        return Arrays.asList(this.palavrasChaveIngles.split(";"));
    }

    public void setListaPalavrasChaveIngles(List<String> listaPalavrasChaveIngles) {
        String joinPalavrasChaveIngles = String.join(";", listaPalavrasChaveIngles);
        this.palavrasChaveIngles = joinPalavrasChaveIngles;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artigo")
    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @ManyToOne
    @JoinColumn(name="volume_id", nullable=false)
    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}
