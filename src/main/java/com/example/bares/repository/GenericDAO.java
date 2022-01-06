/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bares.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author lsuares
 * 
 * @param <E> Entidad Persistente
 */
@NoRepositoryBean
public interface GenericDAO<E> extends CrudRepository<E, Long>{
    Page<E> findAll(Pageable pageable);
    
}
