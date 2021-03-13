/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author HELA
 */
public class Users {
    private int user_id;
    private String nom;
    private String prenom;
    private String username;
    private int password;
    private String role;
    private String adresse;
    private int num_tel;
    private String email;
    private String image; 

    public Users( String nom, String prenom,String username, int password, String role, String adresse, int num_tel, String email, String image) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.username=username;
        this.password = password;
        this.role = role;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.image = image;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }
    
    
    
    
    
    
}
