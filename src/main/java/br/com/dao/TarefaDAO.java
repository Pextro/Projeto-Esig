package br.com.dao;

import br.com.config.HibernateConfig;
import br.com.entidade.Tarefa;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public void save(Tarefa tarefa){
        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.persist(tarefa);
        sessao.getTransaction().commit();

        sessao.close();
    }

    public void update(Tarefa tarefa){
        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.update(tarefa);
        sessao.getTransaction().commit();

        sessao.close();

    }

    public void delete(Tarefa tarefa){
        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.delete(tarefa);
        sessao.getTransaction().commit();

        sessao.close();
    }

    public Tarefa findById(Long id){
        Tarefa tarefa = new Tarefa();

        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        tarefa = sessao.get(Tarefa.class, id);

        sessao.close();
        return tarefa;
    }

    public List<Tarefa> listAll(){
        Session sessao = HibernateConfig.getSessionFactory().openSession();
        sessao.beginTransaction();

        List<Tarefa> listaDeTarefas = sessao.getNamedQuery("Tarefa.findAll").list();

        sessao.close();

        return listaDeTarefas;
    }
}
