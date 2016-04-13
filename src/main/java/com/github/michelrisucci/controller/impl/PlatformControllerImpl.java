package com.github.michelrisucci.controller.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.michelrisucci.controller.PlatformController;
import com.github.michelrisucci.jsf.model.Platform;
import com.github.michelrisucci.repository.PlatformRepository;

/**
 * @author Michel Risucci
 */
@Named
public class PlatformControllerImpl implements PlatformController {

	@Inject
	private PlatformRepository repository;

	@Override
	public List<Platform> list() {
		return repository.list();
	}

	@Override
	public Platform read(Long id) {
		return repository.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Platform platform) {
		repository.create(platform);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Platform update(Platform platform) {
		return repository.update(platform);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Platform platform) {
		repository.delete(platform);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		repository.delete(id);
	}

}