package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {

	@PersistenceContext(unitName = "agendamento")
	private EntityManager entityManager;
	
	public List<AgendamentoEmail> listar() {
		return entityManager
				.createQuery("from AgendamentoEmail ae", AgendamentoEmail.class)
				.getResultList();
	}

	public List<AgendamentoEmail> listarAgendamentosNaoEnviados() {
		return entityManager
				.createQuery("from AgendamentoEmail ae where ae.enviado = false", AgendamentoEmail.class)
				.getResultList();
	}
	
	public void salvar(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}

	public void atualizar(AgendamentoEmail agendamentoEmail) {
		entityManager.merge(agendamentoEmail);
	}
	
	public boolean existeEmailCadastrado(String email) {
		String sql = "select count(ae) from AgendamentoEmail ae where ae.email = :email and ae.enviado = false";
		TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
		query.setParameter("email", email);
		Long result = query.getSingleResult();
		return result > 0;
	}
	
}
