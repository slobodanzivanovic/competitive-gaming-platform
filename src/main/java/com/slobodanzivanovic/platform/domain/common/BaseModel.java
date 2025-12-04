package com.slobodanzivanovic.platform.domain.common;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * Base entity class with UUID primary key.
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(of = "id", callSuper = false)
public abstract class BaseModel extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
