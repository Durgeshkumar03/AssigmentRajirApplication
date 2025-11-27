package com.ragir.organizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ragir.organizer.dto.OrganizerRequestDTO;
import com.ragir.organizer.dto.OrganizerResponseDTO;
import com.ragir.organizer.service.OrganizerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {

	@Autowired
    private OrganizerService service;

	@PostMapping
	public ResponseEntity<List<OrganizerResponseDTO>> create(@RequestBody List<OrganizerRequestDTO> dtos) {
	    return ResponseEntity.status(201).body(service.createOrganizer(dtos));
	}


    @GetMapping("/{id}")
    public ResponseEntity<OrganizerResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrganizerById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrganizerResponseDTO>> search(@RequestParam String q) {
        return ResponseEntity.ok(service.searchOrganizer(q));
    }
}