package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Site;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {

    private Site site;
    private List<Promocao> promocoes;
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String lista() {
        return "site/index.xhtml";
    }

    public String cadastra() {
        site = new Site();
        return "form.xhtml";
    }

    public String edita(Long id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        SiteDAO dao = new SiteDAO();
        PapelDAO papelDAO = new PapelDAO();
        if (site.getId() == null) {
            site.setSenha(encoder.encode(site.getSenha()));
            site.setAtivo(true);
            dao.save(site);
            
            Papel p4 = new Papel();
            p4.setNome("ROLE_SITE");
            site.getPapel().add(p4);
            dao.update(site);
        } else {
            dao.update(site);
        }
        return "index.xhtml";
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }

    public Site getSite() {
        return site;
    }
}
