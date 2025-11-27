package com.ragir.organizer.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizerResponseDTO {
    private Long id;
    private String organizerCode;
    private String name;
    private String email;
    private String phone;
    private String businessType;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

