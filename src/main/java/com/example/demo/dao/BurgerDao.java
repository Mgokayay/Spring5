package com.example.demo.dao;

import com.example.demo.entity.BreadType;
import com.example.demo.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);

    Burger findById(Long id);

    List<Burger> findAll();

    Burger update(Burger burger);

    Burger remove(Long id);

    List<Burger> findByPrice(Integer price);

    List<Burger> findByBreadType(BreadType breadType);

    List<Burger> findByContent(String content);


}
