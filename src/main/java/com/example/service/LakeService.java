package com.example.service;

import com.example.pojo.Lake;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LakeService {

    @Inject
    EntityManager entityManager;

    // Вставка озера
    @Transactional
    public Lake insertLake(Lake lake) {
        entityManager.persist(lake);
        entityManager.flush();
        return lake;
    }
    //  Обновить озеро
    @Transactional
    public Lake updateLake(Lake lake) {
        entityManager.merge(lake);
        entityManager.flush();
        return lake;
    }
    //  Получить все озера
    @Transactional
    public List<Lake> getLakes() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lake> cq = cb.createQuery(Lake.class);
        Root<Lake> rootEntry = cq.from(Lake.class);
        CriteriaQuery<Lake> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }
    //  Удалить озеро
    @Transactional
    public Lake deleteLake(Lake lake) {
        entityManager.remove(lake);
        entityManager.flush();
        return lake;
    }
    //  Инициализация
    public Lake initLake() {
        Lake lake = new Lake();
        lake.setName("Байкал");
        lake.setArea(31722.0);
        lake.setDepth(1642.0);
        return lake;
    }
}
