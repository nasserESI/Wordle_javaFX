/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;

/**
 *
 * @author Nasse
 */
public class ListWordBox extends VBox {
    private ListWord list;
    public ListWordBox(ArrayList<String> list1) {
        
        list = new ListWord(list1);
        
        getChildren().add(list);
        setPadding(new Insets(35));
        DropShadow dropShadow2 = new DropShadow();
            dropShadow2.setOffsetX(6.0);
            dropShadow2.setOffsetY(4.0);
            list.setEffect(dropShadow2);
        
    }

    public ListWord getList() {
        return list;
    }

}
