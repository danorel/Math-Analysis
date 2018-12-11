package dev.math;

import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import java.util.ArrayList;

public class Function {

    private ConsoleProgram consoleProgram;
    private GraphicsProgram graphicsProgram;

    private double right_border_X;
    private double left_border_X;
    private double eps;
    private double alternate_X;
    private boolean isFound = false;
    private int counter = 0;

    public Function(double left_border_X, double right_border_X, double eps, ConsoleProgram consoleProgram){
        this.left_border_X = left_border_X;
        this.right_border_X = right_border_X;
        this.eps = eps;
        this.consoleProgram = consoleProgram;
    }

    public Function(double left_border_X, double right_border_X, double eps, GraphicsProgram graphicsProgram){
        this.left_border_X = left_border_X;
        this.right_border_X = right_border_X;
        this.eps = eps;
        this.graphicsProgram = graphicsProgram;
    }

    public void console_dev_method(){
        if(calculate_Y(left_border_X) * calculate_Y(right_border_X) < 0){
            double remember_value;
            do {
                alternate_X = left_border_X - ((calculate_Y(left_border_X) * (right_border_X - left_border_X)) / (calculate_Y(right_border_X) - calculate_Y(left_border_X)));
                consoleProgram.println((counter + 1) + " ітерація: " + alternate_X);
                counter++;
                if(calculate_Y(alternate_X) == 0){
                    consoleProgram.println("Шуканий Х: " + alternate_X);
                    break;
                } else if(calculate_Y(left_border_X) * calculate_Y(alternate_X) < 0){
                    right_border_X = alternate_X;
                } else if(calculate_Y(right_border_X) * calculate_Y(alternate_X) < 0){
                    left_border_X = alternate_X;
                }
                remember_value = alternate_X;
                alternate_X = left_border_X - ((calculate_Y(left_border_X) * (right_border_X - left_border_X)) / (calculate_Y(right_border_X) - calculate_Y(left_border_X)));
                consoleProgram.println((counter + 1) + " ітерація: " + alternate_X);
                counter++;
            } while(!isFound(remember_value));
            consoleProgram.println("Шуканий X: " + alternate_X);
        } else {
            consoleProgram.println("Неможливо знайти X!");
        }
    }

    public ArrayList<Double> graphics_dev_method() {
        ArrayList<Double> X_Array = new ArrayList<>();
        if (calculate_Y(left_border_X) * calculate_Y(right_border_X) < 0) {
            double remember_value;
            do {
                alternate_X = left_border_X - ((calculate_Y(left_border_X) * (right_border_X - left_border_X)) / (calculate_Y(right_border_X) - calculate_Y(left_border_X)));
                counter++;
                X_Array.add(alternate_X);
                if (calculate_Y(alternate_X) == 0) {
                    break;
                } else if (calculate_Y(left_border_X) * calculate_Y(alternate_X) < 0) {
                    right_border_X = alternate_X;
                } else if (calculate_Y(right_border_X) * calculate_Y(alternate_X) < 0) {
                    left_border_X = alternate_X;
                }
                remember_value = alternate_X;
                alternate_X = left_border_X - ((calculate_Y(left_border_X) * (right_border_X - left_border_X)) / (calculate_Y(right_border_X) - calculate_Y(left_border_X)));
                X_Array.add(alternate_X);
                counter++;
            } while (!isFound(remember_value));
        } else {
            X_Array.add(null);
        }
        return X_Array;
    }

    public double calculate_Y(double X){
        return X * java.lang.Math.pow(java.lang.Math.E, X) - 2;
    }

    public boolean isFound(double rmb){
        return (java.lang.Math.abs(getAlternate_X() - rmb) < eps);
    }

    public double getRight_border_X(){
        return right_border_X;
    }

    public double getLeft_border_X(){
        return left_border_X;
    }

    public double getAlternate_X(){
        return alternate_X;
    }

    public double getEps(){
        return eps;
    }
}
