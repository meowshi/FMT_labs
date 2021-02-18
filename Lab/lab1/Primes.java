// Нахождение простых чисел до ста
public class Primes{
    public static void main(String[] args){
        // Перебор всех чисел от 2 до 100
        for (int i = 2; i <= 100; i++){
            // Проверка числа на простоту с помощью созданной функции
            if (isPrime(i)){
                // Вывод числа если оно простое
                System.out.println(i);
            }
        }
    }
    // Функция для проверки числа на простоту
    public static boolean isPrime(int n){
        // Перебор всех чисел от 2 до n-1
        for (int i = 2; i < n; i++){
            // Проверка целочисленного деления числа n на i
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}