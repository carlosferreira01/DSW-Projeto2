package br.ufscar.dc.dsw.pojo;

import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-23T16:36:12")
@StaticMetamodel(Teatro.class)
public class Teatro_ { 

    public static volatile SingularAttribute<Teatro, String> cidade;
    public static volatile SingularAttribute<Teatro, String> nome;
    public static volatile SingularAttribute<Teatro, String> CNPJ;
    public static volatile SingularAttribute<Teatro, Usuario> usuario;
    public static volatile SingularAttribute<Teatro, Long> id;
    public static volatile SetAttribute<Teatro, Promocao> promocoes;

}