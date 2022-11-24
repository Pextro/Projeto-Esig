package br.com.entidade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
@Entity
@Table(name = "tarefa", schema = "public")
@NamedQueries({@NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t"),
        @NamedQuery(name = "Tarefa.findByForm", query = "SELECT t FROM Tarefa t WHERE "
                + "(((t.id = :id) or  (t.titulo = :titulo) or (t.responsavel = :responsavel)) and (t.status = :status)) "
        ),
        @NamedQuery(name = "Tarefa.findByStatus", query = "SELECT t FROM Tarefa t WHERE (t.status = :status) "
        ),
        @NamedQuery(name = "Tarefa.findById", query = "SELECT t FROM Tarefa t where (t.id = :id)")
})
public class Tarefa {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "tarefa_sequence", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "id")
    private Long id;

    @Column (name = "titulo")
    private String titulo;

    @Column (name = "descricao")
    private String descricao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="responsavel")
    private Responsavel responsavel;

    @Column (name = "prioridade")
    private String prioridade;

    @Column (name = "deadline")
    private String deadline;

    @Column (name = "status")
    private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
    
    
}
