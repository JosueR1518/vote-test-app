/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telus.testtelus.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jaml
 */
@Entity
@Table(name = "visitor_counter", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"Date"})})
@NamedQueries({
    @NamedQuery(name = "VisitorCounter.findAll", query = "SELECT v FROM VisitorCounter v"),
    @NamedQuery(name = "VisitorCounter.findById", query = "SELECT v FROM VisitorCounter v WHERE v.id = :id"),
    @NamedQuery(name = "VisitorCounter.findByDate", query = "SELECT v FROM VisitorCounter v WHERE v.date = :date"),
    @NamedQuery(name = "VisitorCounter.findByQuantity", query = "SELECT v FROM VisitorCounter v WHERE v.quantity = :quantity")})
public class VisitorCounter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Date", nullable = false, length = 45)
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity", nullable = false)
    private int quantity;

    public VisitorCounter() {
    }

    public VisitorCounter(Integer id) {
        this.id = id;
    }

    public VisitorCounter(Integer id, String date, int quantity) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitorCounter)) {
            return false;
        }
        VisitorCounter other = (VisitorCounter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.testtelus.entity.VisitorCounter[ id=" + id + " ]";
    }
    
}
