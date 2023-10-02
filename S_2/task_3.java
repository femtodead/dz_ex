// Дан следующий код, исправьте его там, где требуется 

// public static void main(String[] args) throws Exception {
//    try {
//        int a = 90;
//        int b = 3;
//        System.out.println(a / b);
//        printSum(23, 234);
//        int[] abc = { 1, 2 };
//        abc[3] = 9;
//    } catch (Throwable ex) {
//        System.out.println("Что-то пошло не так...");
//    } catch (NullPointerException ex) {
//        System.out.println("Указатель не может указывать на null!");
//    } catch (IndexOutOfBoundsException ex) {
//        System.out.println("Массив выходит за пределы своего размера!");
//    }
// }
// public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//    System.out.println(a + b);
// }



public class task_3 {
    public static void main(String[] args) throws Exception {
       try {
           int a = 90;
           int b = 3;
           System.out.println(a / b);
           printSum(23, null);
           int[] abc = { 1, 2 };
           abc[3] = 9;
       }  catch (NullPointerException ex) {
           System.out.println("Указатель не может указывать на null!"); // немного тоже не понятная задача, если я правильно пердположил и надо было отловить представленные исключения, 
       } catch (ArrayIndexOutOfBoundsException ex) {//то в самом методае printSum аргументами должны быть типа Integer, так как у примитивного int, null впринципе не возможен
           System.out.println("Массив выходит за пределы своего размера!"); // не понятно что за Throwable поменял на Exception и добавил ниже как требует ирархия исключений
       }catch (Exception ex) {
           System.out.println("Что-то пошло не так...");
       }
    }
    public static void printSum(Integer a, Integer b) throws NullPointerException {// ну и FileNotFoundException файлы мы вроде не ищем)))
        if (a == null){
            throw new NullPointerException();
        }
        System.out.println(a + b);
    } 
}
