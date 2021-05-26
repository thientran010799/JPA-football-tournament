package com.axonactive.training.project.resutl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.axonactive.training.project.match.Match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_result")
public class Result {

    public Result(Match match, int scoreOfTeamA, int scoreOfTeamB) {
        this.match = match;
        this.scoreOfTeamA = scoreOfTeamA;
        this.scoreOfTeamB = scoreOfTeamB;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_team_a")
    private Match match;

    @Column
    private int scoreOfTeamA;

    @Column
    private int scoreOfTeamB;
}