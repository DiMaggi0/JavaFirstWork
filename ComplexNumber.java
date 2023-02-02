import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Петров Дмитрий
 * Класс, содержащий набор методов для работы с комплексными числами
 */
public class ComplexNumber{
    /**
     * Метод, получающий действительную часть комплексного числа
     * @return Возвращает комплексную часть комплексного числа
     */
    public double getReal_part() {
        return real_part;
    }

    /**
     * Метод, задающий действительную часть комплексного числа, передающуюся в качестве параметра
     * @param real_part действительная часть комплексного числа
     */
    public void setReal_part(double real_part) {
        this.real_part = real_part;
    }

    private double real_part; // действительная часть комплексного числа

    /**
     * Метод, получающий мнимую часть комплексного числа
     * @return Возвращает мнимую часть комплексного числа
     */
    public double getImaginary_part() {
        return imaginary_part;
    }

    /**
     * Метод, задающий мнимую часть комплексного числа, передающуюся в качестве параметра
     * @param imaginary_part мнимая часть комплексного числа
     */
    public void setImaginary_part(double imaginary_part) {
        this.imaginary_part = imaginary_part;
    }

    private double imaginary_part; // мнимая часть комплексного числа

    /**
     * Конструктор, создающий комплексное число по передаваемым параметрам
     * @param real_part, действительная часть комплексного числа
     * @param imaginary_part, мнимая часть комплексного числа
     */
    public ComplexNumber(double real_part, double imaginary_part){ // конструктор для комплексных чисел
        this.setImaginary_part(imaginary_part);
        this.setReal_part(real_part);
    }

    /**
     * Конструктор, позволяющий задать действительную и мнимую часть комплексного числа.
     */
    public ComplexNumber() throws InputMismatchException{
        Scanner enter = new Scanner(System.in);
        boolean flag = false;
        while(!flag) {
            try{
            System.out.println("Введите действительную часть числа:");
            this.setReal_part(enter.nextDouble());
            if(this.getReal_part() == (double) this.getReal_part()){
                flag = true;
            }
            }catch(InputMismatchException e){
                System.out.println("Введите целое или действительное число, отделяя дробную часть запятой.");
                enter.next();
            }
        }
        flag = false;
        while(!flag) {
            try{
            System.out.println("Введите мнимую часть числа:");
            this.setImaginary_part(enter.nextDouble());
            if(this.getImaginary_part() == (double) this.getImaginary_part()){
                flag = true;
            }
            }catch(InputMismatchException e){
                System.out.println("Введите целое или действительное число, отделяя дробную часть запятой.");
                enter.next();
            }

        }
    }

    /**
     * Метод, выводящий число в алгебраической форме
     */
    void printNumberInAlgForm(){
        if( this.getReal_part() != 0 && this.getImaginary_part() != 0)
            System.out.println(this.getReal_part() + " + " + this.getImaginary_part() + " * i");
        else if(this.getReal_part() == 0 && this.getImaginary_part() != 0)
            System.out.println(this.getImaginary_part() + " * i");
        else if(this.getImaginary_part() == 0 && this.getReal_part() != 0)
            System.out.println(this.getReal_part());
        else if(this.getReal_part() == 0 && this.getImaginary_part() == 0)
            System.out.println("0");
    }

    /**
     * Метод, возвращающий комплексное число в алгебраической форме. Необходим для работы с матрицами.
     * @return Возвращает строку - комплексное число в алгебраической форме.
     */
    public String returnNumberInAlgForm(){
        if( this.getReal_part() != 0 && this.getImaginary_part() != 0)
            return (Double.toString(this.getReal_part()) + " + " + Double.toString(this.getImaginary_part()) + " * i");
        else if(this.getReal_part() == 0 && this.getImaginary_part() != 0)
            return (Double.toString(this.getImaginary_part()) + " * i");
        else if(this.getImaginary_part() == 0 && this.getReal_part() != 0)
            return(Double.toString(this.getReal_part()));
        else if(this.getReal_part() == 0 && this.getImaginary_part() == 0)
            return("0");
        return "0";
    }

    /**
     * Метод, выводящий комплексное число в тригонометрической форме.
     */
    void printNumberInTrigForm(){
        double module = Math.sqrt(Math.pow(this.getReal_part(), 2) + Math.pow(this.getImaginary_part(), 2));
        double arg;
        if(this.getReal_part() > 0)
            arg = Math.atan(this.getImaginary_part()/this.getReal_part());
        else if(this.getImaginary_part() > 0)
            arg = Math.PI + Math.atan(this.getImaginary_part()/this.getReal_part());
        else
            arg = -Math.PI + Math.atan(this.getImaginary_part()/this.getReal_part());
        if(module == 0)
            System.out.println("0");
        else
            System.out.println(module + " * (cos(" + arg + ") + i * sin(" + arg + "))");
    }

    /**
     * Метод, складывающий два комплексных числа, создающий новое комплексное число, являющееся результатом сложения
     * @param h1 комплексное число, прибавляемое к числу, к которому применяется метод
     * @return Возвращает новое комплексное число, являющееся результатом сложения двух чисел.
     */
    ComplexNumber sumOfNumbers(ComplexNumber h1){
        return new ComplexNumber(this.getReal_part()+h1.getReal_part(), this.getImaginary_part() + h1.getImaginary_part());
    }

    /**
     * Метод, умножающий два комплексных числа, создающий новое комплексное число, являющееся результатом умножения
     * @param h1 комплексное число, умножаемое на число, к которому применяется метод
     * @return Возвращает новое комплексное число, являющееся результатом умножения двух чисел
     */
    ComplexNumber productOfNumbers(ComplexNumber h1){ // метод для произведения двух комплексных чисел
        return new ComplexNumber(this.getReal_part()*h1.getReal_part() - this.getImaginary_part()*h1.getImaginary_part(), (this.getReal_part()* h1.getImaginary_part()) + (this.getImaginary_part()*h1.getReal_part()));
    }

}

