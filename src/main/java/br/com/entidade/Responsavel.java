package br.com.entidade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="responsavel", schema = "public")
@NamedQueries({ @NamedQuery(name = "Responsavel.findAll", query = "SELECT r FROM Responsavel r")})
public class Responsavel {

    @Id
    @SequenceGenerator(name = "seqp", sequenceName = "profile_sequence", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqp")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
