package com.ecsimsw.dailyTracker.Repository;

import com.ecsimsw.dailyTracker.Domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(User user){
        if(user.getId() != null){
            em.merge(user);
            return;
        }
        em.persist(user);
    }

    public User findByName(String name){
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
