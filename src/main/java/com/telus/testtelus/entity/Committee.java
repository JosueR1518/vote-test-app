/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telus.testtelus.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jaml
 */
@Entity
@Table(name = "committee")
@NamedQueries({
    @NamedQuery(name = "Committee.findAll", query = "SELECT c FROM Committee c"),
    @NamedQuery(name = "Committee.findById", query = "SELECT c FROM Committee c WHERE c.id = :id"),
    @NamedQuery(name = "Committee.findByName", query = "SELECT c FROM Committee c WHERE c.name = :name")})
public class Committee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "committeeId", fetch = FetchType.EAGER)
    private List<Candidate> candidateList;
    @JoinColumn(name = "deparment_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Department departmentId;

    public Committee() {
    }

    public Committee(Integer id) {
        this.id = id;
    }

    public Committee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department deparmentId) {
        this.departmentId = deparmentId;
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
        if (!(object instanceof Committee)) {
            return false;
        }
        Committee other = (Committee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.testtelus.entity.Committee[ id=" + id + " ]";
    }
    
}
