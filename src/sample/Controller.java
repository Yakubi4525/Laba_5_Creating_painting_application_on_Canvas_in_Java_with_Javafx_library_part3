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
    public Square square;
    public Square choosedsquare;
    public Rectangle rect;
    public Rectangle choosed_rect;
    public Romb romb;
    public Romb choosed_romb;
    public Oval oval;
    public Oval choosed_oval;
    public Ellips ellips;
    public Ellips choosed_ellips;
    public Line line;
    public Line choosed_line;
    List<Object> listOfShapes = new ArrayList<>();
    private ArrayList<Square> rectangleList = new ArrayList<>();
    private ArrayList<Romb> rombList = new ArrayList<>();
    private ArrayList<Oval> ovalList = new ArrayList<>();
    private ArrayList<Ellips> ellipsList = new ArrayList<>();
    private ArrayList<Line> lineList = new ArrayList<>();



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
            if((listOfShapes.get(i) instanceof Romb )&&((Romb) listOfShapes.get(i)).getName()=="Romb"){
                romb=(Romb) listOfShapes.get(i);
                if(((point_x-romb.getX())*(romb.getY()+romb.getSize()/2-romb.getY())-(point_y-romb.getY())*(romb.getX()-romb.getSize()/2-romb.getX())==0 && ((romb.getX()<point_x && point_x<romb.getX()-romb.getSize()/2))||(romb.getX()>point_x && point_x>romb.getX()-romb.getSize()/2))||

                        ((point_x-romb.getX())*(romb.getY()+romb.getSize()/2)-(point_y-romb.getY())*(romb.getX()-romb.getSize()/2-romb.getX())==0 && ((romb.getX()<point_x && point_x<romb.getX()-romb.getSize()/2))||(romb.getX()>point_x && point_x>romb.getX()-romb.getSize()/2))

                )

                {
                    choosing_figure="Romb";
                    System.out.println("Romb selected");
                    if(choosed_ellips!=null) {
                        choosed_ellips.white_border(gc);
                        choosed_ellips.show(gc);
                    }
                    if(choosed_rect!=null) {
                        choosed_rect.white_border(gc);
                        choosed_rect.show(gc);
                    }
                    if(choosed_romb!=null) {
                        choosed_romb.white_border(gc);
                        choosed_romb.show(gc);
                    }

                    if(choosedsquare!=null) {
                        choosedsquare.white_border(gc);
                        choosedsquare.show(gc);
                    }

                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=romb.getX();
                    double y=romb.getY();
                    double size=romb.getSize();
                    Color color=romb.getColor();
                    listOfShapes.remove(romb);
                    this.choosed_romb = new Romb(x,y,size,color);
                    this.choosed_romb.black_border(gc);
                    this.choosed_romb.show(gc);
                    listOfShapes.add(this.choosed_romb);
                    break;

                }
            }

            if(listOfShapes.get(i) instanceof Rectangle){
                rect=(Rectangle) listOfShapes.get(i);
                if(rect.getX()<point_x &&point_x<rect.getX()+rect.getSize2()&&rect.getY()<point_y &&point_y<rect.getY()+rect.getSize())
                {
                    choosing_figure="Rectangle";
                    if(choosed_ellips!=null) {
                        choosed_ellips.white_border(gc);
                        choosed_ellips.show(gc);
                    }
                    if(choosed_rect!=null) {
                        choosed_rect.white_border(gc);
                        choosed_rect.show(gc);
                    }
                    if(choosed_romb!=null) {
                        choosed_romb.white_border(gc);
                        choosed_romb.show(gc);
                    }

                    if(choosedsquare!=null) {
                        choosedsquare.white_border(gc);
                        choosedsquare.show(gc);
                    }

                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=rect.getX();
                    double y=rect.getY();
                    double size=rect.getSize();
                    Color color=rect.getColor();
                    listOfShapes.remove(rect);
                    this.choosed_rect = new Rectangle(x,y,size,color);
                    this.choosed_rect.black_border(gc);
                    this.choosed_rect.show(gc);
                    listOfShapes.add(this.choosed_rect);
                    break;

                }
            }

            if((listOfShapes.get(i) instanceof Square) && ((Square) listOfShapes.get(i)).getName()=="Square"){
                square=(Square) listOfShapes.get(i);
                if(square.getX()<point_x &&point_x<square.getX()+square.getSize()&&square.getY()<point_y &&point_y<square.getY()+square.getSize())
                {
                    choosing_figure="Square";
                    System.out.println("Square selected");
                    if(choosed_ellips!=null) {
                        choosed_ellips.white_border(gc);
                        choosed_ellips.show(gc);
                    }
                    if(choosed_rect!=null) {
                        choosed_rect.white_border(gc);
                        choosed_rect.show(gc);
                    }
                    if(choosed_romb!=null) {
                        choosed_romb.white_border(gc);
                        choosed_romb.show(gc);
                    }

                    if(choosedsquare!=null) {
                        choosedsquare.white_border(gc);
                        choosedsquare.show(gc);
                    }

                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                            double x=square.getX();
                            double y=square.getY();
                            double size=square.getSize();
                            Color color=square.getColor();
                            listOfShapes.remove(square);
                            this.choosedsquare = new Square(x,y,size,color);
                            this.choosedsquare.black_border(gc);
                            this.choosedsquare.show(gc);
                            listOfShapes.add(this.choosedsquare);
                            break;

                }
            }
            if(listOfShapes.get(i) instanceof Ellips){
                ellips=(Ellips)listOfShapes.get(i);
                if(Math.sqrt(Math.pow(point_x-(ellips.getX()+ellips.getSize()/2),2.0)+Math.pow(point_y-(ellips.getY()+ellips.getSize()/2),2.0))<(ellips.getSize2()/2))
                {
                    choosing_figure="Ellips";
                    if(choosed_ellips!=null) {
                        choosed_ellips.white_border(gc);
                        choosed_ellips.show(gc);
                    }
                    if(choosed_rect!=null) {
                        choosed_rect.white_border(gc);
                        choosed_rect.show(gc);
                    }
                    if(choosed_romb!=null) {
                        choosed_romb.white_border(gc);
                        choosed_romb.show(gc);
                    }

                    if(choosedsquare!=null) {
                        choosedsquare.white_border(gc);
                        choosedsquare.show(gc);
                    }

                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=ellips.getX();
                    double y=ellips.getY();
                    double size=ellips.getSize();
                    Color color=ellips.getColor();
                    listOfShapes.remove(ellips);
                    this.choosed_ellips = new Ellips(x,y,size,color);
                    this.choosed_ellips.black_border(gc);
                    this.choosed_ellips.show(gc);
                    listOfShapes.add(this.choosed_ellips);
                    break;

                }
            }

            if(listOfShapes.get(i) instanceof Oval){
                oval=(Oval)listOfShapes.get(i);
                if(Math.sqrt(Math.pow(point_x-(oval.getX()+oval.getSize()/2),2.0)+Math.pow(point_y-(oval.getY()+oval.getSize()/2),2.0))<(oval.getSize()/2))
                {
                    choosing_figure="Oval";

                    if(choosed_ellips!=null) {
                        choosed_ellips.white_border(gc);
                        choosed_ellips.show(gc);
                    }
                    if(choosed_rect!=null) {
                        choosed_rect.white_border(gc);
                        choosed_rect.show(gc);
                    }
                    if(choosed_romb!=null) {
                        choosed_romb.white_border(gc);
                        choosed_romb.show(gc);
                    }

                    if(choosedsquare!=null) {
                        choosedsquare.white_border(gc);
                        choosedsquare.show(gc);
                    }

                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=oval.getX();
                    double y=oval.getY();
                    double size=oval.getSize();
                    Color color=oval.getColor();
                    listOfShapes.remove(oval);
                    this.choosed_oval = new Oval(x,y,size,color);
                    this.choosed_oval.black_border(gc);
                    this.choosed_oval.show(gc);
                    listOfShapes.add(this.choosed_oval);
                    break;

                }
            }
            if(listOfShapes.get(i) instanceof Line){
                line=(Line) listOfShapes.get(i);
                if(line.getX()<point_x &&point_x<line.getX()+4&&line.getY()<point_y &&point_y<line.getY()+line.getSize())
                {
                    choosing_figure="Line";
                    if(choosed_ellips!=null) {
                        choosed_ellips.white_border(gc);
                        choosed_ellips.show(gc);
                    }
                    if(choosed_rect!=null) {
                        choosed_rect.white_border(gc);
                        choosed_rect.show(gc);
                    }
                    if(choosed_romb!=null) {
                        choosed_romb.white_border(gc);
                        choosed_romb.show(gc);
                    }

                    if(choosedsquare!=null) {
                        choosedsquare.white_border(gc);
                        choosedsquare.show(gc);
                    }

                    if(choosed_oval!=null) {
                        choosed_oval.white_border(gc);
                        choosed_oval.show(gc);
                    }
                    if(choosed_line!=null) {
                        choosed_line.white_border(gc);
                        choosed_line.show(gc);
                    }
                    double x=line.getX();
                    double y=line.getY();
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
        if (choosing_figure=="Rectangle"&&choosedsquare!=null)
        {
            listOfShapes.remove(choosedsquare);
            choosedsquare.setColor(colorpicker.getValue());
            choosedsquare.show(gc);
            listOfShapes.add(choosedsquare);
        }
        if (choosing_figure=="Line"&&choosed_line!=null) {
            listOfShapes.remove(choosed_line);
            choosed_line.setColor(colorpicker.getValue());
            choosed_line.show(gc);
            listOfShapes.add(choosed_line);
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
    void ellips_draw(ActionEvent event) {
        tool_selected="ellips_selected";
        dialog.setText("Ellips tool selected");

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
    void square_draw(ActionEvent event) {
        tool_selected="square_selected";
        dialog.setText("Square tool selected");

    }

    @FXML
    void romb_draw(ActionEvent event) {
        tool_selected="romb_selected";
        dialog.setText("Romb tool selected");

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

            case "square_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Square square = new Square();
                    square.white_border(gc);
                    square.show(gc);
                    System.out.println("Square creatd");
                    listOfShapes.add(square);
                    rectangleList.add(square);


                } else {
                    show_x = Double.parseDouble(show_cordinate_x.getText());
                    show_y = Double.parseDouble(show_cordinate_y.getText());
                    size = Double.parseDouble(size_line.getText());
                    Color color = colorpicker.getValue();
                    Square square = new Square(show_x, show_y, size, color);
                    square.white_border(gc);
                    square.show(gc);
                    listOfShapes.add(square);
                    rectangleList.add(square);

                }

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
            case "romb_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Romb romb = new Romb();
                    romb.white_border(gc);
                    romb.show(gc);
                    System.out.println("Romb created");
                    listOfShapes.add(romb);
                    rombList.add(romb);


                } else {
                    show_x = Double.parseDouble(show_cordinate_x.getText());
                    show_y = Double.parseDouble(show_cordinate_y.getText());
                    size = Double.parseDouble(size_line.getText());
                    Color color = colorpicker.getValue();
                    Romb romb = new Romb(show_x, show_y, size, color);
                    romb.white_border(gc);
                    romb.show(gc);
                    listOfShapes.add(romb);
                    rombList.add(romb);

                }

                break;
            case "oval_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Oval oval = new Oval();
                    oval.white_border(gc);
                    oval.show(gc);
                    System.out.println("Oval creatd");
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
                    listOfShapes.add(oval);
                    ovalList.add(oval);

                }

                break;
            case "ellips_selected":
                if (show_cordinate_x.getText().equals("") && show_cordinate_y.getText().equals("") && size_line.getText().equals("5")) {
                    Ellips ellips = new Ellips();
                    ellips.white_border(gc);
                    ellips.show(gc);
                    System.out.println("Ellips creatd");
                    listOfShapes.add(ellips);
                    ovalList.add(ellips);


                } else {
                    size = Double.parseDouble(size_line.getText());
                    show_x = Double.parseDouble(show_cordinate_x.getText()) - size;
                    show_y = Double.parseDouble(show_cordinate_y.getText()) - size;

                    Color color = colorpicker.getValue();
                    Ellips ellips = new Ellips(show_x, show_y, 2 * size, color);
                    ellips.white_border(gc);
                    ellips.show(gc);
                    listOfShapes.add(ellips);
                    ovalList.add(ellips);

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
            case "Square":
                listOfShapes.remove(choosedsquare);
                choosedsquare.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosedsquare);
                break;
            case "Oval":
                listOfShapes.remove(choosed_oval);
                choosed_oval.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_oval);
                break;
            case "Line":
                listOfShapes.remove(choosed_line);
                choosed_line.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_line);
                break;
            case "Ellips":
                listOfShapes.remove(choosed_ellips);
                choosed_ellips.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_ellips);
                break;
                case "Romb":
                listOfShapes.remove(choosed_romb);
                choosed_romb.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_romb);
                break;
                case "Rectangle":
                listOfShapes.remove(choosed_rect);
                choosed_rect.MoveTo(move_x, move_y, gc);
                listOfShapes.add(choosed_rect);
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
                rect.white_border(gc);
                rect.show(gc);
            }
            if (listOfShapes.get(i) instanceof Romb){
                romb=(Romb) listOfShapes.get(i);
                romb.white_border(gc);
                romb.show(gc);
            }
            if (listOfShapes.get(i) instanceof Square){
                square=(Square) listOfShapes.get(i);
                square.white_border(gc);
                square.show(gc);
            }
            if (listOfShapes.get(i) instanceof Ellips){
                ellips=(Ellips)listOfShapes.get(i);
                ellips.white_border(gc);
                ellips.show(gc);
            }
            if (listOfShapes.get(i) instanceof Oval){
                oval=(Oval)listOfShapes.get(i);
                oval.white_border(gc);
                oval.show(gc);
            }
            if (listOfShapes.get(i) instanceof Line){
                line=(Line)listOfShapes.get(i);
                line.white_border(gc);
                line.show(gc);
            }
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Rectangle){
            rect=(Rectangle) listOfShapes.get(listOfShapes.size()-1);
            square.black_border(gc);
            rect.show(gc);
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Romb){
            romb=(Romb) listOfShapes.get(listOfShapes.size()-1);
            square.black_border(gc);
            romb.show(gc);
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Square){
            square=(Square) listOfShapes.get(listOfShapes.size()-1);
            square.black_border(gc);
            square.show(gc);
        }
        if (listOfShapes.get(listOfShapes.size()-1) instanceof Ellips){
            ellips=(Ellips)listOfShapes.get(listOfShapes.size()-1);
            oval.black_border(gc);
            ellips.show(gc);
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

}
