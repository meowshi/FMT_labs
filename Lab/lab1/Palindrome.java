// Определяется является ли слово палиндоромом (true - да, false - нет)
public class Palindrome {
    public static void main(String[] args){
        // Перебор аргументов командной строки
        for (int i = 0; i < args.length; i++){
            // Вывод информации о том является ли аргумент палиндромом
            System.out.println(args[i] + ": " + isPalindrome(args[i]));
        }
    }
    // Функция возвращающая перевернутую строку
    public static String reverseString(String str){
        // Переменная в которую сохраняется перевернутая строка
        String rez = "";
        // Перебор всех символов входной строки с конца
        for (int i = str.length() - 1; i >= 0; i--){
            // Добавление очередного символа
            rez += str.charAt(i);
        }
        return rez;
    }
    // Функция, возвращающая true, если строка - палиндром, и false - в противоположном случае
    public static boolean isPalindrome(String str){
        return str.equals(reverseString(str));
    }
}
