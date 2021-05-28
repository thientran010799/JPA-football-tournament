package com.axonactive.training.project.player;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.axonactive.training.project.team.Team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tbl_player")
@NamedQueries({ @NamedQuery(name = Player.GET_ALL_QUERY, query = "SELECT s FROM Player s") })
public class Player {

    public static final String QUALIFIER = "com.axonactive.training.footballproject.player";

    public static final String GET_ALL_QUERY = QUALIFIER + "getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Convert(converter = GenderPersistenceConverter.class)
    private Gender gender = Gender.UNKNOWN;

    @Column(name = "socialInsuranceNumber", length = 20, nullable = true)
    private String socialInsuranceNumber;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team playFor;

    public Player(String name, Gender gender, String socialInsuranceNumber, Team playFor) {
        this.name = name;
        this.gender = gender;
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.playFor = playFor;
    }



    public boolean isWorkForCompany() {
        return true;
    }
}
