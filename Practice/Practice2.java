// Класс второй практической работы
public class Practice2 {
    public static int oppositeHouse(int house, int n) {
        return 2 * n - house + 1;
    }
    public static String nameShuffle(String name) {
        String firstName = "";
        String lastName = "";
        int i;
        for(i = 0; name.charAt(i) != ' '; i++) {
            firstName += name.charAt(i);
        }
        for(i++ ; i < name.length(); i++) {
            lastName += name.charAt(i);
        }
        return lastName + " " + firstName;
    }
    public static double discount(int price, int sale) {
        return price * (1 - (double) sale / 100);
    }
    public static int differenceMaxMin(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            else if (min > arr[i]) {
                min = arr[i];
            }
        }
        return max - min;
    }
    public static int equal(int a, int b, int c) {
        int count = 0;
        if (a == b) {
            if (count == 0) count += 2;
            else if (count < 3) count++;
        }
        if (a == c) {
            if (count == 0) count += 2;
            else if (count < 3) count++;
        }
        if (b == c) {
            if (count == 0) count += 2;
            else if (count < 3) count++;
        }
        return count;
    }
    public static String reverse(String string) {
        String reverseString = "";
        for (int i = string.length() - 1; i > -1; i--) {
            reverseString += string.charAt(i);
        }
        return reverseString;
    }
    public static int programmers(int zp1, int zp2, int zp3) {
        int max = zp1;
        int min = zp1;
        if (zp2 > max) max = zp2;
        if (zp3 > max) max = zp3;
        if (zp2 < min) min = zp2;
        if (zp3 < min) min = zp3;
        return max - min;
    }
    public static boolean getXO(String string) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'X' || string.charAt(i) == 'x') {
                countX += 1;
            }
            else if (string.charAt(i) == 'O' || string.charAt(i) == 'o'){
                countO += 1;
            }
        }
        return countX == countO;
    }
    public static String bomb(String string) {
        for (int i = 0; i < string.length() - 4; i++) {
            if ((string.charAt(i) == 'b' || string.charAt(i) == 'B') && (string.charAt(i+1) == 'o' || string.charAt(i+1) == 'O') 
                && (string.charAt(i+2) == 'm' || string.charAt(i+2) == 'M') && (string.charAt(i+3) == 'b' || string.charAt(i+3) == 'B')) {
                return "DUCK!";
            }
        }
        return "Relax, there's no bomb.";
    }
    public static boolean sameAscii(String word1, String word2) {
        int sumWord1 = 0;
        int sumWord2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            sumWord1 += (int)word1.charAt(i);
        }
        for (int i = 0; i < word2.length(); i++) {
            sumWord2 += (int)word2.charAt(i);
        }
        return sumWord1 == sumWord2;
    }
}