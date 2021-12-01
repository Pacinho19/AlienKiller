package pl.pacinho.alienkiller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.pacinho.alienkiller.logic.Images;

import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class GameObject {

    private int x;
    private int y;
    private ObjectType objectType;
    private int width;
    private int height;
    private ImageIcon icon;

    public GameObject(int x, int y, int width, int height, ObjectType objectType) {
        this.x = x;
        this.y = y;
        this.objectType = objectType;
        this.width = width;
        this.height = height;
        icon = (ImageIcon) Images.load(objectType);
    }
}