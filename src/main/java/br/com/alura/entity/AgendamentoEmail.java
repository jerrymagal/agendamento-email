package br.com.alura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "agendamento_email")
public class AgendamentoEmail implements Serializable {

	private static final long serialVersionUID = 4851147462166809415L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank(message = "{agendamentoEmail.email.vazio}")
	@Email(message = "{agendamentoEmail.email.invalido}")
	private String email;
	
	@Column
	@NotBlank(message = "{agendamentoEmail.assunto.vazio}")
	private String assunto;
	
	@Column
	@NotBlank(message = "{agendamentoEmail.mensagem.vazio}")
	private String mensagem;

	@Column
	private boolean enviado;
}
