import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Петров Дмитрий;
 * Класс Matrix, содержащий набор методов для работы с матрицами.
 */

public class Matrix {
    /**
     * Функция, преобразующая две строки в объекты класса ComplexNumber и производящая умножение двух чмсел. Необходима для работы с комплексными числами.
     * @param first_num Первое число типа String.
     * @param second_num Второе число типа String.
     * @param what_operation Какой тип операции с числами мы собираемся выполнить.
     * @return Возвращает объект типа String.
     */

    private int numb_of_rows, numb_of_col;
    String[][] matrix = new String[1000][1000];

    /**
     * Метод для получения количества строк матрицы.
     * @return Возращает количество строк.
     */
    public int getNumb_of_rows() {
        return numb_of_rows;
    }

    /**
     * Метод для установления количества строк матрицы объекта Matrix.
     * @param numb_of_rows Передаваемое количество строк в матрице.
     */
    public void setNumb_of_rows(int numb_of_rows) {
        this.numb_of_rows = numb_of_rows;
    }


    /**
     * Метод для получения количества столбцов матрицы.
     * @return Возвращает количество столбцов.
     */
    public int getNumb_of_col() {
        return numb_of_col;
    }

    /**
     * Метод для установления количества столбцов матрицы объекта Matrix.
     * @param numb_of_col Передаваемое количество столбцов в матрице.
     */
    public void setNumb_of_col(int numb_of_col) {
        this.numb_of_col = numb_of_col;
    }


    /**
     * Конструктор класса Matrix, создающий ссылочную переменную, которая указывает на пустой объект класса Matrix.
     */
    public Matrix(){}

    /**
     * Конструктор класса Matrix, создающий матрицу размерами, передаваемыми в конструктор в качестве аргументов.
     * @param numb_of_rows Количество строк.
     * @param numb_of_col Количество столбцов.
     */
    public Matrix(int numb_of_rows, int numb_of_col){
        this.setNumb_of_rows(numb_of_rows);
        this.setNumb_of_col(numb_of_col);

    }

    /**
     * Метод для вывода матрицы на экран
     */
    public void printMatrix(){
        for (int i = 0; i < this.getNumb_of_rows(); ++i) {
            for (int j = 0; j < this.getNumb_of_col(); ++j) {
                if (j == this.getNumb_of_col() - 1) {
                    System.out.printf("%-15s"+'\n', this.matrix[i][j]);
                } else {
                    System.out.printf("%-15s" + "   ", this.matrix[i][j]);
                }
            }
        }
    }

    /**
     * Метод, выводящий транспонированную матрицу от той, к которой он применялся.
     */
    public void matrixTransposition(){
        Matrix test = new Matrix(this.getNumb_of_col(), this.getNumb_of_rows());
        for(int i=0; i < this.getNumb_of_col();i++){
            for(int j=0; j < this.getNumb_of_rows();j++){
                test.matrix[i][j] = this.matrix[j][i];

            }

        }
        test.printMatrix();

    }

    /**
     * Метод, умножающий, если это возможно, одну матрицу на другую и выводящий полученную матрицу на экран.
     * @param h1 Матрица, элементы которой умножаются на матрицу, к которой применяется данный метод.
     * @return Возвращает строку, которая говорит о результате умножения.
     */
    public String productOfMatrix(Matrix h1){
        if(this.getNumb_of_col() != h1.getNumb_of_rows()){
            return "Нельзя перемножать матрицы разных размерностей.";
        }
        else{
            Matrix test = new Matrix(this.getNumb_of_rows(), h1.getNumb_of_col());
            ComplexNumber h = new ComplexNumber();
            String newElement = "0";
            for(int i = 0; i < this.getNumb_of_rows();++i){
                for(int j = 0; j < h1.getNumb_of_col(); ++j){
                    for(int k = 0; k < this.getNumb_of_col();++k){
                        newElement = h.funcForOperations(newElement, h.funcForOperations(this.matrix[i][k], h1.matrix[k][j], "prod"), "sum");
                    }
                    test.matrix[i][j] = newElement;
                    newElement = "0";
                }
            }
            test.printMatrix();
            return "Умножение прошло успешно!";
        }

    }

