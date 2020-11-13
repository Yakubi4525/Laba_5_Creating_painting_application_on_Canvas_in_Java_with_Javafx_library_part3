package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.util.Random;

public class Romb extends Square {
    private String name="Romb";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Romb(){

        super(new Random().nextDouble() * 634.0,
                new Random().nextDouble() * 401.0,
                (new Random().nextDouble() * (200.0) + 30),
                Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256)));
         name="Romb";

    }

    public Romb(double show_x, double show_y, double size, Color color){
        super(show_x, show_y,size, color);
        name="Romb";
    }
    @Override
    public void show(GraphicsContext gc){
        gc.setStroke(getColor());//гирдаш
        gc.setLineWidth(4);
        gc.setFill(getColor());
        gc.strokeLine(getX(),getY(),getX()-getSize()/2, getY()+getSize()/2);
        gc.strokeLine(getX()-getSize()/2, getY()+getSize()/2, getX(),getY()+getSize());
        gc.strokeLine(getX(),getY(),getX()+getSize()/2, getY()+getSize()/2);
        gc.strokeLine(getX()+getSize()/2, getY()+getSize()/2, getX(),getY()+getSize());
    }


    @Override
    public void delete(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 881, 487);

    }
    @Override
    public void MoveTo(double x, double y,GraphicsContext gc){
        delete(gc);
        setX(getX()+x);
        setY(getY()+y);

    }
    public void black_border(GraphicsContext gc){
        DropShadow coloredBorderEffect = new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 2, 1, 0, 0);
        gc.setEffect(coloredBorderEffect);
    }

    public void white_border(GraphicsContext gc){
        DropShadow borber_white = new DropShadow(BlurType.THREE_PASS_BOX, getColor(), 2, 1, 0, 0);
        gc.setEffect(borber_white);
    }

}


