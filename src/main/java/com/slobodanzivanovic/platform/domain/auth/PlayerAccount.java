package com.slobodanzivanovic.platform.domain.auth;

import com.slobodanzivanovic.platform.domain.common.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDate;

/**
 * Represents the core identity, authentication credentials, and private PII
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@Entity
@Table(name = "player_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PlayerAccount extends BaseModel {

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Private PII (Identity and Validation)

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    // TODO: revisit timezone, find proper way for doing it
    private String timezone;

    // TODO: revisit
    @Column(nullable = false)
    @Builder.Default
    private Boolean isVerified = false;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isBanned = false;

    private Instant lastLoginAt;
}
