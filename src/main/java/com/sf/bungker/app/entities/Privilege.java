package com.sf.bungker.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Privilege implements Serializable {
    private static final long serialVersionUID = 2219784472971192984L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @ManyToMany(mappedBy = "privileges")
    @JsonIgnore
    private Collection<Role> roles;

    public Privilege()
    {
    }

    public Privilege(String name)
    {
        this.name = name;
    }


    public Privilege(String name, Collection<Role> roles)
    {
        this.name = name;
        this.roles = roles;
    }

    

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
