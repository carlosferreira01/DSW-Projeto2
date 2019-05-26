package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author carlos
 */
@Entity
public class Site implements Serializable {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String url;
    private String telefone;
    @OneToOne @JoinColumn private Usuario usuario;
    
    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
    private List<Promocao> promocoes;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString(){
    return url;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Site))
		return false;
	Site other = (Site) obj;
	return other.nome.equals(this.nome);
    }
    
    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setLivros(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
}