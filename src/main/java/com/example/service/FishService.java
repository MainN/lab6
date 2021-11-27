package com.example.service;

import com.example.pojo.Fish;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FishService {

    @Inject
    EntityManager entityManager;

    // Вставка рыбы
    @Transactional
    public Fish insertFish(Fish fish) {
        entityManager.persist(fish);
        entityManager.flush();
        return fish;
    }
    //  Обновить рыбу
    @Transactional
    public Fish updateFish(Fish fish) {
        entityManager.merge(fish);
        entityManager.flush();
        return fish;
    }
    //  Получить всех рыб
    @Transactional
    public List<Fish> getFishes() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fish> cq = cb.createQuery(Fish.class);
        Root<Fish> rootEntry = cq.from(Fish.class);
        CriteriaQuery<Fish> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }
    //  Удалить рыбу
    @Transactional
    public Fish deleteFish(Fish fish) {
        entityManager.remove(fish);
        entityManager.flush();
        return fish;
    }
    //  Инициализация
    public Fish initFish() {
        Fish fish = new Fish();
        fish.setName("Карась");
        fish.setKind("Карповые");
        fish.setDepth(0.5);
        fish.setWeight(1.5);
        return fish;
    }
}
