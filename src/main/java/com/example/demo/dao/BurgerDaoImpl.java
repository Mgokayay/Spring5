package com.example.demo.dao;

import com.example.demo.entity.BreadType;
import com.example.demo.entity.Burger;
import com.example.demo.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public class BurgerDaoImpl implements BurgerDao{

    private final EntityManager entityManager;
    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) {
        Burger burger = entityManager.find(Burger.class, id);
        if(burger == null){
            throw new BurgerException("Burger is not found with given id "+id, HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> foundAll = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return foundAll.getResultList();
    }
    @Transactional
    @Override
    public Burger update(Burger burger) {

        return entityManager.merge(burger);
    }
    @Transactional
    @Override
    public Burger remove(Long id) {
        Burger found = findById(id);
        entityManager.remove(found);
        return null;
    }

    @Override
    public List<Burger> findByPrice(Integer price) {
        TypedQuery<Burger> findByPriceQuery= entityManager.createQuery("SELECT b FROM Burger b WHERE b.price :price ORDER BY b.price desc",Burger.class);
        findByPriceQuery.setParameter("price",price);
        return findByPriceQuery.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> findByBreadType = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType=:breadType ORDER BY b.name desc", Burger.class);
        findByBreadType.setParameter("breadType",breadType);

        return findByBreadType.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> findByContentQuery = entityManager.createQuery("SELECT b FROM Burger b WHERE contents LIKE CONCAT('½',:content,'½')", Burger.class);
        findByContentQuery.setParameter("content",content);
        return findByContentQuery.getResultList();
    }
}
