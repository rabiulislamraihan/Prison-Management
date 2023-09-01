/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author calsifer
 */
public abstract class User implements Serializable{
    protected int id;
    protected String name;
    protected String password;
    public String userType;

    public User(int id, String name, String password, String userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }


    
}
