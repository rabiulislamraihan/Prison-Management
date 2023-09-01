/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package securityincharge;

import java.io.Serializable;

/**
 *
 * @author calsifer
 */
abstract class User implements Serializable{
    protected int id;
    protected String name;
    protected String password;
    protected String userType;

    public User(int id, String name, String password, String userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", password=" + password + ", userType=" + userType ;
    }
}
