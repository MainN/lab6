package com.example.service;

import com.example.pojo.Fisherman;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class FishermanService {

    @Inject
    EntityManager entityManager;

    // Вставка рыбака
    @Transactional
    public Fisherman insertFisherman(Fisherman fisherman) {
        entityManager.persist(fisherman);
        entityManager.flush();
        return fisherman;
    }
    //  Обновить рыбака
    @Transactional
    public Fisherman updateFisherman(Fisherman fisherman) {
        entityManager.merge(fisherman);
        entityManager.flush();
        return fisherman;
    }
    //  Получить всех рыбаков
    @Transactional
    public List<Fisherman> getFishermen() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fisherman> cq = cb.createQuery(Fisherman.class);
        Root<Fisherman> rootEntry = cq.from(Fisherman.class);
        CriteriaQuery<Fisherman> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }
    //  Удалить рыбака
    @Transactional
    public Fisherman deleteFisherman(Fisherman fisherman) {
        entityManager.remove(fisherman);
        entityManager.flush();
        return fisherman;
    }
    //  Инициализация
    public Fisherman initFisherman() {
        Fisherman fisherman = new Fisherman();
        fisherman.setLogin("test1");
        fisherman.setAddress("Rybinsk city");
        fisherman.setFio("Ivanov Ivan Ivanovich");
        fisherman.setSex("male");
        fisherman.setBirthDate(new Date());
        fisherman.setPhoneNumber("123-1314-32");
        return fisherman;
    }
}
