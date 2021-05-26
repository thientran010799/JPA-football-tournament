package com.axonactive.training.project.player;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class PlayerService {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Player player) {
        this.entityManager.persist(player);
    }

    public void update(Player player) {
        if (player.getId() == null) {
            throw new IllegalArgumentException("Player is missing");
        }
        Player persitedPlayer = this.entityManager.find(Player.class, player.getId());
        persitedPlayer.setName(player.getName());
        persitedPlayer.setGender(player.getGender());
        persitedPlayer.setSocialInsuranceNumber(player.getSocialInsuranceNumber());
        this.entityManager.merge(persitedPlayer);
    }

    public void delete(Long id) {
        this.entityManager.remove(this.entityManager.find(Player.class, id));
    }

    public Player find(Long id) {
        return this.entityManager.find(Player.class, id);
    }
    
    public List<Player> findAll() {
        TypedQuery<Player> query = this.entityManager.createNamedQuery(Player.GET_ALL_QUERY, Player.class);
        return query.getResultList();
    }

}
