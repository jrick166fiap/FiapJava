package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		return em.createQuery("from Usuario u where u.nome like :n",
			Usuario.class).setParameter("n", "%"+nome+"%").getResultList();
	}

	@Override
	public List<String> completarPorNome(String texto) {
		// TODO Auto-generated method stub
		TypedQuery<String> query = em.createQuery("select u.nome from Usuario u where"
				+" upper(u.nome) "
				+"like upper(:nome)",String.class);
		query.setParameter("nome", "%"+texto+"%");
		
		return query.getResultList();
	}

	@Override
	public long buscarPorNivel(int nivel) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(u) from Usuario u where"
				+" u.nivel = :n",Long.class).setParameter("n", nivel).getSingleResult();
	}

	@Override
	public long contarPorMesAniversario(int mes) {
		// TODO Auto-generated method stub
		return em.createQuery("select count(u) from Usuario u"
				+" where month(u.dataNascimento) = :m",Long.class)
				.setParameter("m", mes)
				.getSingleResult();
	}

}
