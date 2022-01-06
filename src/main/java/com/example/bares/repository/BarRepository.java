/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bares.repository;

import com.example.bares.models.Bar;
import org.springframework.stereotype.Service;

/**
 *
 * @author lsuares
 */
@Service
public interface BarRepository<E> extends GenericDAO<Bar>{
    
}