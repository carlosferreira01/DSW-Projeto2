package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import static java.rmi.server.LogStream.log;
import static java.time.Clock.system;

@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable{

    private Promocao promocao;
    private Teatro teatro;
    private Site site;
    private List<Site> sites;
    private List<Teatro> teatros;
    private List<Promocao> promocoes;
    private String erro ="";

    public String lista() {
        PromocaoDAO dao = new PromocaoDAO();
        promocoes = dao.getAll();
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
        promocoes = dao.getAll();
        for (Promocao promos : promocoes) {
            if ((promos.getSite().equals(promocao.getSite()))|| (promos.getTeatro().equals(promocao.getTeatro()))) {
                if ((promos.getDia().equals(promocao.getDia()))&& (promos.getHorario().equals(promocao.getHorario()))){
                    erro = "Error!";
                    return "form.xhtml";
                }
            }
        }
        if (promocao.getId() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        promocoes = dao.getAll();
        return "index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        promocoes = dao.getAll();
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        //PromocaoDAO dao = new PromocaoDAO();
        //return dao.getAll();
        return promocoes;
    }

    public Promocao getPromocao() {
        return promocao;
    }
    public List<Site> getSites() throws SQLException {
        log("get sites");
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }
    public List<Teatro> getTeatros() throws SQLException {
        log("get teatros");
        TeatroDAO dao = new TeatroDAO();
        return dao.getAll();
    }

    public String getPromocoes(Long id) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        promocoes = dao.getById(id);
        return "/promocao/index.xhtml";
    }
    public String getPromocoesTeatro(Long id) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        promocoes = dao.getByTeatro(id);
        return "/promocao/promocoesteatro.xhtml";
    }

}
