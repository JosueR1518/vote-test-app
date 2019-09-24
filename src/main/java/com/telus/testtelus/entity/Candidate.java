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
@Table(name = "candidate")
@NamedQueries({
    @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
    @NamedQuery(name = "Candidate.findById", query = "SELECT c FROM Candidate c WHERE c.id = :id"),
    @NamedQuery(name = "Candidate.findByIdDocument", query = "SELECT c FROM Candidate c WHERE c.idDocument = :idDocument"),
    @NamedQuery(name = "Candidate.findByName", query = "SELECT c FROM Candidate c WHERE c.name = :name"),
    @NamedQuery(name = "Candidate.findBySurname", query = "SELECT c FROM Candidate c WHERE c.surname = :surname"),
    @NamedQuery(name = "Candidate.findByEmail", query = "SELECT c FROM Candidate c WHERE c.email = :email")})
public class Candidate implements Serializable {

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
    @JoinColumn(name = "committee_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Committee committeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId", fetch = FetchType.LAZY)
    private List<Vote> voteList;

    public Candidate() {
    }

    public Candidate(Integer id) {
        this.id = id;
    }

    public Candidate(Integer id, int idDocument, String name, String surname, String email) {
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

    public Committee getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Committee committeeId) {
        this.committeeId = committeeId;
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
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.testtelus.entity.Candidate[ id=" + id + " ]";
    }
    
}
