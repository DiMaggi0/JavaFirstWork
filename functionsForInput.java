import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс, содержащий методы для ввода матриц и комплексных чисел с клавиатуры.
 */
public class functionsForInput {
    /**
     * Метод, позволяющий ввести комплексное число с клавиатуры.
     * @param h1 Ссылочная переменная на объект класса ComplexNumber, куда будет сохраняться введенное число.
     */
    public void enterComplexNumber(ComplexNumber h1){
        Scanner enter = new Scanner(System.in);

        boolean flag = false;
        while(!flag) {
            try{
                System.out.println("Введите действительную часть числа:");
                h1.setReal_part(enter.nextDouble());
                if(h1.getReal_part() == (double) h1.getReal_part()){
                    flag = true;
                }
            }catch(InputMismatchException e){
                System.out.println("Введите целое или действительное число, отделяя дробную часть запятой.");
                enter.next();
            }
        }
        flag = false;
        while(!flag) {
            try {
                System.out.println("Введите мнимую часть числа:");
                h1.setImaginary_part(enter.nextDouble());
                if (h1.getImaginary_part() == (double) h1.getImaginary_part()) {
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите целое или действительное число, отделяя дробную часть запятой.");
                enter.next();
            }
        }
    }

    /**
     * Метод, позволяющий задать количество строк и столбцов матрицы, а также ее элементы.
     * @param h1 Ссылочная переменная на объект класса Matrix, куда будут сохраняться введенные данные.
     */
    public void enterMatrix(Matrix h1){
        Scanner enter = new Scanner(System.in);
        boolean flag = false;
        while(!flag) {
            try {
                System.out.println("Количество строк не может быть отрицательным числом!");
                System.out.println("Введите число строк матрицы:");
                h1.setNumb_of_rows(enter.nextInt());
                if(h1.getNumb_of_rows() == (int)h1.getNumb_of_rows() && h1.getNumb_of_rows() > 0){
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Количество строк матрицы может быть только целым числом!");
                enter.next();
            }
        }
        flag = false;
        while(!flag) {
            try {
                System.out.println("Количество столбцов не может быть отрицательным числом!");
                System.out.println("Введите число столбцов матрицы:");
                h1.setNumb_of_col(enter.nextInt());
                if(h1.getNumb_of_col() == (int)h1.getNumb_of_col() && h1.getNumb_of_col() > 0){
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Количество столбцов матрицы может быть только целым числом!");
                enter.next();
            }
        }
        for(int i = 0; i < h1.getNumb_of_rows(); ++i){
            for(int j = 0; j < h1.getNumb_of_col(); ++j){
                System.out.println("matrix" + "["+ i+"]" + "["+j+"]: ");
                h1.matrix[i][j] = enter.next();

            }
        }

    }
}

