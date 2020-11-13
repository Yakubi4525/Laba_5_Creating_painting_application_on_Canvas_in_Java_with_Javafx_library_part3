package sample;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


import javax.imageio.ImageIO;
import java.util.Random;


public class Controller {
    public String choosing_figure;
    public Rectangle rect;
    public Rectangle choosed_rectangle;
    public Oval oval;
    public Oval choosed_oval;
    public Line line;
    public Line choosed_line;
    List<Object> listOfShapes = new ArrayList<>();
    private ArrayList<Rectangle> rectangleList = new ArrayList<>();
    private ArrayList<Oval> ovalList = new ArrayList<>();
    private ArrayList<Line> lineList = new ArrayList<>();


    DropShadow borderEffect = new DropShadow(BlurType.THREE_PASS_BOX, Color.WHITE, 0, 0, 0, 0);
    DropShadow coloredBorderEffect = new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 2, 1, 0, 0);
    public GraphicsContext gc;
    private String tool_selected="None";
    public double show_x;
    public double show_y;
    public double move_x;
    public double move_y;
    public double size;
    public Color color;
    private int SELECTED_INDEX;
    public double click_x;
    public double click_y;
    public Object o;
    public int shapePosition;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorpicker;

    @FXML
    private Button draw_button;

    @FXML
    private Button moveAll_button;

    @FXML
    private ScrollBar scrol_move_x;

    @FXML
    private ScrollBar scrol_move_y;

    @FXML
    private TextField line_show_y1;

    @FXML
    private TextField line_show_x1;

    @FXML
    private TextField line_show_x2;

    @FXML
    private TextField size_line;

    @FXML
    private TextField show_cordinate_x;

    @FXML
    private TextField show_cordinate_y;

    @FXML
    private ScrollBar size_scrollbar;


    @FXML
    private Button move_button;

    @FXML
    private TextField move_cordiante_x;

    @FXML
    private TextField move_cordinate_y;

    @FXML
    private Button save_button;

    @FXML
    private Button pen_button;

    @FXML
    private Button fill_button;

    @FXML
    private Button text_button;

    @FXML
    private Button ruler_button;

    @FXML
    private Button eraser_button;

    @FXML
    private Button line_button;

    @FXML
    private Button rect_button;

    @FXML
    private Button oval_button;

    @FXML
    private Button poligon_button;

    @FXML
    private TextField dialog;

    @FXML


    void initialize() {


        this.gc = canvas.getGraphicsContext2D();
        size_scrollbar.setMin(5);
        size_scrollbar.setMax(100);
        size_scrollbar.setValue(5);
        size_scrollbar.valueProperty().addListener(event->{
            size_line.setText(Double.toString((int)size_scrollbar.getValue()));
        });
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        click_x=e.getX();
                        click_y=e.getY();
                        chooseshape(click_x, click_y);

                    }
                });


    }
    public void chooseshape(double point_x, double point_y){
        for(int i = listOfShapes.size()-1 ; i >= 0; i--){
            if(listOfShapes.get(i) instanceof Rectangle){
                rect=(Rectangle) listOfShapes.get(i);
                if(rect.getShow_x()<point_x &&point_x<rect.getShow_x()+rect.getSize()&&rect.getShow_y()<point_y &&point_y<rect.getShow_y()+rect.getSize())
                {
                    choosing_figure="Rectangle";
                    if(choosed_rectangle!=null) {
                        choosed_rectangle.white_border(gc);
                        choosed_rectangle.show(gc);
                    }
                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                            double x=rect.getShow_x();
                            double y=rect.getShow_y();
                            double size=rect.getSize();
                            Color color=rect.getColor();
                            listOfShapes.remove(rect);
                            this.choosed_rectangle = new Rectangle(x,y,size,color);
                            this.choosed_rectangle.black_border(gc);
                            this.choosed_rectangle.show(gc);
                            listOfShapes.add(this.choosed_rectangle);
                            break;

                }
            }
            if(listOfShapes.get(i) instanceof Oval){
                oval=(Oval)listOfShapes.get(i);
                System.out.println(Math.sqrt(Math.pow(point_x-(oval.getShow_x()+oval.getSize()/2),2.0)+Math.pow(point_y-oval.getShow_y()+oval.getSize()/2,2.0))<(oval.getSize()/2));
                System.out.println(Math.sqrt(Math.pow(point_x-(oval.getShow_x()+oval.getSize()/2),2.0)+Math.pow(point_y-oval.getShow_y()+oval.getSize()/2,2.0)));
                if(Math.sqrt(Math.pow(point_x-(oval.getShow_x()+oval.getSize()/2),2.0)+Math.pow(point_y-(oval.getShow_y()+oval.getSize()/2),2.0))<(oval.getSize()/2))
                {
                    choosing_figure="Oval";


                    if(choosed_rectangle!=null) {
                        choosed_rectangle.white_border(gc);
                        choosed_rectangle.show(gc);
                    }
                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=oval.getShow_x();
                    double y=oval.getShow_y();
                    double size=oval.getSize();
                    Color color=oval.getColor();
                    listOfShapes.remove(oval);
                    this.choosed_oval = new Oval(x,y,size,color);
                    this.oval.black_border(gc);
                    this.choosed_oval.show(gc);
                    listOfShapes.add(this.choosed_oval);
                    break;

                }
            }
            if(listOfShapes.get(i) instanceof Line){
                line=(Line) listOfShapes.get(i);
                if(line.getShow_x()<point_x &&point_x<line.getShow_x()+4&&line.getShow_y()<point_y &&point_y<line.getShow_y()+line.getSize())
                {
                    choosing_figure="Line";
                    if(choosed_rectangle!=null) {
                        choosed_rectangle.white_border(gc);
                        choosed_rectangle.show(gc);
                    }
                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=line.getShow_x();
                    double y=line.getShow_y();
                    double size=line.getSize();
                    Color color=line.getColor();
                    listOfShapes.remove(line);
                    this.choosed_line = new Line(x,y,size,color);
                    this.choosed_line.black_border(gc);
                    this.choosed_line.show(gc);
                    listOfShapes.add(this.choosed_line);
                    break;

                }
            }
        }
    }

    Random random = new Random();


    @FXML
    void eraser_draw(ActionEvent event) {
        System.out.println("1");
        tool_selected="eraser_selected";
        dialog.setText("Eraser tool selected");
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if(tool_selected=="eraser_selected"){
                            double size_pen=Double.parseDouble(size_line.getText());
                            double x =e.getX()-size_pen/2;
                            double y=e.getY()-size_pen/2;
                            Color color=Color.WHITE;
                            gc.setFill(color);
                            gc.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, color, 0, 0, 0, 0));
                            gc.fillRect(x, y, size_pen, size_pen);
                        }

                    }
                });


    }

    @FXML
    void fIll_color(ActionEvent event) {
        tool_selected="fill_color_selected";
        dialog.setText("Fill Color tool selected");
        if (choosing_figure=="Rectangle"&&choosed_rectangle!=null)
        {
            listOfShapes.remove(choosed_rectangle);
            choosed_rectangle.setColor(colorpicker.getValue());
            choosed_rectangle.show(gc);
            listOfShapes.add(choosed_rectangle);
        }
        if (choosing_figure=="Oval"&&choosed_oval!=null)
        {
            listOfShapes.remove(choosed_oval);
            choosed_oval.setColor(colorpicker.getValue());
            choosed_oval.show(gc);
            listOfShapes.add(choosed_oval);
        }
        if (choosing_figure=="Line"&&choosed_line!=null) {

            listOfShapes.remove(choosed_line);
            choosed_line.setColor(colorpicker.getValue());
            choosed_line.show(gc);
            listOfShapes.add(choosed_line);
        }

    }


    @FXML
    void line_draw(ActionEvent event) {
        tool_selected="line_selected";
        dialog.setText("Line tool selected");

    }



    @FXML
    void oval_draw(ActionEvent event) {
        tool_selected="oval_selected";
        dialog.setText("Oval tool selected");

    }

    @FXML
    void poigon_draw(ActionEvent event) {
        tool_selected="poligon_selected";
        dialog.setText("Poligon tool selected");

    }

    @FXML
    void rect_draw(ActionEvent event) {
        tool_selected="rect_selected";
        dialog.setText("Rect tool selected");

    }

    @FXML
    void ruler_func(ActionEvent event) {
        tool_selected="ruler_selected";
        dialog.setText("Ruler tool selected");

    }

    @FXML
    void text_draw(ActionEvent event) {
        tool_selected="text_selected";
        dialog.setText("Text tool selected");

    }

    @FXML
    void draw_pen(ActionEvent event) {
        tool_selected="pen_selected";
        dialog.setText("Pen tool selected");
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if(tool_selected=="pen_selected"){
                            double size_pen=Double.parseDouble(size_line.getText());
                            double x =e.getX()-size_pen/2;
                            double y=e.getY()-size_pen/2;
                            Color color=colorpicker.getValue();
                            gc.setFill(color);
                            gc.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, color, 0, 0, 0, 0));
                            gc.fillRect(x, y, size_pen, size_pen);
                        }
                    }
                });
    }

    @FXML
    void draw_figure(ActionEvent event) {
        switch (tool_selected) {
            case "None":
                dialog.setText("Select any tool!!!");
                break;

            case "rect_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Rectangle rect = new Rectangle();
                    rect.white_border(gc);
                    rect.show(gc);
                    System.out.println("Rectangle creatd");
                    listOfShapes.add(rect);
                    rectangleList.add(rect);


                } else {
                    show_x = Double.parseDouble(show_cordinate_x.getText());
                    show_y = Double.parseDouble(show_cordinate_y.getText());
                    size = Double.parseDouble(size_line.getText());
                    Color color = colorpicker.getValue();
                    Rectangle rect = new Rectangle(show_x, show_y, size, color);
                    rect.white_border(gc);
                    rect.show(gc);
                    listOfShapes.add(rect);
                    rectangleList.add(rect);

                }

                break;
            case "oval_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Oval oval = new Oval();
                    oval.white_border(gc);
                    oval.show(gc);
                    System.out.println("Oval creatd");
                    System.out.println("ovalx:" + oval.getShow_x());
                    System.out.println("ovaly:" + oval.getShow_y());
                    System.out.println("ovalsize:" + oval.getSize());

                    listOfShapes.add(oval);
                    ovalList.add(oval);


                } else {
                    size = Double.parseDouble(size_line.getText());
                    show_x = Double.parseDouble(show_cordinate_x.getText()) - size;
                    show_y = Double.parseDouble(show_cordinate_y.getText()) - size;

                    Color color = colorpicker.getValue();
                    Oval oval = new Oval(show_x, show_y, 2 * size, color);
                    oval.white_border(gc);
                    oval.show(gc);
                    System.out.println("ovalx:" + oval.getShow_x());
                    System.out.println("ovaly:" + oval.getShow_y());
                    System.out.println("ovalsize:" + oval.getSize());
                    listOfShapes.add(oval);
                    ovalList.add(oval);

                }

                break;
            case "line_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Line line = new Line();
                    line.white_border(gc);
                    line.show(gc);
                    System.out.println("Line creatd");
                    listOfShapes.add(line);
                    lineList.add(line);


                } else {
                    show_x = Double.parseDouble(show_cordinate_x.getText());
                    show_y = Double.parseDouble(show_cordinate_y.getText());
                    size = Double.parseDouble(size_line.getText());
                    Color color = colorpicker.getValue();
                    Line line = new Line(show_x, show_y, size, color);
                    line.white_border(gc);
                    line.show(gc);
                    listOfShapes.add(line);
                    lineList.add(line);

                }

                break;

        }
    }

    @FXML
    void move_figure(ActionEvent event) {
        if (move_cordiante_x.getText().equals("") && move_cordinate_y.getText().equals("")){
            move_x = new Random().nextDouble() * 700.0;
            move_y = new Random().nextDouble() * 400.0;
        }else {
            move_x = Double.parseDouble(move_cordiante_x.getText());
            move_y = Double.parseDouble(move_cordinate_y.getText());

        }
        switch(choosing_figure){
            case "Rectangle":
                choosed_rectangle.white_border(gc);
                listOfShapes.remove(choosed_rectangle);
                choosed_rectangle.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_rectangle);
                break;
            case "Oval":
                choosed_oval.white_border(gc);
                listOfShapes.remove(choosed_oval);
                choosed_oval.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_oval);
                break;
            case "Line":
                choosed_line.white_border(gc);
                listOfShapes.remove(choosed_line);
                choosed_line.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_line);
                break;

        }
        update_gc();


    }

    @FXML
    void save_img(ActionEvent event) {
        try {
            Image snaphot=canvas.snapshot(null,null);
            ImageIO.write(SwingFXUtils.fromFXImage(snaphot, null), "png", new File("paint.png"));
            System.out.println("File created");
            dialog.setText("File created succesfully");
        } catch(Exception e){
            dialog.setText("Failed to save image"+e);
        }


    }
    void update_gc(){
        for (int i=0; i<listOfShapes.size()-1; i++){
            if (listOfShapes.get(i) instanceof Rectangle){
                rect=(Rectangle) listOfShapes.get(i);
                rect.show(gc);
            }
            if (listOfShapes.get(i) instanceof Oval){
                oval=(Oval)listOfShapes.get(i);
                oval.show(gc);
            }
            if (listOfShapes.get(i) instanceof Line){
                line=(Line)listOfShapes.get(i);
                line.show(gc);
            }
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Rectangle){
            rect=(Rectangle) listOfShapes.get(listOfShapes.size()-1);
            rect.black_border(gc);
            rect.show(gc);
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Oval){
            oval=(Oval)listOfShapes.get(listOfShapes.size()-1);
            oval.black_border(gc);
            oval.show(gc);
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Line){
            line=(Line) listOfShapes.get(listOfShapes.size()-1);
            line.black_border(gc);
            line.show(gc);
        }
    }
    void update_rectangle(){
        for (Rectangle rect: rectangleList){
            rect.show(gc);
        }
    }
}
