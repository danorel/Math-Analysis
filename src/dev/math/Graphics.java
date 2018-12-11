package dev.math;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.ArrayList;

public class Graphics extends GraphicsProgram {

    private static final int WIDTH = 320;
    private static final int HEIGHT = 140;
    private static final int DIST = 40;
    private static final int LENGTH = 10;
    private Function function;
    private ArrayList<Double> arrayList;

    private double right_border_X = 1.0; // Крайнє-праве значення X
    private double left_border_X = 0.0; // Крайнє-ліве значення X
    private static final double eps = 10e-6;

    public void init() {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        function = new Function(left_border_X, right_border_X, eps, this);
    }

    public void run(){
        arrayList = function.graphics_dev_method();
        drawAxis();
        drawPoints();
    }

    private void drawAxis(){
        GLine main_x = new GLine(0, this.getHeight() / 2 + 30, this.getWidth(), this.getHeight() / 2 + 30);
        GLine x_line;
        GLabel label;
        double diff = 0.15;
        double start_label = 0;
        for(int counter = 0, X_DIFF = 0; counter < WIDTH / DIST; counter++, X_DIFF += DIST){
            // Будує мастштаб по X
            label = new GLabel(Double.toString(start_label).substring(0, 3), X_DIFF - 5, this.getHeight() / 2 + 10);
            x_line = new GLine(X_DIFF, this.getHeight() / 2 + 30 - LENGTH, X_DIFF, this.getHeight() / 2 + 30 + LENGTH);
            start_label += diff;
            add(x_line);
            add(label);
        }
        add(main_x);
    }

    private void drawPoints(){
        GLine lines;
        for(int counter = 0; counter < arrayList.size(); counter++){
            if(counter == arrayList.size() - 1){
                lines = new GLine(this.getWidth() * arrayList.get(counter) - DIST, this.getHeight() / 2 + 30 - LENGTH - 3, this.getWidth() * arrayList.get(counter) - DIST,this.getHeight() / 2 + 30 + LENGTH + 3);
                lines.setColor(new Color(0xDC0003));
                lines.setVisible(true);
            } else if(counter == 0) {
                lines = new GLine(this.getWidth() * arrayList.get(counter) - DIST + 15, this.getHeight() / 2 - LENGTH + 30, this.getWidth() * arrayList.get(counter) - DIST + 15,this.getHeight() / 2 + 30 + LENGTH );
                lines.setColor(new Color(0x00DC1D));
                lines.setVisible(true);
            } else {
                lines = new GLine(this.getWidth() * arrayList.get(counter) - DIST, this.getHeight() / 2 + 30 - LENGTH, this.getWidth() * arrayList.get(counter) - DIST,this.getHeight() / 2 + 30 + LENGTH );
                lines.setColor(new Color(0x00DC1D));
                lines.setVisible(true);
            }
            add(lines);
        }
    }
}


