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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jaml
 */
@Entity
@Table(name = "voter", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "Voter.findAll", query = "SELECT v FROM Voter v"),
    @NamedQuery(name = "Voter.findById", query = "SELECT v FROM Voter v WHERE v.id = :id"),
    @NamedQuery(name = "Voter.findByIdDocument", query = "SELECT v FROM Voter v WHERE v.idDocument = :idDocument"),
    @NamedQuery(name = "Voter.findByName", query = "SELECT v FROM Voter v WHERE v.name = :name"),
    @NamedQuery(name = "Voter.findBySurname", query = "SELECT v FROM Voter v WHERE v.surname = :surname"),
    @NamedQuery(name = "Voter.findByEmail", query = "SELECT v FROM Voter v WHERE v.email = :email")})
public class Voter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_document", nullable = false)
    private int idDocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "surname", nullable = false, length = 250)
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country countryId;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voterId", fetch = FetchType.LAZY)
    private List<Vote> voteList;

    public Voter() {
    }

    public Voter(Integer id) {
        this.id = id;
    }

    public Voter(Integer id, int idDocument, String name, String surname, String email) {
        this.id = id;
        this.idDocument = idDocument;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
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
        if (!(object instanceof Voter)) {
            return false;
        }
        Voter other = (Voter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "Voter [id=" + id + ", idDocument=" + idDocument + ", name=" + name + ", surname=" + surname + ", email="
				+ email + ", countryId=" + countryId + ", userId=" + userId +  "]";
	}
    
    
    
    
}
