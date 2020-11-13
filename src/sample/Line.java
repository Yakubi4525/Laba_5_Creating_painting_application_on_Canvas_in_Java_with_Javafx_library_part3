package sample;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import java.util.Random;


public class Line extends TFigure {

    // Поле класса
    private double size = 0.0;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }



    public Line(double show_x, double show_y, double size, Color color){
        super(show_x,show_y,color);
        this.size=size;
    }

    public Line(){
        super(new Random().nextDouble() * 634.0,
                new Random().nextDouble() * 401.0,
                Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256))
   );
        this.size = (new Random().nextDouble() * (200.0) + 30);
    }
    public void show(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillRect(getX(), getY(), 4,size);
    }
    public void delete(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 881, 487);



    }
    public void black_border(GraphicsContext gc){
        DropShadow coloredBorderEffect = new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 2, 1, 0, 0);
        gc.setEffect(coloredBorderEffect);
    }

    public void white_border(GraphicsContext gc)
    {
        DropShadow borber_white = new DropShadow(BlurType.THREE_PASS_BOX, getColor(), 2, 1, 0, 0);
        gc.setEffect(borber_white);
    }



}
