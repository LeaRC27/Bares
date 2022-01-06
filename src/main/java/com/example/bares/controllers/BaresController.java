/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bares.controllers;

import com.example.bares.models.Bar;
import com.example.bares.services.BarService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lsuares
 */
@RestController
public class BaresController {
    
    @Autowired
    private BarService barService;
    
    @GetMapping(value="bares/{id}")
    public ResponseEntity<Object> getBares(@PathVariable Long id){
        return new ResponseEntity<>(barService.findById(id), HttpStatus.OK);
    }
    
    @GetMapping(value="bares")
    public ResponseEntity getBares(@PageableDefault(size=20,page=0)@SortDefault(sort = "id", direction = Sort.Direction.ASC)Sort sort, Pageable pageable){
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),sort);
        Page<Bar> res = barService.findAll(pageRequest);
        return new ResponseEntity<>(new PageImpl<>(res.getContent(),pageRequest,res.getTotalElements()), HttpStatus.OK );
    }
    
    @PostMapping(value="bares", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBar(@RequestBody Bar bar){
        try{
            Bar saveBar;
            saveBar = barService.save(bar);
            if(saveBar == null)
                return new ResponseEntity<>(Bar.class.getName()+" no pudo ser guardado",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(saveBar , HttpStatus.OK);
        }catch(DataIntegrityViolationException e){
            if(e.getCause() instanceof ConstraintViolationException)
                return new ResponseEntity<>("Ya existe",HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(e.getMostSpecificCause().getMessage(),HttpStatus.NOT_FOUND); 
        }               
    }
    
    @DeleteMapping(value="bares/{id}")
    public ResponseEntity deleteBar(@PathVariable Long id){
        try{
            barService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
