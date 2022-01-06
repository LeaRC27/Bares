/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bares.services;

import com.example.bares.repository.GenericDAO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author lsuares
 */
@Service
public abstract class GenericServiceImpl<E> implements GenericService<E>{

    @Autowired
    private GenericDAO<E> dao;
    
    public Optional<E> findById(Long id) {
        return dao.findById(id);
    }

    public E save(E entity){
        return dao.save(entity);
    }

    public Iterable<E> findAll() {
        return dao.findAll();
    }    

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public void delete(E entity) {
        dao.delete(entity);
    }    

    @Override
    public Page<E> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }   
    
}
