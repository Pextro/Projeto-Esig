package br.com.dao;

import br.com.config.HibernateConfig;
import br.com.entidade.Responsavel;
import br.com.entidade.Tarefa;
import org.hibernate.Session;

import java.util.List;

public class ResponsavelDAO {

    public void save(Responsavel responsavel){
        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.persist(responsavel);
        sessao.flush();
        sessao.getTransaction().commit();

        sessao.close();
      
    }

    public List<Responsavel> listAll(){
        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        List<Responsavel> listaDeResponsaveis = sessao.getNamedQuery("Responsavel.findAll").list();

        sessao.close();

        return listaDeResponsaveis;
    }

}
