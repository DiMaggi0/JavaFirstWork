import java.util.InputMismatchException;
import java.util.Scanner;

public class functionsForInput {
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
    public void enterMatrix(Matrix h1){
        Scanner enter = new Scanner(System.in);
        boolean flag = false;
        while(!flag) {
            try {
                System.out.println("Введите число строк матрицы:");
                h1.setNumb_of_rows(enter.nextInt());
                if(h1.getNumb_of_rows() == (int)h1.getNumb_of_rows()){
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
                System.out.println("Введите число столбцов матрицы:");
                h1.setNumb_of_col(enter.nextInt());
                if(h1.getNumb_of_col() == (int)h1.getNumb_of_col()){
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

