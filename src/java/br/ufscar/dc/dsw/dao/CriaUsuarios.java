package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Usuario;
import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        PapelDAO papelDAO = new PapelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        TeatroDAO teatroDAO = new TeatroDAO();
        SiteDAO siteDAO = new SiteDAO();

        // Criando Usuario admin com papel ROLE_ADMIN
     
        Usuario u1 = new Usuario();
        u1.setEmail("admin@admin");
        u1.setSenha(encoder.encode("admin"));
        u1.setAtivo(true);
        usuarioDAO.save(u1);

        Papel p1 = new Papel();
        p1.setNome("ROLE_ADMIN");
        papelDAO.save(p1);

        u1.getPapel().add(p1);
        usuarioDAO.update(u1);

        // Criando usario
        
        Usuario u2 = new Usuario();
        u2.setEmail("user@user");
        u2.setSenha(encoder.encode("user"));
        u2.setAtivo(true);
        usuarioDAO.save(u2);

        Papel p2 = new Papel();
        p2.setNome("ROLE_USER");
        papelDAO.save(p2);

        u2.getPapel().add(p2);
        usuarioDAO.update(u2);
        
        //teatro pra teste
        
        /*Teatro t = new Teatro();
        t.setNome("TeatroA");
        t.setCNPJ("11111111");
        t.setCidade("São carlos");
        t.setEmail("teatro@teatro");
        t.setSenha(encoder.encode("teatro"));
        t.setAtivo(true);
        teatroDAO.save(t);

        Papel p3 = new Papel();
        p3.setNome("ROLE_TEATRO");
        papelDAO.save(p3);

        t.getPapel().add(p3);
        teatroDAO.update(t);
        
        //site pra teste
        
        Site s = new Site();
        s.setNome("Site1");
        s.setUrl("aaaaa");
        s.setTelefone("32123132");
        s.setEmail("site@site");
        s.setSenha(encoder.encode("site"));
        s.setAtivo(true);
        siteDAO.save(s);

        Papel p4 = new Papel();
        p4.setNome("ROLE_SITE");
        papelDAO.save(p4);
        
        s.getPapel().add(p4);
        siteDAO.update(s);
*/
    }
}
