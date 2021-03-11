// Класс третьей практической работы
public class Practice3 {
    public static int[] millionsRounding(int humans[]) {    
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] < 500000) humans[i] = 0;
            else if (humans[i] >= 500000 && humans[i] < 1000000) humans[i] = 1000000;
            else if (humans[i] / 100000 % 10 < 5) humans[i] = humans[i] / 1000000 * 1000000;
            else humans[i] = (humans[i] / 1000000 + 1) * 1000000;
        }
        return humans;
    }
    public static double[] otherSides(double side) {
        double otherSides[] = new double[2];
        otherSides[0] = side * 2;
        otherSides[1] = Math.sqrt(otherSides[0] * otherSides[0] - side * side);
        return otherSides;
    }
    public static String rps(String player1, String player2) {
        if (player1 == player2) return "TIE";
        else if (player1 == "rock" && player2 == "scissors" || player1 == "scissors" && player2 == "paper" || player1 == "paper" && player2 == "rock") {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }
    public static int warOfNumbers(int[] arr) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) sumEven += arr[i];
            else sumOdd += arr[i]; 
        }
        return Math.abs(sumEven - sumOdd);
    }
    public static String reverseCase(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') newString += ' ';
            else if ((int)string.charAt(i) < 97) {
                newString += (char)((int)string.charAt(i) + 32);
            }
            else {
                newString += (char)((int)string.charAt(i) - 32);
            }
        }
        return newString;
    }
    public static String inatorInator(String string) {
        char last = string.charAt(string.length() - 1);
        if (last == 'O' || last == 'o' || last == 'e' || last == 'E' || last == 'i' || last == 'I'
            || last == 'a' || last == 'A' || last == 'u' || last == 'U' || last == 'Y' || last == 'y') {
                string += "-inator" + " " + string.length() + "000";
        }
        else {
            string += "inator" + " " + string.length() + "000";
        }
        return string;
    }
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        if (a <= w && b <= h || b <= w && a <= h || a <= w && c <= h || c <= w && a <= w || b <= w && c <= h || c <= w && b <= h) {
            return true;
        }
        return false;
    }
    public static double totalDistance(double fuel, double fuelKm, int count, boolean kond) {
        double multi = fuelKm * (1 + 5 * (double)count / 100);
        if (kond) {
            multi = multi * 1.1;
        }
        return fuel / multi * 100;
    }
    public static double mean(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double)sum / arr.length;
    }
    public static boolean parityAnalysis(int number) {
        int sum = 0;
        for (int i = 1; number / i > 0; i *= 10) {
            sum += (number / i % 10);
        }
        if (sum % 2 == number % 2) return true;
        return false;
    }
}