package com.axonactive.training.project.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.axonactive.training.project.player.Player;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_team")
public class Team {

    public static final String COMPANY_SOCIAL_INSURANCE_NUMBER = "";

    public static final int MAXIMUN_SIZE = 12;

    public static final int MINIMUN_SIZE = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private int score;
    
    @OneToMany
    @JoinColumn(name = "id_team")
    private List<Player> players = new ArrayList<>();

    public Team(String name, int score, List<Player> players) {
        this.name = name;
        this.score = score;
        this.players = players;
    }   

    public boolean isEnoughPlayer() {
        return (this.players.size() > MINIMUN_SIZE);
    }

    public void addPlayer(Player player) {
        if (players.size() < Team.MAXIMUN_SIZE) {
            if (player.isWorkForCompany()) {
                players.add(player);
            } else
                throw new IllegalArgumentException("This player do not work for this company");
        } else
            throw new IllegalArgumentException("Size of team is max");
    }


}


