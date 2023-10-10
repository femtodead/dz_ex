public class WrongFormatDataEx extends NumberFormatException{
    public WrongFormatDataEx(){
        super("Не верный ввод даты рождения(были использованны не допустимы символы)");
    }
}
