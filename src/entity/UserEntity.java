/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author Jonas
 */
@Entity
public class UserEntity extends UserFrame
{
    String email;
    
    public UserEntity() {
        
    }
    
    public UserEntity(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "user = "+super.getUserName()+", password = "+super.getPassword()+", email = "+email;
    }
}
