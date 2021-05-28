package com.axonactive.training.project.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import lombok.Getter;

@Getter
public class TeamService {

    @PersistenceContext
    private EntityManager entityManager;

    // private List<Team> teams = new ArrayList<>();

    public void addTeam(Team team) {
        this.entityManager.persist(team);
    }

    public void update(Team team) {
        if (team.getId() == null) {
            throw new IllegalArgumentException("Team is missing");
        }
        Team persitedTeam = this.entityManager.find(Team.class, team.getId());
        persitedTeam.setName(team.getName());
        persitedTeam.setScore(team.getScore());
        persitedTeam.setPlayers(team.getPlayers());
        this.entityManager.merge(persitedTeam);
    }

    public void delete(Long id) {
        this.entityManager.remove(this.entityManager.find(Team.class, id));
    }

    public Team findById(Long id) {
        return this.entityManager.find(Team.class, id);
    }

    public List<Team> findAll() {
        TypedQuery<Team> query = this.entityManager.createNamedQuery(Team.GET_ALL_QUERY, Team.class);
        return query.getResultList();
    }

    // public void register(Team team) {
    //     if (team.isEnoughPlayer()) {
    //         teams.add(team);
    //     } else
    //         throw new IllegalArgumentException("Your team is not enough player");
    // }

    // public List<Team> getAllTeam() {
    //     return this.teams;
    // }
}