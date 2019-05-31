package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class TeatroBean implements Serializable {

    private String cidadeEscolhida;

    public String getCidadeEscolhida() {
        return cidadeEscolhida;
    }

    public void setCidadeEscolhida(String cidadeEscolhida) {
        this.cidadeEscolhida = cidadeEscolhida;
    }
    private Teatro teatro;
    private List<Teatro> teatros;
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String lista() {
        TeatroDAO dao = new TeatroDAO();
        teatros = dao.getAll();
        return "teatro/index.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "form.xhtml";
    }

    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        PapelDAO papelDAO = new PapelDAO();
        if (teatro.getId() == null) {
            teatro.setSenha(encoder.encode(teatro.getSenha()));
            teatro.setAtivo(true);
            dao.save(teatro);
            
            Papel p3 = new Papel();
            p3.setNome("ROLE_TEATRO");
            teatro.getPapel().add(p3);
            dao.update(teatro);
        } else {
            dao.update(teatro);
        }
        teatros = dao.getAll();
        return "index.xhtml";
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        teatros = dao.getAll();
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Teatro> getTeatros() throws SQLException {
        //TeatroDAO dao = new TeatroDAO();
        //teatros = dao.getAll();
        return teatros;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public String verCidades() {
        return "cidades.xhtml";
    }

    public List<String> getCidades() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getCidades();
    }

    public String getTeatrosCidade() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        teatros = dao.getByCity(cidadeEscolhida);
        return "index.xhtml";
    }
}
