import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Петров Дмитрий;
 * Класс Matrix, содержащий набор методов для работы с матрицами
 */

public class Matrix {
    /**
     * Функция, преобразующая две строки в объекты класса ComplexNumber и производящая умножение двух чмсел. Необходима для работы с комплексными числами.
     * @param first_num, первое число типа String
     * @param second_num, второе число типа String
     * @param what_operation, какой тип операции с числами мы собираемся выполнить
     * @return Возвращает объект типа String
     */

    private int numb_of_rows, numb_of_col;
    String[][] matrix = new String[1000][1000];

    /**
     * Метод для получения количества строк матрицы
     * @return Возращает количество строк
     */
    public int getNumb_of_rows() {
        return numb_of_rows;
    }

    /**
     * Метод для установления количества строк матрицы объекта Matrix
     * @param numb_of_rows, передаваемое количество строк в матрице.
     */
    public void setNumb_of_rows(int numb_of_rows) {
        this.numb_of_rows = numb_of_rows;
    }


    /**
     * Метод для получения количества столбцов матрицы.
     * @return Возвращает количество столбцов
     */
    public int getNumb_of_col() {
        return numb_of_col;
    }

    /**
     * Метод для установления количества столбцов матрицы объекта Matrix
     * @param numb_of_col, передаваемое количество столбцов в матрице.
     */
    public void setNumb_of_col(int numb_of_col) {
        this.numb_of_col = numb_of_col;
    }


    /**
     * Конструктор класса Matrix, создающий ссылочную переменную, которая указывает на пустой объект класса Matrix
     */
    public Matrix(){}

    /**
     * Конструктор класса Matrix, создающий матрицу размерами, передаваемыми в конструктор в качестве аргументов
     * @param numb_of_rows, количество строк
     * @param numb_of_col, количество столбцов
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
                    System.out.printf("%-30s"+'\n', this.matrix[i][j]);
                } else {
                    System.out.printf("%-30s" + "   ", this.matrix[i][j]);
                }
            }
        }
    }

    /**
     * Метод, выводящий транспонированную матрицу от той, к которой он применялся
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
     * Метод, умножающий, если это возможно, одну матрицу на другую и выводящий полученную матрицу на экран
     * @param h1, матрица, элементы которой умножаются на матрицу, к которой применяется данный метод
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
     * Метод, складывающий, если это возможно, две матрицы и выводящий полученную матрицу на экран
     * @param h1, матрица, элементы которой прибавляются к матрице, к которой применяется данный метод
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


}
