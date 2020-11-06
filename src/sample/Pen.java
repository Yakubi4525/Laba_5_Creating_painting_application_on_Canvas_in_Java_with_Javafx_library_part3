package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pen {
    private double show_x = 0.0;
    private double show_y = 0.0;
    private double size = 0.0;
    public Color color;
    public GraphicsContext gc;

    public Pen(GraphicsContext gc, Color color, double show_x, double show_y, double size){
        this.show_x=show_x;
        this.show_y=show_y;
        this.size=size;
        this.gc=gc;
        this.color=color;
    }
    public void show() {
        gc.setFill(color);
        gc.fillRect(show_x, show_y, size, size);
    }
}
