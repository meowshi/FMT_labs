import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Practice6 {
    public static String hiddenAnagram(String string1, String string2) {
        // переводим строки в нижний регистр
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();
        StringBuilder string1Builder = new StringBuilder();
        StringBuilder string2Builder = new StringBuilder();
        // записываем только буквы строки
        for ( int i = 0; i < string1.length(); i++ ) {
            if ( Character.isLetter(string1.charAt(i)) ) {
                string1Builder.append(string1.charAt(i));    
            }
        }
        // записываем только букву скрытой анаграммы
        for ( int i = 0; i < string2.length(); i++ ) {
            if ( Character.isLetter(string2.charAt(i)) ) {
                string2Builder.append(string2.charAt(i));    
            }
        }
        // индекс конца
        int index;
        // производим проверку начиная с каждого элемента
        for ( int i = 0; i < string1Builder.length() - string2Builder.length() + 1; i++ ) {
            // получаем индекс на котором закончилось сравнение сответствия
            index = check(string1Builder, string2Builder, i);
            // проверяем все ли правильно
            if ( index - i == string2Builder.length()) {
                return string1Builder.substring(i, index);
            }
        }
        return "noutfond";
    
    }
    public static int check(StringBuilder string1, StringBuilder string2, int index) {
        // скрытая анаграмма
        StringBuilder string = new StringBuilder(string2.toString());
        // указывает на последний проверенный элемент
        int j;
        // проверяем символы на наличие во второй строке
        for ( j = index; 0 != string.length(); j++ ) {
            // получаем индекс элемента из строки в анаграмме
            int i = string.indexOf(Character.toString(string1.charAt(j)));
            // если он успешно найден удаляем элемент из анаграммы
            if (i != -1) {
                string.deleteCharAt(i);
            }
            // иначе выходим из функции
            else return -1;
        }
        return j;
    }
    
    public static String[] collect(String str, int n) {
        // массив подстрок длиной len(str) / n
        String arr[] = new String[str.length() / n];
        // Если длина строки меньше длины подстроки возвращаем пустой массив
        if ( str.length() < n ) return arr;
        // копируем в массив подстроки
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] = str.substring(i * n, i * n + n);
        }
        // сортируем массив
        Arrays.sort(arr);
        return arr;
    }

    public static String nicoCipher(String message, String key) {
        // массив для чисел соответствующих кулючу
        int arr[] = new int[key.length()];
        // индекс минимального элемента ключа
        int min;
        // номер который мы запишем в минимальный индекс
        int index = 1;
        // делаем столько итераций сколько длина у ключа
        for ( int i = 0; i < key.length(); i++ ) {
            min = 0;
            // находим минимальный чар в ключе
            for ( int j = 1; j < key.length(); j++ ) {
                if ( key.charAt(min) > key.charAt(j) ) min = j;
            }
            // записываем число соответствущее на данный момент минимальному чару ключа
            arr[min] = index;
            // увеличиваем записываемое число
            index++;
            // заменяем минимальный чар масимально возможным
            key = key.replaceFirst(Character.toString(key.charAt(min)), Character.toString((char)(255)));
        }
        // зашифрованная строка
        StringBuilder string = new StringBuilder();
        // делаем len(message) / len(key) (округляем вверх) количество итераций (на примере из методички можно показать почему)
        for ( int i = 0; i < message.length() + message.length() % key.length(); i += key.length() ) {
            // число которое ищем в массиве arr
            int num = 1;
            // проходимся по каждой "вырезке" (вырезка - строка из len(key) символов (по методичке объяснить можно))
            for ( int j = 0; j < key.length(); j++ ) {
                // индекс num в массиве arr
                int id = 0;
                // находим id
                for ( int k = 0; k < arr.length; k++ ) 
                    if ( arr[k] == num ) {
                        id = k;
                        break;
                    }
                // если уходим за пределы message добавляем пробел
                if ( i + id >= message.length()) {
                    string.append(' ');
                }
                // иначе добавляем элемент по индексу i + id
                else {
                    string.append(message.charAt(i + id));
                }
                num++;
            }
        }
        return string.toString();
    }
    // не понимаю что именно хотят от меня
    public static int[] twoProduct(int arr[], int n) {
        int twoNumbers[] = new int[2];
        int diff = arr.length;
        for ( int i = 0; i < arr.length - 1; i++ ) {
            for ( int j = i; j < arr.length; j++ ) {
                if ( arr[j] * arr[i] == n && j - i < diff) {
                    twoNumbers[0] = arr[i];
                    twoNumbers[1] = arr[j];
                    diff = j - i;
                }
            }
        }
        System.out.println(twoNumbers[0] + " " + twoNumbers[1]);
        return twoNumbers;
    }
    public static int[] isExact(int number) {
        // значение факториала n
        long fact = 1;
        int n = 1;
        int arr[] = new int[2];
        // пока nuber > fact увеличиваем факториал и n
        for ( int i = 2; number > fact; i++ ) {
            fact *= i;
            n++;
        }
        // если number равен факториалу n заполняем массив
        if ( number == fact) {
            arr[0] = number;
            arr[1] = n;
        }
        return arr;
    }
    // https://math-prosto.ru/?page=pages/circulating_decimal/circulating_decimal.php
    public static String fraction(String number) {
        int i;
        // считаем количество символов целой части
        for ( i = 0; number.charAt(i) != '.'; i++ );
        // записываем целую часть в y
        String y = number.substring(0, i);
        int j;
        // полная дробная часть
        StringBuilder a = new StringBuilder();
        // дробная часть до появления периодичности
        StringBuilder b = new StringBuilder();
        // заполняем а и b
        for ( j = 0; number.charAt(i + 1 + j) != '('; j++ ) {
            // делаем проверку чтобы ненужные нули не записывались в начало числа
            if ( a.length() != 0 || number.charAt(i + 1 + j) != '0')
                a.append(number.charAt(i + 1 + j));
                b.append(number.charAt(i + 1 + j));
        }
        // если в b ничего не записалось записываем ноль
        if ( b.length() == 0 ) b.append('0');
        // количество цифр дробной части до периодичности
        int m = j;
        i = i + 2 + j;
        // дозаполняем а цифрами периодичной части
        for ( j = 0; number.charAt(i + j) != ')'; j++ ) {
            a.append(number.charAt(i + j));
        }
        // так же если в а ничего - добавляем 0
        if ( a.length() == 0 ) a.append('0');
        // количество цифр дробной части после периодичности
        int k = j;
        // знаменатель дроби (k девяток и m нулей)
        StringBuilder K = new StringBuilder();
        for ( i = 0; i < k; i++ ) {
            K.append('9');
        }
        for ( i = 0; i < m; i++ ) {
            K.append('0');
        }
        // знаменатель дроби
        int AminusB = Integer.parseInt(a.toString()) - Integer.parseInt(b.toString());
        // нод числителя и знаменателя
        int nod = BigInteger.valueOf(AminusB).gcd(BigInteger.valueOf(Integer.parseInt(K.toString()))).intValue();
        // уменьшаем числитель и знаменатель в зависимости от нода
        AminusB /= nod;
        // уменьшенный знаменатель
        long down = Long.parseLong(K.toString()) / nod;
        // числитель с учетом что прибавляется y
        long up = Integer.parseInt(y) * down + AminusB;
        return up + "/" + down;
    }

    public static String pilishString(String str) {
        final int pi[] = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        StringBuilder resultStr = new StringBuilder();
        int index = 0;
        // проходимся по всем элементам массива пи или пока индекс не уйдет за границы строки
        for ( int i = 0; i < pi.length && index < str.length(); i++ ) {
            // если подстрока больше длины строки
            if ( index + pi[i] > str.length()) {
                // добавляем оставшуюся строку
                resultStr.append(str.substring(index, str.length()));
                // и добавляем последний элемент сколько нужно раз
                for ( int j = str.length(); j < index + pi[i];j++ ) {
                    resultStr.append(str.charAt(str.length() - 1));
                }
                break;
            }
            else {
                // иначе просто добавляем подстроку, пробел и увеличиваем индекс
                resultStr.append(str.substring(index, index + pi[i]));
                resultStr.append(' ');
                index += pi[i];
            }
        }
        // если последний элемент пробел удаляем его
        if (resultStr.charAt(resultStr.length() - 1) == ' ') resultStr.deleteCharAt(resultStr.length() - 1);
        return resultStr.toString();
    }
    public static String generateNonconsecutive(int n) {
        // начальное число 0 повторенное n раз
        StringBuilder number = new StringBuilder();
        for ( int i = 0; i < n; i++ ) number.append('0');
        // результат
        StringBuilder resultStr = new StringBuilder();
        // добавляем начальное число
        resultStr.append(number.toString());
        resultStr.append(' ');
        // проходмся по каждому нулю в исходной строке
        for (int i = 0; i < n; i++) {
            // создаем новыу строку чтобы не менять исходную
            StringBuilder string = new StringBuilder(number);
            // ставим iый 0 в 1
            string.setCharAt(i, '1');
            resultStr.append(string.toString());
            resultStr.append(' ');
            // запускаем воспомогательную функцию
            addOne(resultStr, string, i + 2);
        }
        return resultStr.toString();
    }
    // суть в том чтобы рекурсивно добавлять единички если можно и не забывать про то что
    // в первую полученную строку например 1000 можно поставить 1 как на второй индекс так и на четвертый
    // для этого вызываем эту функцию два раза
    public static void addOne(StringBuilder resultStr, StringBuilder str, int index) {
        // копия исходного числа
        StringBuilder string = new StringBuilder(str);
        if ( index >= str.length() ) return;
        // проверка чтобы не получить выход за пределы строки
        if ( index - 1 != -1) {
            // проверки на то являются ли соседние элементы нулями
            if ( str.charAt(index - 1) != '1' ) {
                if ( index + 1 >= str.length() || str.charAt(index + 1) != '1') {
                    // если все нормально ставим 1 и проверяем нет ли такого числа уже в результирущей строке
                    // было замечено что такое возможно
                    string.setCharAt(index, '1');
                    if ( !resultStr.toString().contains(string) ) {
                        resultStr.append(string.toString());
                        resultStr.append(' ');
                    }
                    // иначе строку не меняем
                    else {
                        string.setCharAt(index, '0');
                    }
                }
            }
        }
        // то же самое только с учетом что при проверке возможен выход за левую границу
        else if ( index + 1 >= str.length() || str.charAt(index + 1) != '1' ) {
            string.setCharAt(index, '1');
            if ( !resultStr.toString().contains(string) ) {
                resultStr.append(string.toString());
                resultStr.append(' ');
            }
            else {
                string.setCharAt(index, '0');
            }
        }
        // вызываем для исходной строки например 1000
        addOne(resultStr, string, index + 1);
        // и для новой например 1010
        addOne(resultStr, str, index + 1);
    }
    public static String isValid(String str) {
        // массив количеств встречаемых одинаковых букв
        int arr[] = new int[str.length()];
        // копия строки из которой будут удаляться повторки
        StringBuilder strBiulder = new StringBuilder(str);
        // проходимся по всем элементам перед i, удаляем повторы и увеличиваем количество в массиву
        for ( int i = 0; i < strBiulder.length() - 1; i++ ) {
            arr[i]++;
            for ( int j = i + 1; j < strBiulder.length(); ) {
                if ( strBiulder.charAt(i) == strBiulder.charAt(j)) {
                    arr[i]++;
                    strBiulder.deleteCharAt(j);
                }
                else j++;
            }
        }
        // проверяем есть ли повторки у последнего символа если нет то даем ему 1
        if ( arr[strBiulder.length() - 1] == 0 ) arr[strBiulder.length() - 1]++;
        // количество разных по количеству букв
        int count = 0;
        // количество букв отличающихся от обычного количества
        int len = arr[0];
        // проходимся по массиву считаем count если оно больше 1 возвращаем нет
        // так же меняем len по необходимости
        for ( int i = 1; i < arr.length && arr[i] != 0; i++ ) {
            if ( arr[0] != arr[i] ) {
                count++;
                if ( count > 1 ) return "NO";
                len = arr[i];
            }
        }
        // проверяем достаточно ли нам убрать одну букву чтобы получилось поровну
        if ( Math.abs(len - arr[0]) > 1) return "NO";
        return "YES";
    }

    public static int[][] sumsUp(int[] arr) {
        // лист пар
        ArrayList<Integer[]> pairsList = new ArrayList<>();
        // берем iый элемент массива и смравниваем сумму его и элементов перед ним
        // если 8 записываем пару в лист
        for ( int i = 0; i < arr.length - 1; i++ ) {
            for ( int j = i + 1; j < arr.length; j++ ) {
                Integer pair[] = new Integer[2];
                if ( arr[i] + arr[j] == 8 ) {
                    pair[0] = arr[i];
                    pair[1] = arr[j];
                    Arrays.sort(pair);
                    if ( !pairsList.contains(pair) ) {
                        pairsList.add(pair);
                    }
                }
            }
        }
        // преобразуем лист в обычный двумерный массив
        int pairs[][] = new int [pairsList.size()][2];
        for ( int i = 0; i < pairs.length; i++ ) {
            pairs[i][0] = pairsList.get(i)[0];
            pairs[i][1] = pairsList.get(i)[1];
        }
        return pairs;
    }
}