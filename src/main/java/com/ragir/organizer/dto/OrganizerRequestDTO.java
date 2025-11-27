package com.ragir.organizer.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class OrganizerRequestDTO {

    @NotBlank(message = "Name required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank
    private String email;

    @NotBlank(message = "Phone required")
    private String phone;

    @NotBlank
    private String businessType;
}
