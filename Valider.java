package tz;

import java.util.Scanner;

public class Valider {
    String string;
    String[] nums = new String[3];

    public Valider (String intNum) {
        string = intNum;
        nums[0] = string.split(" ")[0];
        nums[1] = string.split(" ")[1];
        nums[2] = string.split(" ")[2];
    }
    // проверка входных данных
    public boolean isActual() {
        // проверка на введение уравнения не длинее одной операции
        try {
            if (nums.length < string.split(" ").length ) {
                throw new Exception("Недопустимое количество символов. " +
                    "Повторите попытку");
            }
            // возможность произведения операции
            switch (nums[1]) {
                case "+":
                case "-":
                case "/":
                case "*":
                    break;
                default:
                    throw new Exception("Недопустимую операция. Повторите попытку");
            }
            // действительны ли РИМСКИЕ числа
            if ((this.romaNums(nums[0]) != 0) && (this.romaNums(nums[2]) != 0)) {

            }

            else if(( nums[0].length() < 3 && this.isDigit(nums[0])) &&
                    (nums[2].length() < 3 && this.isDigit(nums[2]))) {
                // не больше ли число чем 10
                if ((Integer.parseInt(nums[0]) < 11) && (Integer.parseInt(nums[2]) < 11)) {
                } else {
                    throw new Exception("Недопустимое значение. Повторите попытку"); }
                } else {
                    throw new Exception("Недопустимое значение. Повторите попытку"); }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    // соотношения значений и проверка что они не больше 10
    public  int romaNums (String numValid) {
        int result = 0;
        switch (numValid) {
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
        }
        return result;
    }
    // проверка возможности конвертации арабского значения
    public boolean isDigit(String num) throws NumberFormatException {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            for(int i = 0; true;) {
                System.out.println("Введите ваше уравнение ниже и я быстро с ним расправлюсь ;]");
                String userInput = input.nextLine();
                Valider call = new Valider(userInput);
                boolean check = call.isActual();

                if (!check) {
                    break;
                }

                Calculator operate = new Calculator(userInput);
                System.out.print("Результат вычисления:");
                operate.convertation();
                System.out.println(operate.operator());
            }
        } catch (Exception ex) {
            System.err.println("Пользователь, вы ввели некорректные данные! Повторите попытку но будьте внимательны ;]");
        }
    }
}
