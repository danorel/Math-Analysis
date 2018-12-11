package dev.math;

import acm.program.ConsoleProgram;

public class Interface extends ConsoleProgram {

    private static final int WIDTH = 320;
    private static final int HEIGHT = 320;
    private Function function;

    private double right_border_X = 1.0; // Крайнє-праве значення X
    private double left_border_X = 0.0; // Крайнє-ліве значення X
    private static final double eps = 10e-6;

    public void init() {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        function = new Function(left_border_X, right_border_X, eps, this);
    }

    public void run(){
        function.console_dev_method();
    }
}
