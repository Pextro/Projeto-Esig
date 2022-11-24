package br.com.bean;

import br.com.dao.TarefaDAO;
import br.com.entidade.Responsavel;
import br.com.entidade.Tarefa;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import java.util.List;
import java.util.Objects;

@ViewScoped
@ManagedBean
public class TarefaBean {

    private Tarefa tarefa;
    private Responsavel responsavel;

    private List<Tarefa> listaTarefas;

    private TarefaDAO dao;

    public void saveTask(){
        tarefa.setResponsavel(responsavel);

        if(Objects.nonNull(tarefa.getId())){
            dao.update(tarefa);
        }else{
            dao.save(tarefa);
        }
       listaTarefas = dao.listAll();
    }

    public void finalizarTarefa(Long id){
        Tarefa tarefa = new Tarefa();

        tarefa = dao.findById(id);
        tarefa.setStatus(false);

        dao.update(tarefa);

        listaTarefas = dao.listAll();
    }

    public void deletarTarefa(Long id){
        Tarefa tarefa = new Tarefa();

        tarefa = dao.findById(id);
        dao.delete(tarefa);

        listaTarefas = dao.listAll();
    }

    @PostConstruct
    public void init() {
        TarefaDAO dao = new TarefaDAO();
        responsavel = new Responsavel();
        tarefa = new Tarefa();
        listaTarefas = dao.listAll();
    }

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
    
    

}
