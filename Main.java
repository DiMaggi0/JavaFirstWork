import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс, содержащий в себе главный цикл программы, создающий консольное приложение.
 */
public class Main {
    public static void main(String[] args){

        while (true) {
            Scanner enter = new Scanner(System.in);
            functionsForInput t = new functionsForInput();
            int value = -1;
            while(true) {
                try {
                    System.out.println("Выберите объект для дальнейшей работы: ");
                    System.out.println("1 - Комплексные числа.");
                    System.out.println("2 - Матрицы.");
                    System.out.println("0 - Нажмите, чтобы выйти из программы.");
                    value = enter.nextInt();
                    if(value != -1){
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Введите целое число!");
                    enter.next();
                }
            }
            if (value == 1) {
                    System.out.println("Начнем работу! Введите комплексное число");
                    System.out.println("При вводе действительных чисел отделяйте дробную часть запятой!");
                    ComplexNumber h1 = new ComplexNumber();
                    t.enterComplexNumber(h1);



                        while (true) {
                            int chooseWithNumb = -1;
                            while (true) {
                                try {
                                    System.out.print("Введенное вами число = ");
                                    h1.printNumberInAlgForm();
                                    System.out.println();
                                    System.out.println("Выберите дальнейшие действия с числом:");
                                    System.out.println("1 - Прибавить другое число.");
                                    System.out.println("2 - Умножить на другое число.");
                                    System.out.println("3 - Поделить на другое число.");
                                    System.out.println("4 - Вывести число в тригонометрической форме.");
                                    System.out.println("0 - Выйти из программы.");
                                    chooseWithNumb = enter.nextInt();
                                    if (chooseWithNumb != -1) {
                                        break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Введите целое число!");
                                    enter.next();
                                }
                            }
                            if (chooseWithNumb == 1) {
                                System.out.println("Введите прибавляемое число:");
                                ComplexNumber h2 = new ComplexNumber();
                                t.enterComplexNumber(h2);

                                System.out.print("Сумма введенных чисел равна = ");
                                h1.sumOfNumbers(h2).printNumberInAlgForm();
                                System.out.println();
                            } else if (chooseWithNumb == 2) {
                                System.out.println("Введите умножаемое число:");
                                ComplexNumber h2 = new ComplexNumber();
                                t.enterComplexNumber(h2);
                                System.out.print("Произведение введенных чисел равно = ");
                                h1.productOfNumbers(h2).printNumberInAlgForm();
                                System.out.println();
                            } else if (chooseWithNumb == 3) {
                                System.out.println("Введите число, на которое нужно поделить:");
                                ComplexNumber h2 = new ComplexNumber();
                                t.enterComplexNumber(h2);
                                System.out.print("Частное введенных чисел равно = ");
                                h1.divisionOfNumber(h2).printNumberInAlgForm();
                                System.out.println();

                            }else if(chooseWithNumb == 4){
                                System.out.println("Число в тригонометрической форме:");
                                h1.printNumberInTrigForm();
                            }
                            else if (chooseWithNumb == 0) {
                                break;
                            } else {
                                System.out.println("Действия под такой цифрой еще нет!");
                            }
                        }


            } else if (value == 2) {

                    System.out.println("Введите размерности матрицы и её элементы:");
                    System.out.println("Элементами матрицы могут быть как целые и действительные числа, так и комплексные числа в форме '4+5*i'");
                    Matrix h = new Matrix();
                    t.enterMatrix(h);
                while (true) {
                    int chooseWithMatrix = -1;
                    while(true) {
                        try{
                            System.out.println("Введённая вами матрица:");
                            h.printMatrix();
                            System.out.println("Выберите дальнейшее действие с матрицей:");
                            System.out.println("1 - Сложить с другой матрицей.");
                            System.out.println("2 - Умножить на другую матрицу.");
                            System.out.println("3 - Вывести транспонированную матрицу.");
                            System.out.println("4 - Сосчитать определитель матрицы.");
                            System.out.println("0 - Выйти из программы.");
                            chooseWithMatrix = enter.nextInt();
                            if(chooseWithMatrix != -1){
                                break;
                        }
                        }catch(InputMismatchException e){
                            System.out.println("Введите целое число!");
                            enter.next();
                        }
                    }
                    if (chooseWithMatrix == 1) {
                        System.out.println("Введите вторую матрицу:");
                        System.out.println("Элементами матрицы могут быть как целые и действительные числа, так и комплексные числа в форме '4+5*i'");
                        Matrix h4 = new Matrix();
                        t.enterMatrix(h4);
                        System.out.println("Полученная матрица:");
                        System.out.println(h.sumOfMatrix(h4));
                    } else if (chooseWithMatrix == 2) {
                        System.out.println("Введите вторую матрицу:");
                        System.out.println("Элементами матрицы могут быть как целые и действительные числа, так и комплексные числа в форме '4+5*i'");
                        Matrix h4 = new Matrix();
                        t.enterMatrix(h4);
                        System.out.println("Полученная матрица:");
                        System.out.println(h.productOfMatrix(h4));
                    } else if (chooseWithMatrix == 3) {
                        System.out.println("Полученная матрица:");
                        h.matrixTransposition();
                    }
                    else if(chooseWithMatrix == 4){
                        System.out.println("Определитель данной матрицы равен:");
                        System.out.println(h.detOfMatrix());
                    }
                    else if (chooseWithMatrix == 0) {
                        break;
                    } else {
                        System.out.println("Действия под такой цифрой еще нет!");
                    }
                }
            }
                 else if (value == 0) {
                    break;
                }
                 else {
                    System.out.println("Объекта под такой цифрой еще нет!");
                }


        }
    }
}