/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Cours;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HELA
 */
public interface IServicesCours {
      void ajouter(Cours c) throws SQLException;
    void delete(Cours c) throws SQLException;
    void update(Cours c) throws SQLException;
    List<Cours> readAll() throws SQLException;
    List<Cours> readAll(Cours c) throws SQLException;
}
