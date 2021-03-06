package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.util.Random;

public class Rectangle extends  Square{
    private double size2;
    public Rectangle(){
        super(new Random().nextDouble() * 634.0,
                new Random().nextDouble() * 401.0,
                new Random().nextDouble() * (200.0) + 30,
                Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256)));
        this.size2=getSize()*1.5;

    }

    public double getSize2() {
        return size2;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public Rectangle(double show_x, double show_y, double size, Color color){
        super(show_x, show_y,size, color);
        this.size2=getSize()*1.5;
    }
    @Override
    public void show(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillRect(getX(), getY(), size2,getSize());
    }
    public void delete(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 881, 487);

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