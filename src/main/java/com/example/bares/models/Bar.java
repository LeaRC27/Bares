/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bares.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author lsuares
 */
@Entity
@Table
public class Bar implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "domicilio")
    private String domicilio;
    
    @Column(name = "puntuacion")
    @Min(1)
    @Max(5)
    private Integer puntuacion;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "telefono")
    private String tel;
    
    @Column(name = "cuil", unique=true)
    private String cuit;
    
    @Column(name = "horario")
    private String horario;
    
    @Column(name = "estacionamiento")
    private Boolean estacionamiento;

    public Bar() {
    }

    public Bar(String nombre, String domicilio, Integer puntuacion, String email, String tel, String cuit, String horario, Boolean estacionamiento) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.puntuacion = puntuacion;
        this.email = email;
        this.tel = tel;
        this.cuit = cuit;
        this.horario = horario;
        this.estacionamiento = estacionamiento;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Boolean getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Boolean estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.domicilio);
        hash = 71 * hash + Objects.hashCode(this.puntuacion);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.tel);
        hash = 71 * hash + Objects.hashCode(this.cuit);
        hash = 71 * hash + Objects.hashCode(this.horario);
        hash = 71 * hash + Objects.hashCode(this.estacionamiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bar other = (Bar) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.domicilio, other.domicilio)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.cuit, other.cuit)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.puntuacion, other.puntuacion)) {
            return false;
        }
        if (!Objects.equals(this.estacionamiento, other.estacionamiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bar{" + "id=" + id + ", nombre=" + nombre + ", domicilio=" + domicilio + ", puntuacion=" + puntuacion + ", email=" + email + ", tel=" + tel + ", cuit=" + cuit + ", horario=" + horario + ", estacionamiento=" + estacionamiento + '}';
    }
    
}
