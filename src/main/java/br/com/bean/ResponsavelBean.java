package br.com.bean;

import br.com.dao.ResponsavelDAO;
import br.com.entidade.Responsavel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import java.util.List;

@ViewScoped
@ManagedBean
public class ResponsavelBean {

    private Responsavel responsavel;

    private ResponsavelDAO responsavelDAO;

    private List<Responsavel> listResponsaveis;


    public void saveResponsavel(){
        responsavelDAO.save(responsavel);
        listResponsaveis = responsavelDAO.listAll();
       
    }
    
    @PostConstruct
    public void init () {
    	responsavel = new Responsavel(); 
    	responsavelDAO = new ResponsavelDAO();
    }


	public Responsavel getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}


	public List<Responsavel> getListResponsaveis() {
		return listResponsaveis;
	}


	public void setListResponsaveis(List<Responsavel> listResponsaveis) {
		this.listResponsaveis = listResponsaveis;
	}
    
    
}
