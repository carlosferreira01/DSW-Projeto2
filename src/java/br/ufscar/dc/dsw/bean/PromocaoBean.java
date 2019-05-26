package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Site;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PromocaoBean {

    private Promocao promocao;
    private Site site;
    private List<Site> sites;

    public String lista() {
        return "promocao/index.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return "form.xhtml";
    }

    public String edita(Long id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }

    public Promocao getPromocao() {
        return promocao;
    }
//    public String verTeatros(){
//        return "teatros.xhtml";
//    }
//   public String verSites(){
//        return "sites.xhtml";
//    }
   public List<Site> getSites() throws SQLException {
        //PromocaoDAO dao = new PromocaoDAO();
        //return dao.getSites();
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }
    public List<String> getTeatros() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getTeatros();
    }
    /*
    public void setSite(Site site){
        this.site = site;
    }
    public Site getSite(){
        return site;
    }*/
    
}