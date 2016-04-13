package com.github.michelrisucci.repository.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.michelrisucci.jsf.model.Platform;
import com.github.michelrisucci.repository.PlatformRepository;

@Named
public class PlatformRepositoryImpl implements PlatformRepository {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<Platform> list() {
		StringBuilder jpql = new StringBuilder().append("select x ")
				.append("from " + Platform.class.getName() + " x ")
				.append("order by x.id asc");

		return em.createQuery(jpql.toString(), Platform.class).getResultList();
	}

	@Override
	public Platform read(Long id) {
		return em.find(Platform.class, id);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(Platform platform) {
		em.persist(platform);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Platform update(Platform platform) {
		return em.merge(platform);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Platform platform) {
		em.remove(platform);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Long id) {
		Platform platform = em.getReference(Platform.class, id);
		delete(platform);
	}
}
