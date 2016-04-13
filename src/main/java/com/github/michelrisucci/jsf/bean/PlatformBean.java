package com.github.michelrisucci.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.github.michelrisucci.controller.PlatformController;
import com.github.michelrisucci.jsf.model.Platform;
import com.github.michelrisucci.jsf.util.FacesUtils;

@ManagedBean
@ViewScoped
public class PlatformBean extends SpringBeanAutowiringSupport {
	protected static final Log log = LogFactory.getLog(PlatformBean.class);

	@Inject
	private PlatformController controller;

	private String state;
	private List<Platform> items;
	private Platform item;

	/**
	 * 
	 */
	public PlatformBean() {
		log.info("Bean constructor called.");
	}

	/**
	 * 
	 */
	@PostConstruct
	private void postConstruct() {
		log.info("Bean @PostConstruct called.");
		state = "READ";
		items = controller.list();
	}

	/**
	 * Clears entity items
	 */
	public void clearItems() {
		if (items != null) {
			items.clear();
		}
	}

	/**
	 * Clears entity item
	 */
	public void clearItem() {
		try {
			// Instantiating via reflection was used here for generic purposes
			item = Platform.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			FacesUtils.addI18nError("generic.bean.unableToCleanViewData");
		}
	}

	/**
	 * @param event
	 */
	public void create() {
		controller.create(item);
		items = controller.list();
		item = null;
	}

	/**
	 * @param event
	 */
	public void update() {
		controller.update(item);
		items = controller.list();
		item = null;
	}

	public void delete() {
		controller.delete(item.getId());
		items = controller.list();
		item = null;
	}

	/**
	 * 
	 */
	@PreDestroy
	private void preDestroy() {
		log.info("Bean @PreDestroy called.");
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Platform> getItems() {
		return items;
	}

	public void setItems(List<Platform> items) {
		this.items = items;
	}

	public Platform getItem() {
		return item;
	}

	public void setItem(Platform item) {
		this.item = item;
	}
}
