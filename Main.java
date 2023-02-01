import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите объект для дальнейшей работы: ");
            System.out.println("1 - Комплексные числа.");
            System.out.println("2 - Матрицы.");
            System.out.println("0 - Нажмите, чтобы выйти из программы.");
            Scanner enter = new Scanner(System.in);
            int choose = enter.nextInt();
            if (choose == 1) {
                while (true) {
                    System.out.println("Начнем работу! Введите комплексное число");
                    System.out.println("При вводе действительных чисел отделяйте дробную часть запятой!");
                    ComplexNumber h1 = new ComplexNumber();
                    System.out.print("Введенное вами число = ");
                    h1.printNumberInAlgForm();
                    System.out.println();
                    System.out.println("Выберите дальнейшие действия с числом:");
                    System.out.println("1 - Прибавить другое число.");
                    System.out.println("2 - Умножить на другое число.");
                    System.out.println("3 - Вывести число в тригонометрической форме.");
                    System.out.println("0 - Выйти из программы.");
                    int chooseWithNumb = enter.nextInt();
                    if (chooseWithNumb == 1) {
                        System.out.println("Введите прибавляемое число:");
                        ComplexNumber h2 = new ComplexNumber();
                        System.out.print("Сумма введенных чисел равна = ");
                        h1.sumOfNumbers(h2).printNumberInAlgForm();
                        System.out.println();
                    } else if (chooseWithNumb == 2) {
                        System.out.println("Введите умножаемое число:");
                        ComplexNumber h2 = new ComplexNumber();
                        System.out.print("Произведение введенных чисел равна = ");
                        h1.productOfNumbers(h2).printNumberInAlgForm();
                        System.out.println();
                    } else if (chooseWithNumb == 3) {
                        System.out.println("Число в тригонометрической форме:");
                        h1.printNumberInTrigForm();
                    } else if (chooseWithNumb == 0) {
                        break;
                    }

                else{
                    System.out.println("Действия под такой цифрой еще нет!");
                }}


            } else if (choose == 2) {
                while (true) {
                    System.out.println("Введите размерности матрицы и её элементы:");
                    System.out.println("Элементами матрицы могут быть как целые и действительные числа, так и комплексные числа в форме '4+5*i'");
                    Matrix h = new Matrix();
                    System.out.println("Введённая вами матрица:");
                    h.printMatrix();
                    System.out.println("Выберите дальнейшее действие с матрицей:");
                    System.out.println("1 - Сложить с другой матрицей.");
                    System.out.println("2 - Умножить на другую матрицу.");
                    System.out.println("3 - Вывести транспонированную матрицу.");
                    System.out.println("0 - Выйти из программы.");
                    int chooseWithMatrix = enter.nextInt();
                    if (chooseWithMatrix == 1) {
                        System.out.println("Введите вторую матрицу:");
                        Matrix h4 = new Matrix();
                        System.out.println("Полученная матрица:");
                        System.out.println(h.sumOfMatrix(h4));
                    } else if (chooseWithMatrix == 2) {
                        System.out.println("Введите вторую матрицу:");
                        Matrix h4 = new Matrix();
                        System.out.println("Полученная матрица:");
                        System.out.println(h.productOfMatrix(h4));
                    } else if (chooseWithMatrix == 3) {
                        System.out.println("Полученная матрица:");
                        h.matrixTransposition();
                    } else if (chooseWithMatrix == 0) {
                        break;
                    } else {
                        System.out.println("Действия под такой цифрой еще нет!");
                    }
                }
            }
                 else if (choose == 0) {
                    break;
                }
                 else {
                    System.out.println("Действия под такой цифрой еще нет!");
                }


        }
    }
}