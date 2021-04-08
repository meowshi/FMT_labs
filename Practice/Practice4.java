import java.util.*;

public class Practice4 {
    public static String sevenBoom(int arr[]) {
        String number;
        for (int i = 0; i < arr.length; i++) {
            number = Integer.toString(arr[i]);
            for (int j = 0; j < number.length(); j++) {
                if (number.charAt(j) == '7') {
                    return "Boom";
                }
            }
        }
        return "There is no 7 in the array";
    }
    public static boolean cons(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (!(arr[i+1] - arr[i] == arr[i] - arr[i-1])) {
                return false;
            }
        }
        return true;
    }
    public static String unmix(String string) {
        String rightString = "";
        for (int i = 0; i < string.length() - 1; i += 2) {
            rightString += "" + string.charAt(i + 1) + string.charAt(i);
        }
        if (string.length() % 2 == 1) {
            rightString += "" + string.charAt(string.length() - 1);
        }
        return rightString;
    }
    public static String noYelling(String string) {
        int i;
        String newString = "";
        for (i = string.length() - 1; string.charAt(i) == '!' || string.charAt(i) == '?'; i--);
        if (i == string.length() - 1 || i == string.length() - 2) return string;
        for (int j = 0; j <= i + 1; j++) {
            newString += string.charAt(j);
        }
        return newString;
    }
    public static String xPronounce(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'x') {
                if (string.charAt(i - 1) == ' ' && (i == string.length() - 1 || string.charAt(i + 1) == ' ')) {
                    newString += "ecks";
                }
                else if (string.charAt(i - 1) == ' ') {
                    newString += "z";
                }
                else {
                    newString += "cks";
                }
            }
            else {
                newString += string.charAt(i);
            }
        }
        return newString;
    }
    public static int largestGap(int arr[]) {
        Arrays.sort(arr);
        int max = arr[1] - arr[0];
        for (int i = 2; i < arr.length - 2; i++) {
            if (arr[i+1] - arr[i] > max) {
                max = arr[i+1] - arr[i];
            }
        }
        return max;
    }
    public static int cod(int number) {
        char arr[] =  Integer.toString(number).toCharArray();
        Arrays.sort(arr);
        String num = "";
        for (int i = 0; i < arr.length; i++) {
            num += arr[i];
        }
        return number - Integer.parseInt(num);
    }
    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i'
        || ch == 'o' || ch == 'u' || ch == 'y') {
            return true;
        }
        return false;
    }
    public static String commonLastVowel(String string) {
        String lasts = "";
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            if (isVowel(string.charAt(i)) && (Character.isLetter(string.charAt(i)) && i + 1 == string.length() 
            || Character.isLetter(string.charAt(i)) && !Character.isLetter(string.charAt(i + 1)))) {
                lasts += string.charAt(i);
            }
        }
        String max = "" + lasts.charAt(0);
        int max_c = 0;
        int count = 0;
        for (int i = 0; i < lasts.length() - 1; i++) {
            count = 1;
            for (int j = i + 1; j < lasts.length(); j++) {
                if (lasts.charAt(i) == lasts.charAt(j)) count++;
            }
            if (count > max_c) {
                max_c = count;
                max = "" + lasts.charAt(i);
            }
        }
        return max;
    }
    public static int memeSum(int num1, int num2) {
        String sum = "";
        while (num1 > 0 || num2 > 0) {
            if (num1 <= 0) {
                sum = Integer.toString(num2 % 10) + sum;
            }
            else if (num2 <= 0) {
                sum = Integer.toString(num1 % 10) + sum;
            }
            else {
                sum = Integer.toString(num1 % 10 + num2 % 10) + sum;
            }
            num1 /= 10;
            num2 /= 10;
        }
        return Integer.parseInt(sum);
    }
    public static String unrepeated(String string){
        String newString = "";
        String temp = "";
        char ch;
        for (int j = 0; j < string.length(); j++) {
            ch = string.charAt(j);
            newString += ch;
            for (int i = j + 1; i < string.length(); i++) {
                if (string.charAt(i) != ch) {
                    newString += string.charAt(i);
                }
            }
            string = newString;
            temp += ch;
            newString = temp;
        }
        return string;
    }
}