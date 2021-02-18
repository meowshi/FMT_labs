// Класс первой практической работы
public class Practice1{
    // Задание 1
    public static int remainder(int n1, int n2){
        // Возвращает остаток от деления числа n1 на n2
        return n1 % n2;
    }
    // Задание 2
    public static double triArea(int a, int h){
        // Возвращает площадь треугольника расчитанную по формуле:
        // S = 0.5 * a * h, где a - длина основания, h - высота
        return 0.5 * a * h;
    }
    // Задание 3
    public static int animals(int chikens, int cows, int pigs){
        // Возвращается количество ног животных
        return 2 * chikens + 4 * (cows + pigs);
    }
    // Задание 4
    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }
    // Задание 5
    public static String operation(int n, int a, int b){
        // Проверка на соответствие каждой операции
        if (a + b == n) return "added";
        else if (a - b == n) return "substracted";
        else if (a * b == n) return "multiply";
        else if (a / b == n) return "division";
        return "none";
    }
    // Задание 6
    public static int ctoa(char ch){
        // Возвращает код символа с помощью явного преобразования в int
        return (int)ch;
    }
    // Задание 7
    public static int addUpTo(int n){
        // Переменная для хранения суммы чисел до n включительно
        int sum = 0;
        // Перебор всех чисел от 1 до n и добавление каждого к sum
        for (int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    // Задание 8
    public static int nextEdge(int a, int b){
        // Сумма двух сторон треугольника должна быть больше тертьей
        return a + b - 1;
    }
    // Задание 9
    public static int sumOfCubes(int[] arr){
        // Переменная для хранения суммы кубов
        int sum = 0;
        // Перебор всех элементов массива
        for (int i = 0; i < arr.length; i++){
            // Добавление к sum куба каждого элемента массива
            sum += Math.pow(arr[i], 3);
        }
        return sum;
    }
    // Задание 10
    public static boolean abcmath(int a, int b, int c){
        // Добавление а к себе b раз
        for (int i = 0; i < b; i++){
            a += a;
        }
        // Проверка на целочисленное деление a на c
        // Возврат соответствующего результата
        return a % c == 0;
    }
}