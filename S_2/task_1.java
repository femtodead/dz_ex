// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        input();
    }
    public static float scaner_float(float num){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число");
        num = scanner.nextFloat();
        scanner.close();
        return num;
    }
    public static void input(){
        float num = 0;
        while (true) {
            try {
                num = scaner_float(num);
                System.out.println("вот это число: " + num);
                break;
            } catch (Exception e) {
                System.out.println("Не корректный ввод, введите число заного");
            }
        }
    }

}