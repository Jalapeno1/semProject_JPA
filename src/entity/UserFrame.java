/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Jonas
 */
@Entity
public class UserFrame implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    String userName;
    String password;
    
    @OneToOne(mappedBy = "user")
    private Collection<UserEntity> user;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Collection<UserEntity> getUser(){
        return user;
    }
    
    public void setUser(Collection<UserEntity> user){
        this.user = user;
    }
    
    public void addUser(UserEntity users) {
        user.add(users);
    }
    
    public UserFrame(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public UserFrame(){
        
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFrame))
        {
            return false;
        }
        UserFrame other = (UserFrame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.UserFrame[ id=" + id + " ]";
    }
    
}
