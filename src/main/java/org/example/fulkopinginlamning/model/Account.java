package org.example.fulkopinginlamning.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "DBAccount")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column (nullable = false)
    private String firstname;
    private String lastname;
    private String country;
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date changed;

    public Account(){
        created = new Date();
        changed = new Date();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getChanged() {
        return changed;
    }

    public void setChanged(Date changed) {
        this.changed = changed;
    }

    @Override
    public String toString() {
        return "Account{" +
                "authorId=" + authorId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", created=" + created +
                ", changed=" + changed +
                '}';
    }
}
