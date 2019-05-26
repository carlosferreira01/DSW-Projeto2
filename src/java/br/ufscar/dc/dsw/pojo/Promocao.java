package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlos
 */

@Entity
public class Promocao implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private Float preco;
    @Temporal(value = TemporalType.DATE)
    private Date dia;
    
    @ManyToOne 
    private Site site;
    @ManyToOne 
    private Teatro teatro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
    
}