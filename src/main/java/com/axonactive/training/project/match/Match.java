package com.axonactive.training.project.match;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.axonactive.training.project.team.Team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_team_a")
    private Team teamA;

    @ManyToOne
    @JoinColumn(name = "id_team_b")
    private Team teamB;

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

}

