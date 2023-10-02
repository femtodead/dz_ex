// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        scan_str();
    }
    public static void scan_str() throws NullPointerException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите что нибудь:");
        String string = scanner.nextLine();
        scanner.close();
        if (string == ""){
            System.out.println("Нельзя вводить пустые строки");
            throw new NullPointerException();   
        }
    }
}
