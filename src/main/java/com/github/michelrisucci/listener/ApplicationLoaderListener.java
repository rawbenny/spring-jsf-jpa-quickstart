package com.github.michelrisucci.listener;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.michelrisucci.jsf.model.Country;
import com.github.michelrisucci.jsf.model.Platform;

/**
 * Spring application context loader that checks if database has initial data.
 * If not, it fills database with some mock data.
 * 
 * @author Michel Risucci
 */
@Named
public class ApplicationLoaderListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void onApplicationEvent(ContextRefreshedEvent event) {
		checkDatabase();
	}

	private void checkDatabase() {
		StringBuilder jpql = new StringBuilder() //
				.append("SELECT COUNT(x) ") //
				.append("FROM " + Country.class.getSimpleName() + " x ");

		TypedQuery<Number> query = em
				.createQuery(jpql.toString(), Number.class);

		long count = query.getSingleResult().longValue();
		if (count == 0) {
			initializeDatabaseWithMockData();
		}

		jpql = new StringBuilder()//
				.append("select count(x) ")//
				.append("from " + Platform.class.getSimpleName() + " x ");
		query = em.createQuery(jpql.toString(), Number.class);

		count = query.getSingleResult().longValue();
		if (count == 0) {
			initPlatform();
		}
	}

	/**
	 * 
	 */
	private void initializeDatabaseWithMockData() {
		List<Country> countries = Arrays.asList( //
				new Country("Brazil", "BRA", 200_000_000l), //
				new Country("United States", "USA", 315_000_000l), //
				new Country("Argentina", "ARG", 42_000_000l), //
				new Country("China", "CHN", 1_350_000_000l), //
				new Country("India", "IND", 1_250_000_000l));

		for (Country country : countries) {
			em.persist(country);
		}

	}

	private void initPlatform() {
		Platform platform = new Platform("ABC", "12312", 11, "12312312", "");
		em.persist(platform);
	}

}