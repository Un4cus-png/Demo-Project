package com.example.demo.Entity;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.validation.constraints.Pattern;
import javax.management.relation.Role;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only letters")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$",
            message = "Password must be at least 8 characters long and include at least one uppercase letter, one number, and one special character"
    )
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role roles;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
