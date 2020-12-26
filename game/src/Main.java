//package com.company;

import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application{
    public Canvas canvas = new Canvas(1000, 1030);
    public GraphicsContext gc = canvas.getGraphicsContext2D();

    int size = 100;
    int width = (int) canvas.getWidth() / size;
    Button btnStep = new Button();
    Button btnFill = new Button();
    Button btnClean = new Button();
    Boolean bFill = true, bClean;

    Rectangle nullRec = new Rectangle(0, 0, 0, 0);
    Rectangle[][] ArrRec = new Rectangle[size + 2][size + 2];

    public void BuildTheField() {
        gc.setLineWidth(0.5);
        for (int i = 0; i < size; i++) {
            gc.strokeLine(width * i, 30, width * i, canvas.getHeight()); // v
            gc.strokeLine(0, width * i + 30, canvas.getWidth(), width * i + 30); // h
        }
    }

    public void BuildArrRec() {
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                ArrRec[i][j] = new Rectangle((i - 1) * width, (j - 1) * width + 30, i * width, j * width + 30);
            }
        }
    }

    public Boolean PointInRec(Point P, Rectangle rec) {
        return (P.x - 1 > rec.x1) & (P.x - 1 < rec.x2) & (P.y - 1 > rec.y1) & (P.y - 1 < rec.y2);
    }

    public Rectangle DefineRectangle(Point P) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (PointInRec(P, ArrRec[i][j]) == true)
                    return ArrRec[i][j];
            }
        }
        return nullRec;
    }

    public void ChangeRec(Rectangle R) {
        if (R.color == false) {
            R.color = true;
            gc.setFill(Color.BLACK);
        }
        else {
            R.color = false;
            gc.setFill(Color.WHITE);
        }
        gc.fillRect(R.x1 + 1, R.y1 + 1, width - 2, width - 2);
    }

    public int CheckNeighbors(int i, int j) {
        int k = 0;

        for (int q = -1; q < 2; q++) {
            for (int t = -1; t < 2; t++) {
                if (!(q == 0 & t == 0)) {
                    if (ArrRec[i + q][j + t].color == true) k++;
                }
            }
        }
        return k;
    }

    public void Step() {
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                int c = CheckNeighbors(i, j);
                if (ArrRec[i][j].color == false) {
                    if (c == 3) {
                        ArrRec[i][j].change = true;
                    }
                }
                else if (ArrRec[i][j].color == true) {
                    if (c < 2 | c > 3){
                        ArrRec[i][j].change = true;
                    }
                }
            }
        }

        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                if (ArrRec[i][j].change == true) {
                    ChangeRec(ArrRec[i][j]);
                    ArrRec[i][j].change = false;
                }
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Conways Game Of Life");
        Group root = new Group();

        btnFill.setText("Fill Cells");
        btnFill.setLayoutX(0);
        btnFill.setLayoutY(0);

        btnStep.setText("Step");
        btnStep.setLayoutX(65);
        btnStep.setLayoutY(0);


        btnClean.setText("Clean");
        btnClean.setLayoutX(110);
        btnClean.setLayoutY(0);

        BuildTheField();
        BuildArrRec();

        btnFill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bFill = true;
            }
        });

        btnStep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bFill = false;
                Step();
            }
        });

        btnClean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bFill = false;
                bClean = true;
            }
        });


        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if (bFill == true) {
                            //gc.strokeOval(e.getX(), e.getY(), 2, 2);
                            Point NowPoint = new Point(e.getX(), e.getY());
                            Rectangle rec = DefineRectangle(NowPoint);
                            ChangeRec(rec);
                            //System.out.println(rec);
                        }
                    }
                });


        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if (bFill == true) {
                            Point NowPoint = new Point(e.getX(), e.getY());
                            Rectangle rec = DefineRectangle(NowPoint);
                            if (rec.color == false) {
                                ChangeRec(rec);
                            }
                        }
                        else if (bClean == true) {
                            Point NowPoint = new Point(e.getX(), e.getY());
                            Rectangle rec = DefineRectangle(NowPoint);
                            if (rec.color == true) {
                                ChangeRec(rec);
                            }
                        }
                    }
                });


        root.getChildren().add(canvas);
        root.getChildren().add(btnFill);
        root.getChildren().add(btnStep);
        root.getChildren().add(btnClean);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}