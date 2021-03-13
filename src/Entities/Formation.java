 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.Objects;

/**
 *
 * @author HELA
 */
public class Formation {

    public Formation() {
    }
    private String titre;
    private int isvalid;
    public Users u1;
    public Cours c1;
  private int formation_id;
  private int user_id;
  private String domaine;
  
  private String date;
  private String duree; 
  private String lieu;
  private float prix;
  private String niveau ;
  private String langue;
  private int nbr_inscrits;
  private int notation;
  private int cours_id;
  private String description;
  private String image;

    public void setImage(String image) {
        this.image = image;
    }

    public Formation(int formation_id) {
        this.formation_id = formation_id;
    }

//    public Formation(int i, String text, LocalDate date2, String text0, String text1, float parseFloat, String text2, String text3, int i0, int i1, int i2, String text4) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

  
  
    public String getImage() {
        return image;
    }

    public Formation(String domaine, String lieu) {
        this.domaine = domaine;
        this.lieu = lieu;
    }
  
    public Formation( int user_id, String domaine, String date, String duree, String lieu, float prix, String niveau, String langue, int nbr_inscrits, int notation,  String description,String image,String titre ) {
       
        this.user_id = user_id;
        this.domaine = domaine;
        this.date = date;
        this.duree = duree;
        this.lieu = lieu;
        this.prix = prix;
        this.niveau = niveau;
        this.langue = langue;
        this.nbr_inscrits = nbr_inscrits;
        this.notation = notation;
        
        this.description = description;
        this.image = image;
        this.titre=titre;
        
    }

//    public Formation(Users u1, Cours c1, int user_id, String domaine, String date, String duree, String lieu, float prix, String niveau, String langue, int cours_id, String description) {
//        this.u1 = u1;
//        this.c1 = c1;
//        this.user_id = user_id;
//        this.domaine = domaine;
//        this.date = date;
//        this.duree = duree;
//        this.lieu = lieu;
//        this.prix = prix;
//        this.niveau = niveau;
//        this.langue = langue;
//        this.cours_id = cours_id;
//        this.description = description;
//    }

    public Users getU1() {
        return u1;
    }
    

   

    public int getFormation_id() {
        return formation_id;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getDate() {
        return date;
    }

    public String getDuree() {
        return duree;
    }

    public String getLieu() {
        return lieu;
    }

    public float getPrix() {
        return prix;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getLangue() {
        return langue;
    }

    public int getNbr_inscrits() {
        return nbr_inscrits;
    }

    public String getDescription() {
        return description;
    }

    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setNbr_inscrits(int nbr_inscrits) {
        this.nbr_inscrits = nbr_inscrits;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Formation{" + "formation_id=" + formation_id + ", domaine=" + domaine + ", date=" + date + ", duree=" + duree + ", lieu=" + lieu + ", prix=" + prix + ", niveau=" + niveau + ", langue=" + langue + ", nbr_inscrits=" + nbr_inscrits + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formation other = (Formation) obj;
        if (this.formation_id != other.formation_id) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (this.nbr_inscrits != other.nbr_inscrits) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        if (!Objects.equals(this.duree, other.duree)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.niveau, other.niveau)) {
            return false;
        }
        if (!Objects.equals(this.langue, other.langue)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setU1(Users u1) {
        this.u1 = u1;
    }

    public void setC1(Cours c1) {
        this.c1 = c1;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setNotation(int notation) {
        this.notation = notation;
    }

    public void setCours_id(int cours_id) {
        this.cours_id = cours_id;
    }

    public int getNotation() {
        return notation;
    }

    public int getCours_id() {
        return cours_id;
    }

    public int getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(int isvalid) {
        this.isvalid = isvalid;
    }
    
}
