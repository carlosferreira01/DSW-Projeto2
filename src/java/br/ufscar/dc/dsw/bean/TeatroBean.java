package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TeatroBean {

    private Teatro teatro;
    private List<Teatro> teatros;

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
        if (teatro.getId() == null) {
            dao.save(teatro);
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
    
    public String verCidades(){
        return "cidades.xhtml";
    }
    public List<String> getCidades() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getCidades();
    }
    public String getTeatros(String cidade) throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        teatros = dao.getByCity(cidade);
        return "index.xhtml";
    }
}