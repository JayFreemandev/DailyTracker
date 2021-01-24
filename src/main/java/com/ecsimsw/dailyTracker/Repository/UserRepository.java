package com.ecsimsw.dailyTracker.Repository;

import com.ecsimsw.dailyTracker.Domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional()
public class UserRepository {
    private final EntityManager em;

    public void save(User user) {
        if (user.getId() != null) {
            em.merge(user);
            return;
        }
        em.persist(user);
    }

    public User findByName(String name) {
        List<User> result = em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();

        if (result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }
}
