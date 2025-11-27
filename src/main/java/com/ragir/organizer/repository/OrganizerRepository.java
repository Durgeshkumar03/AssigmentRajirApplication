package com.ragir.organizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragir.organizer.entity.Organizer;

public interface OrganizerRepository extends
JpaRepository<Organizer, Long>{
	
	boolean existsByEmail(String email);
	
	@Query("SELECT o FROM Organizer o WHERE " +
            "LOWER(o.name) LIKE LOWER(CONCAT('%', :q, '%')) OR " +
            "LOWER(o.email) LIKE LOWER(CONCAT('%', :q, '%')) OR " +
            "LOWER(o.phone) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<Organizer> search(String q);
			 

}