    /**
     * Метод, складывающий, если это возможно, две матрицы и выводящий полученную матрицу на экран.
     * @param h1 Матрица, элементы которой прибавляются к матрице, к которой применяется данный метод.
     * @return Возвращает строку, которая говорит о результате сложения.
     */
    public String sumOfMatrix(Matrix h1){
        if((this.getNumb_of_rows() == h1.getNumb_of_rows()) && (this.getNumb_of_col() == h1.getNumb_of_col())){
            Matrix test = new Matrix(this.getNumb_of_rows(), this.getNumb_of_col());
            ComplexNumber h = new ComplexNumber();
            for(int i = 0; i < this.getNumb_of_rows();i++){
                for(int j = 0; j < this.getNumb_of_col(); j++){
                    test.matrix[i][j] = h.funcForOperations(this.matrix[i][j], h1.matrix[i][j], "sum");
                }
            }
            test.printMatrix();
            return "Сложение прошло успешно!";

        }

        else{
            return "Нельзя сложить матрицы разной размерности!";

        }

    }

    /**
     * Метод, меняющий местами две строки данной матрицы.
     * @param first_row Номер первой строки в матрице.
     * @param second_row Номер второй строки в матрице.
     */
    public void swapRows(int first_row, int second_row){
        String value = "";
        for(int i = 0; i < this.getNumb_of_col(); i++){
            value = this.matrix[first_row][i];
            this.matrix[first_row][i] = this.matrix[second_row][i];
            this.matrix[second_row][i] = value;
            value = "";
        }
    }

    /**
     * Метод, позволяющий, если это возможно, посчитать определитель матрицы.
     * @return Возвращает значение определителя в виде строки.
     */
    public String detOfMatrix() {
        if (this.getNumb_of_rows() != this.getNumb_of_col()) {
            return "Нельзя посчитать определитель у данной матрицы.";
        }
        else {
            int countOfChange = 0;
            ComplexNumber h = new ComplexNumber();
            Matrix test = new Matrix(this.getNumb_of_rows(), this.getNumb_of_col());
            String det = "1";
            String a = "0";
            for (int i = 0; i < test.getNumb_of_rows(); ++i) {
                for (int j = 0; j < test.getNumb_of_col(); ++j) {
                    test.matrix[i][j] = this.matrix[i][j];
                }
            }
            for (int i = 0; i < this.getNumb_of_rows() - 1; i++) {
                int k = i+1;
                while (test.matrix[i][i].equals("0")) {
                    if (test.matrix[i][i].equals("0")) {
                        test.swapRows(i, k);
                        countOfChange++;
                    }
                        k++;
                        if (k == this.getNumb_of_rows() && test.matrix[i][i].equals("0")) {
                            return a;
                        }
                    }
                    String kef = "";
                    int index = 1;
                    for (int j = i + 1; j < this.getNumb_of_rows(); j++) {
                        kef = h.funcForOperations(test.matrix[j][i], test.matrix[j - index][i], "div");
                        for (int l = i; l < this.getNumb_of_rows(); l++) {
                            test.matrix[j][l] = h.funcForOperations(test.matrix[j][l], h.funcForOperations(test.matrix[j - index][l], kef, "prod"), "sub");

                        }
                        index++;
                    }
                }
                for (int j = 0; j < this.getNumb_of_rows(); j++) {
                    det = h.funcForOperations(det, test.matrix[j][j], "prod");
                }
                ComplexNumber h1 = new ComplexNumber();
                h1.setReal_part(Math.pow(-1, countOfChange));
                return h.funcForOperations(det, h1.returnNumberInAlgForm(), "prod");
            }

        }
    }


