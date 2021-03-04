public class Practice3 {
    // Задание 1
    public static int solution(int a, int b, int c) {
        // Вычисление дискриминанта
        int D = b * b - 4 * a * c;
        // Возвращение значения в зависимости от дискриминанта
        if (D > 0) return 2;
        else if (D == 0) return 1;
        return 0;
    }
    // Задание 2
    public static int findZip(String str) {
        // Подсчитвает количество вхождений "zip"
        int count = 0;
        int i;
        // Просматриваем за раз три буквы в строке (при двух вхождениях "zip" выход из цикла)
        for (i = 0; i + 2 < str.length() && count < 2; i++) {
            // Если эти три буквы "z", "i", "p" увеличиваем count
            if (str.charAt(i) == 'z' && str.charAt(i + 1) == 'i' && str.charAt(i + 2) == 'p') {
                count++;
            }
        }
        // Если было два вхождения возвращаем индекс "z"
        if (count == 2) return i - 1;
        // Иначе -1
        return -1;
    }
    // Задание 3
    public static boolean checkPerfect(int number) {
        // Сумма множителей
        int sum = 0;
        // Перебираем числа от 1 до numbers - 1
        for (int i = 1; i < number; i++) {
            // Если numbers делится на число без остатка добавляем это число к сумме
            if (number % i == 0) {
                sum += i;
            }
        }
        // Проверяем равна ли сумма number
        // Если да - возвращаем true
        if (sum == number) return true;
        // Иначе - false
        return false;
    }
    // Задание 4
    public static String flipEndChars(String str) {
        // Если строка пустая или состоит из одного символа, возвращаем "несовместимо"
        if (str.length() < 2) {
            return "Incompatible";
        }
        // Иначе, если первый и послежний символы строки равны, возвращаем "два - это пара"
        else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return "Two's a pair";
        }
        // Иначе
        // Новая строка
        String newStr = "";
        // Добавляет в начало последний элемент исходной строки
        newStr += str.charAt(str.length() - 1);
        // Добавляем остальные элементы исходной строки к новой (последний элемент не добавляется)
        for (int i = 1; i < str.length() - 1; i++) {
            newStr += str.charAt(i);
        }
        // Добавляем в конец новой строки первый символ исходной строки 
        newStr += str.charAt(0);
        return newStr;
    }
    // Задание 5
    public static boolean isValidHexCode(String code) {
        // Если первый символ не "#" или длина кода не равна 7, возвращаем false
        if (code.charAt(0) != '#' || code.length() != 7) return false;
        // Иначе проверяем каждый символ на соответствие нужным промежуткам
        // Если не соответствует, возвращаем false
        for (int i = 1; i < code.length(); i++) {
            if (code.charAt(i) >= '0' && code.charAt(i) <= '9' || code.charAt(i) >= 'A' && code.charAt(i) <= 'F' || code.charAt(i) >= 'a' && code.charAt(i) <= 'f') {
                continue;
            }
            return false;
        }
        // Если все хорошо, возвращаем true
        return true;
    }
    // Задание 6
    public static boolean same(int arr1[], int arr2[]) {
        // Количество элементов первого массива
        int count1 = 0;
        // Количество элементов второго массива
        int count2 = 0;
        // Хранит информацию о том, встретилось ли неуникальное число
        boolean flag;
        // Перебираем каждое число массива
        for (int i = 0; i < arr1.length; i++) {
            flag = true;
            // Перебираем каждое число массива сравнивая с текущим
            for (int j = 0; j < i + 1; j++) {
                if (arr1[i] == arr1[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            // Если число уникальное увеличиваем count
            if (flag) {
                count1++;
            }
        }
        // Все то же самое только с count2 и arr2
        for (int i = 0; i < arr2.length; i++) {
            flag = true;
            for (int j = 0; j < i + 1; j++) {
                if (arr2[i] == arr2[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count2++;
            }
        }
        // Если кол-ва уникальных элементов равны, возвращаем true
        if (count1 == count2) return true;
        // Иначе false
        return false;
    }
    // Задание 7
    public static boolean isKarpekar(int number) { 
        // Числа 0 и 1 - числа Капекара
        if (number == 0 || number == 1) return true;
        // Длина квадрата исходного числа
        int numberSqrLenght = 0;
        // Квадрат исходного числа
        int numberSqr = number * number;
        // Считаем длину квадрата исходного числа
        for (int i = numberSqr; i > 0; i /= 10) {
            numberSqrLenght += 1;
        }
        // Находим левую половину
        int left = numberSqr / (int)Math.pow(10, numberSqrLenght / 2 + numberSqrLenght % 2);
        // Находим правую половину
        int right = numberSqr % (int)Math.pow(10, numberSqrLenght / 2 + numberSqrLenght % 2);
        // Если выполняется условие числа Капекара, возвращаем true
        if (left + right == number) return true;
        // Иначе - false
        return false;
    }
    // Задание 8
    public static String longestZero(String string) {
        // Строка из искомого количества нулей
        String zeros = "";
        // Количество встретившихся нулей после очередной единицы
        int count = 0;
        // Перебираем каждый элемент строки
        for (int i = 0; i < string.length(); i++) {
            // Если элемент - 0:
            if (string.charAt(i) == '0') {
                // Увеличиваем count
                count++;
                // Если count перевалило за текущую длину строки нулей, добавляем 0
                if (count > zeros.length()) {
                    zeros += '0';
                }
                continue;
            }
            // Иначе обнуляем count, потому что встретилась 1
            count = 0;
        }
        // Возвращаем строку нулей
        return zeros;
    }
    // Задание 9
    public static int nextPrime(int number) {
        // Перебираем все числа от 2 до number
        for (int i = 2; i < number; i++){
            // Если число не простое:
            if (number % i == 0) {
                // Переходим к следующему числу
                number++;
                // Возвращаем счетчик к началу чтобы снова проверить число на простоту
                i = 2;
            }
        }
        // Возвращаем первое простое число, которое >= number
        return number;
    }
    // Задание 10
    public static boolean rightTriangle(int x, int y, int z) {
        // Присваиваем максимальной стороне (гипотенузе) x
        int max = x;
        // Сумма квадратов катетов
        int sum = 0;
        // Если y больше масимума
        if (max < y) {
            // К сумме прибавляется квадрат предыдущего максимум, так как он уже катет
            sum += max * max;
            // Максимальным становится y
            max = y;
        }
        // Иначе прибавляем к сумме квадрат y
        else sum += y * y;
        // Та же самая проверка с z
        if (max < z) {
            sum += max * max;
            max = z;
        }
        else sum += z * z;
        // Если квадрат гипотенузы равен сумме квадратов катетов, возвращаем true
        if (max * max == sum) return true;
        // Иначе - false
        return false;
    }
}