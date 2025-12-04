package com.slobodanzivanovic.platform.domain.competitive;

import com.slobodanzivanovic.platform.domain.common.BaseModelLong;
import com.slobodanzivanovic.platform.domain.player.PlayerProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

/**
 * Stores the competitive rating for a player in a specific game.
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@Entity
@Table(name = "player_ratings", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"player_id", "game_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PlayerRating extends BaseModelLong {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerProfile player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(nullable = false)
    @Builder.Default
    private Integer elo = 1000;

    @Column(nullable = false, columnDefinition = "numeric(5,2)")
    @Builder.Default
    private Double ratingDeviation = 350.0;

    // TODO: create enum for this, I don't think this is clean (WHOLE ENTITY)
    @Column(nullable = false)
    @Builder.Default
    private String rankTier = "Bronze I";

    @Column(nullable = false)
    @Builder.Default
    private Integer rankLevel = 1;

    private Instant lastPlayedAt;
}
