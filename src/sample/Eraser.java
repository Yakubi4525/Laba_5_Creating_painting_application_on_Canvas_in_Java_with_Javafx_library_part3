package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Eraser {
    private double show_x = 0.0;
    private double show_y = 0.0;
    private double size = 0.0;
    public GraphicsContext gc;

    public Eraser(GraphicsContext gc, double show_x, double show_y, double size){
        this.show_x=show_x;
        this.show_y=show_y;
        this.size=size;
        this.gc=gc;
    }
    public void clear() {
        gc.clearRect(show_x, show_y, size, size);
    }
}
