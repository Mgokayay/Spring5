package com.example.demo.controller;

import com.example.demo.dao.BurgerDao;
import com.example.demo.entity.BreadType;
import com.example.demo.entity.Burger;
import com.example.demo.util.BurgerValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/burger")
@AllArgsConstructor
public class BurgerController {

    private final BurgerDao burgerDao;


    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id){
        return burgerDao.findById(id);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger){
        return  burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreatType(@PathVariable String breadType){
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(bt);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
}
