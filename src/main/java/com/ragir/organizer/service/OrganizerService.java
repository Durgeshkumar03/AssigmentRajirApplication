package com.ragir.organizer.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.ragir.organizer.dto.OrganizerRequestDTO;
import com.ragir.organizer.dto.OrganizerResponseDTO;

public interface OrganizerService {
	
	List<OrganizerResponseDTO> createOrganizer(List<OrganizerRequestDTO> dtos);
	
	public OrganizerResponseDTO getOrganizerById(Long id);
	
	List<OrganizerResponseDTO> searchOrganizer(String query);

	
	

}
