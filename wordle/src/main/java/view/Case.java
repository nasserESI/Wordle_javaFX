package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Nasse
 */
public class Case extends StackPane {

    private Rectangle rectangle;
    private Circle cercle;
    private Label mot;

    public Label getMot() {
        return mot;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Circle getCercle() {
        return cercle;
    }

    public Case() {
        rectangle = new Rectangle(60, 60, Color.LIGHTBLUE);
        rectangle.toBack();
        rectangle.setStyle("-fx-background-color: light blue;");
        cercle = new Circle(30,30,30,Color.LIGHTBLUE);
        mot = new Label();
        this.getChildren().add(rectangle);
        this.getChildren().add(cercle);
        mot.toFront();
        this.getChildren().add(mot);
        this.setPadding(new Insets(20));
        this.setMaxSize(55, 55);
        this.setMinSize(55, 55);
        this.setVisible(true);
        DropShadow dropShadow2 = new DropShadow();
                dropShadow2.setOffsetX(6.0);
                dropShadow2.setOffsetY(4.0);
                setEffect(dropShadow2);

    }

    public void setChar(char car) {
        
        this.mot.setText(""+car);
    }

}
