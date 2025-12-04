package com.slobodanzivanovic.platform.domain.player;

import com.slobodanzivanovic.platform.domain.auth.PlayerAccount;
import com.slobodanzivanovic.platform.domain.common.BaseAudit;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents the public profile (The "Player").
 *
 * <p>It uses the same UUID primary key as PlayerAccount via @MapsId for performance.
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@Entity
@Table(name = "player_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PlayerProfile extends BaseAudit {

    // PK is also the FK to PlayerAccount
    @Id
    @Column(name = "player_id")
    private UUID id;

    // Relationship: @MapsId is the performance best practice for 1:1 shared primary keys
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "player_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private PlayerAccount account;

    // Public Profile Data

    private String username;

    private String steamId;

    private String avatarUrl;

    private String country;

    // TODO: revisit, do we need this in public data, or we should have account created etc. but we have audit already, anyway revisit
    private Instant steamLinkedAt;

    // Summary fields for quick loading, calculated/synced from competitive tables
    private Integer totalMatchesPlayed;

    @Column(columnDefinition = "numeric(5,2)")
    private Double globalKdaRatio;
}
