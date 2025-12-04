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

/**
 * Stores aggregated, season-specific match statistics for a player in a specific game.
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@Entity
@Table(name = "player_season_stats", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"player_id", "game_id", "season_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PlayerSeasonStats extends BaseModelLong {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerProfile player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    // Performance Metrics

    @Column(nullable = false)
    @Builder.Default
    private Integer matchesPlayed = 0;

    @Column(nullable = false)
    @Builder.Default
    private Integer matchesWon = 0;

    @Column(nullable = false)
    @Builder.Default
    private Long totalKills = 0L;

    @Column(nullable = false)
    @Builder.Default
    private Long totalDeaths = 0L;

    @Column(nullable = false)
    @Builder.Default
    private Long totalAssists = 0L;

    // NOTE: Store as a cache, often calculated
    @Column(columnDefinition = "numeric(5,2)")
    @Builder.Default
    private Double kdaRatio = 0.00;

    @Column(columnDefinition = "numeric(5,2)")
    @Builder.Default
    private Double winRate = 0.00;
}
