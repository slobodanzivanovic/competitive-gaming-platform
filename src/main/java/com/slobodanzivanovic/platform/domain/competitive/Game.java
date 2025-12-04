package com.slobodanzivanovic.platform.domain.competitive;

import com.slobodanzivanovic.platform.domain.common.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Represents a competitive game supported by the platform.
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Game extends BaseModel {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String shortCode;
}
