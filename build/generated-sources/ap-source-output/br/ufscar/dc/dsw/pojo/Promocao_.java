package br.ufscar.dc.dsw.pojo;

import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-25T17:08:57")
@StaticMetamodel(Promocao.class)
public class Promocao_ { 

    public static volatile SingularAttribute<Promocao, Float> preco;
    public static volatile SingularAttribute<Promocao, Site> site;
    public static volatile SingularAttribute<Promocao, Teatro> sala;
    public static volatile SingularAttribute<Promocao, String> nome;
    public static volatile SingularAttribute<Promocao, Long> id;
    public static volatile SingularAttribute<Promocao, Date> dia;

}