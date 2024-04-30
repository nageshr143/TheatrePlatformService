package com.sapient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sapient.entity.TheatrePlatform;

@Repository
public interface TheatrePlatformRepository extends JpaRepository<TheatrePlatform, Long> {

	
	
}
