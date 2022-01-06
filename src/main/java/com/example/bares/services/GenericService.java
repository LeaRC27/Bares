/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bares.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author lsuares
 * 
 * @param <E> Entidad Persistente
 */
public interface GenericService <E> {
        
    Page<E> findAll(Pageable pageable);    

}
