/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.DB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author HELA
 */
public class Inscription {
    public Users u1;
  public Formation f;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
Date date = new Date(System.currentTimeMillis());
//System.out.println(formatter.format(date));

    public Inscription(Users u1, Formation f) {
        this.u1 = u1;
        this.f = f;
    }

    public Inscription() {
        
    }

    public Date getDate() {
        return date;
    }




   
     
}
