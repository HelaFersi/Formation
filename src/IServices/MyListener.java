/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Cours;
import Entities.Formation;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author HELA
 */
public interface MyListener {
      public void onClickListener(MouseEvent event ,Formation oeuvre);
      public void onClickListener(MouseEvent event ,Cours cours);
    
}
