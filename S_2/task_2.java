// Если необходимо, исправьте данный код
// try {
//    int d = 0;
//    double catchedRes1 = intArray[8] / d;
//    System.out.println("catchedRes1 = " + catchedRes1);
// } catch (ArithmeticException e) {
//    System.out.println("Catching exception: " + e);
// }


public class task_2 {
    public static void main(String[] args) {
        try {
        int d = 0;
        double catchedRes1 = 10 / d; // не совсем понятено само задание но что-бы словить ArithmeticException нужно подилить число на 0 а не часть неизного массива под индексом 8
        System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
        } 
    }


}
