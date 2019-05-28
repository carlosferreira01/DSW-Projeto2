package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.util.Set;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Teatro extends Usuario implements Serializable {



    private String nome;
    private String CNPJ;
    private String cidade;
   //@OneToOne @JoinColumn public Usuario usuario;
    @OneToMany (mappedBy = "teatro", fetch = FetchType.LAZY) 
    private List<Promocao> promocoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    public List<Promocao> getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(List<Promocao> promocoes) {
        this.promocoes = promocoes;
    }
    
    @Override
    public String toString(){
        return CNPJ;
    }
    public boolean equals(Object obj) {
        if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Teatro))
		return false;
	Teatro other = (Teatro) obj;
	return other.nome.equals(this.nome);
    }
}