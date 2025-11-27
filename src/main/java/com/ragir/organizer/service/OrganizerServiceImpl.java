package com.ragir.organizer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ragir.organizer.dto.OrganizerRequestDTO;
import com.ragir.organizer.dto.OrganizerResponseDTO;
import com.ragir.organizer.entity.Organizer;
import com.ragir.organizer.repository.OrganizerRepository;
import com.ragir.organizer.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

    private final OrganizerRepository repository;

    @Override
    public List<OrganizerResponseDTO> createOrganizer(List<OrganizerRequestDTO> dtos) {

        return dtos.stream().map(dto -> {

            if (repository.existsByEmail(dto.getEmail())) {
                throw new RuntimeException("Email already exists: " + dto.getEmail());
            }

            long count = repository.count() + 1;
            String code = String.format("ORG%05d", count);

            Organizer organizer = Organizer.builder()
                    .organizerCode(code)
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .phone(dto.getPhone())
                    .businessType(dto.getBusinessType())
                    .status(Organizer.Status.ACTIVE)
                    .build();

            repository.save(organizer);

            return mapToDTO(organizer);

        }).toList();
    }


    @Override
    public OrganizerResponseDTO getOrganizerById(Long id) {
        Organizer organizer = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));
        return mapToDTO(organizer);
    }

    @Override
    public List<OrganizerResponseDTO> searchOrganizer(String q) {
        List<Organizer> list = repository.search(q);
        return list.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private OrganizerResponseDTO mapToDTO(Organizer org) {
        return OrganizerResponseDTO.builder()
                .id(org.getId())
                .organizerCode(org.getOrganizerCode())
                .name(org.getName())
                .email(org.getEmail())
                .phone(org.getPhone())
                .businessType(org.getBusinessType())
                .status(org.getStatus().name())
                .createdAt(org.getCreatedAt())
                .updatedAt(org.getUpdatedAt())
                .build();
    }
}
