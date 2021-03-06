package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public abstract class TFigure {
    private double X,Y;
    private Color color;

    public TFigure(double X, double Y, Color color){
        this.X = X;
        this.Y = Y;
        this.color = color;
    }
    public final void MoveTo(double x, double y,GraphicsContext gc){
        delete(gc);
        setX(getX()+x);
        setY(getY()+y);

    }
    public void show(GraphicsContext gc){

    }
    public void black_border(GraphicsContext gc){

    }
    public void white_border(GraphicsContext gc){

    }
    public void delete(GraphicsContext gc){

    }

    public double getY() {
        return Y;
    }

    public double getX() {
        return X;
    }

    public void setY(double y) {
        Y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(double x) {
        X = x;
    }
}
