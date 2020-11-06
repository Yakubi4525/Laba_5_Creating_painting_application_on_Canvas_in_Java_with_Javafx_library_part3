package sample;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import java.util.Random;


public class Line {


    // Поле класса
    private double show_x = 0.0;
    private double show_y = 0.0;
    private double size = 0.0;
    public Color color;
    public double getShow_x() {
        return show_x;
    }

    public void setShow_x(double show_x) {
        this.show_x = show_x;
    }

    public double getShow_y() {
        return show_y;
    }

    public void setShow_y(double show_y) {
        this.show_y = show_y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Line(double show_x, double show_y, double size, Color color){
        this.show_x=show_x;
        this.show_y=show_y;
        this.size=size;
        this.color=color;
    }

    public Line(){
        this.size = (new Random().nextDouble() * (200.0) + 30);
        this.show_x = new Random().nextDouble() * 834.0;
        this.show_y = new Random().nextDouble() * 471.0;
        this.color=Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
    }
    public void show(GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(show_x, show_y, 4,size);
    }
    public void delete(GraphicsContext gc) {
        DropShadow borber_white = new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE, 2, 1, 0, 0);
        gc.setFill(Color.WHITE);
        gc.setEffect(borber_white);
        gc.fillRect(show_x-1, show_y-1, 6, size+2);



    }
    public void MoveTo(double x, double y, GraphicsContext gc){
        delete(gc);
        this.show_x=this.show_x+x;
        this.show_y=this.show_y+y;

    }
    public void black_border(GraphicsContext gc){
        DropShadow coloredBorderEffect = new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 2, 1, 0, 0);
        gc.setEffect(coloredBorderEffect);
    }

    public void white_border(GraphicsContext gc)
    {
        DropShadow borber_white = new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE, 2, 1, 0, 0);
        gc.setEffect(borber_white);
    }



}
