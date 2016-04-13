package com.github.michelrisucci.repository;

import java.util.List;

import com.github.michelrisucci.jsf.model.Platform;

public interface PlatformRepository {

	List<Platform> list();
	
	Platform read(Long id);
	
	void create(Platform platform);
	
	Platform update(Platform platform);
	
	void delete(Platform platform);
	
	void delete(Long id);
}
