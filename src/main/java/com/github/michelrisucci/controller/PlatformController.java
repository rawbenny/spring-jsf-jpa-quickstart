package com.github.michelrisucci.controller;

import java.util.List;

import com.github.michelrisucci.jsf.model.Platform;

/**
 * @author Michel Risucci
 */
public interface PlatformController {

	/**
	 * @return mock list of codes
	 */
	List<Platform> list();

	/**
	 * Reads a {@link Platform}
	 * 
	 * @param id
	 * @return
	 */
	Platform read(Long id);

	/**
	 * Creates a new {@link Platform}
	 * 
	 * @param platform
	 */
	void create(Platform platform);

	/**
	 * Updates a {@link Platform} and returns the updated one
	 * 
	 * @param platform
	 * @return
	 */
	Platform update(Platform platform);

	/**
	 * Deletes a {@link Platform}.
	 * 
	 * @param platform
	 */
	void delete(Platform platform);

	/**
	 * Deletes a {@link Platform}.
	 * 
	 * @param id
	 */
	void delete(Long id);

}