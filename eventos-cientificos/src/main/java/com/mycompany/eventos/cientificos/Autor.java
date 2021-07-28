/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventos.cientificos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author loham.silva
 */
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    int ordem;
    
    @Column(nullable=false)
    String email;
    
    @Column(nullable=false, length=64)
    String primeiroNome;
    
    @Column(nullable=false, length=64)
    String nomeDoMeio;
    
    @Column(nullable=false, length=64)
    String sobrenome;
    
    @Column(nullable=false, length=256)
    String afiliacao;
    
    @Column(nullable=false, length=256)
    String afiliacaoIngles;
    
    @Column(nullable=false, length=2)
    String nacao;
    
    @Column(nullable=false, length=19)
    String orcId;
    
    @ManyToOne
    Artigo artigo;
    
    public static final Pattern emailPattern =  
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE); 
    
    public static final Pattern orcIdPattern =  
        Pattern.compile("^[a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+-[a-zA-Z]+$", Pattern.CASE_INSENSITIVE); 
    
    public Autor(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { 
        if (validateEmail(email)){ 
            this.email = email; 
        } 
        else System.out.println("Email inválido"); 
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public String getAfiliacaoIngles() {
        return afiliacaoIngles;
    }

    public void setAfiliacaoIngles(String afiliacaoIngles) {
        this.afiliacaoIngles = afiliacaoIngles;
    }

    public String getNacao() {
        return nacao;
    }

    public void setNacao(String nacao) {
        if(nacao.matches("PT|US|FR|BR|UK|ES")) { 
            this.nacao = nacao; 
        } 
        else System.out.println("País inválido");
    }

    public String getOrcId() {
        return orcId;
    }

    public void setOrcId(String orcId) {
        if (validateOrcId(email)){ 
            this.orcId = orcId;
        } 
        else System.out.println("OrcId inválido"); 
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }
    
    public static boolean validateEmail(String email) { 
        Matcher matcher = emailPattern.matcher(email); 
        return matcher.find(); 
    }
    
     public static boolean validateOrcId(String orcid) { 
        Matcher matcher = orcIdPattern.matcher(orcid); 
        return matcher.find(); 
    }
}
