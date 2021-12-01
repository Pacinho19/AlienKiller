package pl.pacinho.alienkiller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pacinho.alienkiller.logic.Images;

import javax.swing.*;
import java.awt.Rectangle;

@Getter
@Setter
@NoArgsConstructor
public class GameObject extends Rectangle {

    private ObjectType objectType;
    private ImageIcon icon;

    public GameObject(int x, int y, int width, int height, ObjectType objectType) {
        this.x = x;
        this.y = y;
        this.objectType = objectType;
        this.width = width;
        this.height = height;
        icon = (ImageIcon) Images.load(objectType);
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }
}