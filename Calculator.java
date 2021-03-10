package tz;

/**
 1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
 a + b, a - b, a * b, a / b.
 Данные передаются в одну строку (смотрите пример)!
 Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
 2. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
 3. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
 На выходе числа не ограничиваются по величине и могут быть любыми.
 4. Калькулятор умеет работать только с целыми числами.
 5. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
 при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
 6. При вводе римских чисел, ответ должен быть выведен римскими цифрами,
 соответственно, при вводе арабских - ответ ожидается арабскими.
 7. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
 8. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
 приложение выбрасывает исключение и завершает свою работу.

 Пример работы программы

 Input:
 1 + 2
 Output:
 3

 Input:
 VI / III
 Output:
 II
 **/

public class Calculator extends Valider {
    int o;
    int t;
    boolean Rome;

    public Calculator(String intNum ) {
        super(intNum);
    }

    public String operator() {
        int result = 0;
        String finaly = " ";

        switch (nums[1]) {
            case "+":
                result = add();
                break;
            case "-":
                result = sub();
                break;
            case "*":
                result = mul();
                break;
            case "/":
                result = div();
                break;
        }

        if (Rome) {
            finaly += toRome(result);
        }
        else {
            finaly += result;
        }
        return finaly;
    }

    public int add() {
        return o + t;
    }

    public int div() {
        return o / t;
    }

    public int sub() {
        return o - t;
    }

    public int mul() {
        return o * t;
    }

    public void convertation() {
        if (this.romaNums(nums[0]) != 0) {
            o = this.romaNums(nums[0]);
            t = this.romaNums(nums[2]);
            Rome = true;
        } else if (nums[0].length() < 3 && super.isDigit(nums[0])) {
            o = Integer.parseInt(nums[0]);
            t = Integer.parseInt(nums[2]);
            Rome = false;
        }
    }

    public static String toRome(int result) {
        String s = "";
        while (result >= 100) {
            s+= "C";
            result -=100;
        }
        while (result >= 90) {
            s+= "XC";
            result -=90;
        }
        while (result >= 50) {
            s+= "L";
            result -=50;
        }
        while (result >= 40) {
            s+= "XL";
            result -=40;
        }
        while (result >= 10) {
            s+= "X";
            result -=10;
        }
        while (result >= 9) {
            s+= "IX";
            result -=9;
        }
        while (result >= 5) {
            s+= "V";
            result -=5;
        }
        while (result >= 4) {
            s+= "IV";
            result -=4;
        }
        while (result >= 1) {
            s+= "I";
            result -=1;
        }
        return s;
    }
}