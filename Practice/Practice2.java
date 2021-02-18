// Класс второй практической работы
public class Practice2 {
    // Задание 1
    public static String repeat(String str, int n){
        // Строка в которую будут добавляться все символы
        String rez = "";
        // Первый цикл: перебор всех символов входной строки
        for (int i = 0; i < str.length(); i++){
            // Второй цикл: копирование очередного символа в выходную строку n раз
            for (int j = 0; j < n; j++){
                rez += str.charAt(i);
            }
        }
        return rez;
    }
    // Задание 2
    public static int differenceMaxMin(int[] arr){
        // Переменная для хранения максимального элемента
        int max = arr[0];
        // Переменная для хранения минимального элемента
        int min = arr[0];
        // Перебор всех элементов массива
        for (int i = 1; i < arr.length; i++){
            // Если очередной элемен больше масимума -
            // максимуму присваивается этот элемент
            if (arr[i] > max) max = arr[i];
            // Если очередной элемен меньше минимума -
            // минимуму присваивается этот элемент
            else if (arr[i] < min) min = arr[i];
        }
        // Возарат разности максимального и минимального элемента
        return max - min;
    }
    // Задание 3
    public static boolean isAvgWhole(int[] arr){
        // Переменная для хранения суммы элементов массива
        double sum = 0;
        // Перебор всех  элементов массива и их суммирование
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        // С помощью вычитания из числа с плавающей точкой этого же числа,
        // только приведенного к типу int (отбрасывается дробная часть),
        // можно получить дробную часть числа. Если она равна нулю - возвращается true
        // и false - в противном случае
        return sum / arr.length - (int)(sum / arr.length) == 0;
    }
    //Задание 4
    public static int[] cumulativeSum(int[] arr){
        // Создание массива такой же длины как и исходный
        int[] newArr = new int[arr.length];
        // Объявление переменных для хранения суммы и для использования в качестве счетчиков и индексов
        int sum, i, j;
        // Перебор всех элементов исходного массива
        for (i = 0; i < arr.length; i++){
            // В начале каждого цикла sum обнуляется для подсчета очередного значения элемента нового массива
            sum = 0;
            // Перебор всех элементов исходного массива до i и суммирование их
            for (j = 0; j <= i; j++){
                sum += arr[j];
            }
            // Присваивание очередному элементу нового массива суммы элементов исходного массива до i
            newArr[i] = sum;
        }
        return newArr;
    }
    // Задание 5
    public static int getDecimalPlaces(String str){
        // Инициализация переменной для хранения расположения точки
        // В случае если точки нет, это значение останется неизменным и вернется 0
        int dotPos = str.length() - 1;
        // Перебор всех символов строки
        for (int i = 0; i < str.length(); i++){
            // Проверка на то, является ли очередной символ точкой
            if (str.charAt(i) == '.'){
                // Если символ является точкой сохраняется расположение точки и происходит выход из цикла
                dotPos = i;
                break;
            }
        }
        return str.length() - 1 - dotPos;
    }
    // Задание 6
    public static int fibonacci(int n){
        // Предыдущее число Фибоначчи
        int f1 = 1;
        // Последнее найденное число фибоначчи
        int f2 = 2;
        // Переменная для храннения промежуточной информации
        int temp;
        // Цикл для подсчета n-ого числа Фиобаноччи 
        for (int i = 3; i <= n; i++){
            // В результате работы этого блока f1 присвается f2
            // а f2 присваивается f2 + f1
            temp = f2;
            f2 = f1 + temp;
            f1 = temp;
        }
        return f2;
    }
    // Задание 7
    public static boolean isValid(String index){
        // Проверка на правильность длины индекса
        if (index.length() != 5) return false;
        // Цикл для проверки каждого символа на то, является ли он цифрой
        for (int i = 0; i < index.length(); i++){
            if (index.charAt(i) < '0' || index.charAt(i) > '9'){
                return false;
            }
        }
        // Если индекс прошел все проверки, возвращается true
        return true;
    }
    // Задание 8
    public static boolean isStrangePair(String word1, String word2){
        // Проверка на то, являются ли оба параметра пустыми строками 
        if (word1 == "" && word2 == "") return true;
        // Првоерка на то, является ли один из параметров пустой строкой
        else if (word1 == "" || word2 == "") return false;
        // Проверка на странную пару и возврат соответствующего результата
        return word1.charAt(0) == word2.charAt(word2.length() - 1) && word1.charAt(word1.length() - 1) == word2.charAt(0);
    }
    // Задание 9
    public static boolean isPrefix(String word, String prefix){
        // Цикл для сравнения каждого элемента префикса с соответсвующим элементом строки
        // Проверка с начала строки
        for (int i = 0; i < prefix.length() - 1; i++){
            if (word.charAt(i) != prefix.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static boolean isSuffix(String word, String prefix){
        // Цикл для сравнения каждого элемента суффикса с соответсвующим элементом строки
        // Проверка с конца строки
        for (int i = 0; i < prefix.length() - 1; i++){
            if (word.charAt(word.length() - 1 - i) != prefix.charAt(prefix.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    // Задание 10
    public static int boxSec(int n){
        // Переменная для хранения резульатата
        int rez = 0;
        // Цикл в котором происходит проверка номера шага и выполнение соответствующего действия
        for (int i = 1; i <= n; i++){
            if (i % 2 != 0){
                rez += 3;
            }
            else{
                rez -= 1;
            }
        }
        return rez;
    }
}
