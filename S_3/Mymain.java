

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Mymain {
    public static void main(String[] args) {

        String[] mylist = length_check(scan_str());// длинны массива
        int[] inx = checInxFio(mylist, data_check(mylist), chec_num_phone(mylist), gender_check(mylist));// здест сразу несколько проверок, проверка даты, телефона и пола, по мимо этого 
        // каждый из методов возвращает индекс на котором стоит, checInxFio возвращает массив индаксов которые будут испольльзоваться при записи в файл 
        Write(mylist, inx);// ну соответственно саписываем их в файл

    }
    public static String scan_str() throws NullPointerException  
    {
        Scanner scanner = new Scanner(System.in, "ibm866");
        
        System.out.println("Фамилия, Имя, Отчество, дату рождения(формат 10/10/1999), номер телефона(10 цифр), пол(f или m)  (все через пробел):");
        String string = scanner.nextLine();
        scanner.close();
        if (string == ""){
            System.out.println("Нельзя вводить пустые строки");
            throw new NullPointerException();   
        }
        return string;
    }

    public static int split_check(String str){
        String[] mylisy = str.split(" ");
        if(mylisy.length > 6 && mylisy.length != 6){
            return -2;
        }
        if(mylisy.length < 6 && mylisy.length != 6){
            return -1;
        }
        return 0;
    }

    public static String[] length_check(String str){
        int num =  split_check(str);
        String[] mylisy = null;
        if (num == -1) {
            System.out.println("Недостаточно значений");
        }
        else if  (num == -2) {
            System.out.println("Превышен лимит значений");
        }
        else{
            mylisy = str.split(" ");
        }        
        return mylisy;
    }

    public static int data_check(String[] mylisy){
        String[] data_list = null;
        int inxData = 0;
        for (int i = 0; i < mylisy.length; i++) {
            if (mylisy[i].contains("/")){
                data_list = mylisy[i].split("/");
                inxData = i;
                break;
            }
        }
        try {
            int num;
            for (int i = 0; i < 3; i++) {
                num = Integer.parseInt(data_list[i]);
            }
        } catch (NumberFormatException  e) {
            throw new WrongFormatDataEx();
        }
        catch(NullPointerException e){
            throw new NullDataList();
        }
        catch(ArrayIndexOutOfBoundsException e){
            throw new ExDataAr();
        }
        return inxData;
    }
    public static int chec_num_phone(String[] mylist){
        String phone = null;
        int inxPhone = 0;
        for (int i = 0; i < mylist.length; i++) {
            if (chec_num_str(mylist[i])){
                phone = mylist[i];
                inxPhone = i;
                break;
            }
        } 
        
        Integer num = 0;
        try {
            num = Integer.parseInt(phone);
            for (int i = 0; i < 10; i++) {
                phone.charAt(i);
            }
        } catch (NumberFormatException e) {
            System.out.println("Номер телефона не был введ или был введен не корректно "+e.getMessage());
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("цифр в номере телефона меньше или больше 10 "+e.getMessage());
        }
        return inxPhone;
    }
    public static boolean chec_num_str(String string){
        boolean isOnlyDigits = true;
        for(int i = 0; i < string.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(string.charAt(i))) {
                isOnlyDigits = false;
            }
        }
        return isOnlyDigits;
    }

    public static int gender_check(String[] mylist){
        String gender = null;
        int inx = 0;
         for (int i = 0; i < mylist.length; i++) {
            if(mylist[i].length() == 1){
                gender = mylist[i];
                inx = i;
            }
        }
        try {
            if (chec_num_str(gender)){
               int num = Integer.parseInt(gender)/0; // если будет введена 1 цифра то выдаст ошибку
            }
            
        } catch (NullPointerException e) {
            System.out.println("пол не был введен или был введ некоректно"+e.getMessage());
        }
        catch(ArithmeticException e){
            System.out.println("некорректный ввод гендера "+e.getMessage()); 
        }
        return inx;
    }
    public static int[] checInxFio(String[] mylist,int inx1,int inx2,int inx3){
        int[] inxFio = new int[6];
        int count = 0;
        for (int i = 0; i < mylist.length; i++) {
            if (i != inx1 || i != inx2 || i != inx3){
                inxFio[count] = i;
                count++;
            }
        }
        inxFio[3] = inx1;
        inxFio[4] = inx2;
        inxFio[5] = inx3;
        return inxFio;
    }
    public static void Write(String[] mylist,int[] inx){
        String name= mylist[inx[0]]+".txt"; 
        try(FileWriter writer = new FileWriter(name, true))
        {
           // запись всей строки
           String text = ""; 
            for (int i : inx) {
                text += mylist[i]+" ";
            }
            writer.write(text);
            
            writer.append('\n');
            
             
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
}