package com.company;

/*
Разработайте класс для решения квадратных уравнений. Вычисление
дискриминанта должен осуществлять вложенный класс. После компиляции
объясните структуру class файлов. Проанализируйте использование вложенного
класса.
*/
public class QuadracticEquations {
    private int a;
    private int b;
    private int c;

    //Конструктор внешнего класса
    public QuadracticEquations(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    //В этом методе мы считаем корни
    public double[] roots() {
        Discriminant discriminant = new Discriminant(this);
        double[] roots = new double[(int) discriminant.Value()[1]];
        if (roots.length == 2) {
            roots[0] = ((-1) * b + discriminant.Value()[0]) / (2 * a);
            roots[1] = ((-1) * b - discriminant.Value()[0]) / (2 * a);
        } else System.out.println("Корней нет, т.к. дискриминант отрицательный!");
        return roots;
    }

    static class Discriminant {
        private QuadracticEquations equation;

        //Конструктор вложенного класса. В нем мы ссылаемся на объкт внешнего класса, т.к. они не связаны сразу
        public Discriminant(QuadracticEquations equation) {
            this.equation = equation;
        }

        /*
        * В этом методе возвращается значение дискриминанта и количество корней квадратного уравнения.
        * Если дискриминант отрицательный, то количество корней равняется нулю.
        * Если дискриминант равен нулю, то у нас 2 одинаковых корня
        * Если дискриминант положительный, то у нас 2 различных корня
        * */
        public double[] Value() {
            double dis = Math.sqrt(equation.b * equation.b - (4 * equation.a * equation.c));
            int num = 0;
            num = (dis >= 0) ? 2 : 0;
            return new double[]{Math.sqrt(equation.b * equation.b - (4 * equation.a * equation.c)), num};
        }
    }
}
