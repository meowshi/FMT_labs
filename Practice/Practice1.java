// Класс первой практической работы
public class Practice1{
    public static int convert(int minutes) {
        return minutes * 60;
    }
    public static int points(int score2, int score3) {
        return score2 * 2 + score3 * 3;
    }
    public static int footballPoints(int wins, int draws, int losses) {
        return wins * 3 + draws;
    }
    public static boolean divisibleByFive(int number) {
        return number % 5 == 0;
    }
    public static boolean and(boolean bool1, boolean bool2) {
        return bool1 && bool2;
    }
    public static int howManyWalls(int n, int w, int h) {
        return n / (w * h);
    }
    public static int squared(int a) {
        return a * a;
    }
    public static boolean profitableGamble(double prob, int prize, int pay) {
        return prob * prize > pay;
    }
    public static int frames(int fps, int minutes) {
        return fps * minutes * 60;
    }
    public static int mod(int a, int b) {
        return a - b * (a / b);
    }
}