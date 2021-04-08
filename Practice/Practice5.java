import java.util.*;

public class Practice5 {
    public static boolean sameLetterPattern(String string1, String string2) {
        String pattern1 = makePattern(string1);
        String pattern2 = makePattern(string2);
        return pattern1.equals(pattern2);
    }
    public static String makePattern(String string) {
        char pattern[] = new char[string.length()];
        pattern[0] = 'a';
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    pattern[i] = pattern[j];
                    break;
                }
                else if (j + 1 == i) {
                    pattern[i] = (char)((int)'a' + count);
                    count++;
                }
            }
        }
        String p = "";
        for (int i = 0; i < pattern.length; i++) {
            p += pattern[i];
        }
        return p;
    }
    public static String spiderVsFly(String pavuk, String muha) {
        char coordPavuk[] = pavuk.toCharArray();
        char coordMuha[] = muha.toCharArray();
        String path = "" + coordPavuk[0] + coordPavuk[1];
        if (Math.abs(coordPavuk[0] - coordMuha[0]) > 2 && Math.abs(coordPavuk[0] - coordMuha[0]) <= 5) {
            while (coordPavuk[1] != '0') {
                coordPavuk[1]--;
                if (coordPavuk[1] == '0') coordPavuk[0] = 'A';
                path += "-" + coordPavuk[0] + coordPavuk[1];
            }
            coordPavuk[0] = coordMuha[0];
            coordPavuk[1]++;
            path += "-" + coordPavuk[0] + coordPavuk[1];
            while(coordPavuk[1] != coordMuha[1]) {
                if (coordPavuk[1] < coordMuha[1]) coordPavuk[1]++;
                else if (coordPavuk[1] > coordMuha[1]) coordPavuk[1]++;
                path += "-" + coordPavuk[0] + coordPavuk[1];
            }
        }
        else {
            while (coordPavuk[1] != coordMuha[1]) {
                coordPavuk[1]--;
                if (coordPavuk[1] == '0') coordPavuk[0] = 'A';
                path += "-" + coordPavuk[0] + coordPavuk[1];
            }
            if (Math.abs(coordPavuk[0] - coordMuha[0]) > 5) {
                while (coordPavuk[0] != 'A') {
                    coordPavuk[0]--;
                    path += "-" + coordPavuk[0] + coordPavuk[1];
                }
                coordPavuk[0] = 'H';
                path += "-" + coordPavuk[0] + coordPavuk[1];
                while (coordPavuk[0] != coordMuha[0]) {
                    coordPavuk[0]--;
                    path += "-" + coordPavuk[0] + coordPavuk[1];
                }
            }
            else {
                if (coordPavuk[0] - coordMuha[0] > 0) {
                    while (coordPavuk[0] != coordMuha[0]) {
                        coordPavuk[0]--;
                        path += "-" + coordPavuk[0] + coordPavuk[1];
                    }
                }
                if (coordPavuk[0] - coordMuha[0] < 0) {
                    while (coordPavuk[0] != coordMuha[0]) {
                        coordPavuk[0]++;
                        path += "-" + coordPavuk[0] + coordPavuk[1];
                    }
                }
            }
        }
        return path;
    }
    public static int digitsCount(long number) {
        if ( number == 0L ) return 1;
        int count = 0;
        for (; number > 0; count++){
            number /= 10;
        }
        return count;
    }
    public static int totalPoints(String arr[], String word) {
        int rez = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isRight(arr[i], word)) {
                rez += (arr[i].length() - 2);
                if (arr[i].length() == 6) rez += 50;
            }
        }
        return rez;
    }
    public static boolean isRight(String arrItem, String word) {
        if (arrItem.length() > word.length()) return false; 
        ArrayList<Character> wordL = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordL.add(word.charAt(i));
        }
        int index;
        for (int i = 0; i < arrItem.length(); i++) {
            index = wordL.indexOf(arrItem.charAt(i));
            if (index != -1) wordL.remove(index);
            else return false;
        }
        return true;
    }
    public static int longestRun(int arr[]) {
        int count = 1;
        int max_count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i-1]) == 1) {
                count++;
            }
            else if ( max_count < count ) {
                max_count = count;
                count = 1;
            }
            else count = 1;
        }
        if ( max_count < count ) max_count = count;
        return max_count;
    }
    public static String takeDownAverage(String[] results) {
        // среднее значение оценок
        double mid = 0;
        double sum;
        // находим сумму оценок
        for ( int i = 0; i < results.length; i++ ) {
            mid += Integer.parseInt(results[i].substring(0, results[i].length() - 1));
        }
        sum = mid;
        // находим среднее
        mid /= results.length;
        // средний балл к которому мы стримимся
        double target = mid - 5;
        // наш балл
        int me = (int) ((results.length + 1) * target - sum);
        return me + "%";
    }
    public static String rearrange(String string) {
        String string_arr[] = string.split(" ");
        String rez = "";
        char now = ' ';
        for (int i = 0; i < string_arr.length; i++) {
            for (int j = 0; j < string_arr[i].length(); j++) {
                if (Character.isDigit(string_arr[i].charAt(j))) {
                    now = string_arr[i].charAt(j);
                    if ((int)(now - '0') - 1 == i) break;
                    String temp = string_arr[i];
                    string_arr[i] = string_arr[(int) (now - '0') - 1];
                    string_arr[(int) (now - '0') - 1] = temp;
                    i = -1;
                    break;
                }
            }
        }
        for (int i = 0; i < string_arr.length; i++) {
            for (int j = 0; j < string_arr[i].length(); j++) {
                if (!Character.isDigit(string_arr[i].charAt(j))) {
                    rez += string_arr[i].charAt(j);
                }
            }
            if (i != string_arr.length - 1) {
                rez += " ";
            }
        }
        return rez;
    }
    public static int maxPossible(int num1, int num2) {
        char num1S[] = Integer.toString(num1).toCharArray();
        char num2S[] = Integer.toString(num2).toCharArray();
        Arrays.sort(num2S);
        int start = num2S.length - 1;
        for (int i = 0; start >= 0 && i < num1S.length; i++) {
            for (int j = start; j >= 0; j--) {
                if (num1S[i] < num2S[j]) {
                    num1S[i] = num2S[j];
                    start--;
                    break;
                }
            }
        }
        String rez = "";
        for (int i = 0; i < num1S.length; i++) {
            rez += num1S[i];
        }
        return Integer.parseInt(rez);
    }
    static private class Date {
        private Integer year;
        private Integer mouth;
        private Integer day;
        private Integer hours;
        private Integer minutes;
        
        public Date(String date) {
            String dateArr[] = parseDate(date);
            mouth = choiceMouth(dateArr[0]);
            day = Integer.parseInt(dateArr[1]);
            year = Integer.parseInt(dateArr[2]);
            hours = Integer.parseInt(dateArr[3]);
            minutes = Integer.parseInt(dateArr[4]);
        }

        private String[] parseDate(String date) {
            String dateArr[] = new String[5];
            String dateElement = new String();
            int index = 0;
            for ( int i = 0; i < date.length(); i++ ) {
                if ( (date.charAt(i) == ' ' || date.charAt(i) == ',' || date.charAt(i) == ':') && date.charAt(i - 1) != ',') {
                    dateArr[index] = dateElement;
                    dateElement = "";
                    index++;
                }
                else {
                    if ( date.charAt(i) != ' ' )
                        dateElement += date.charAt(i);
                    if ( i == date.length() - 1 ) {
                        dateArr[index] = dateElement;
                    }
                }
            }
            return dateArr;
        }

        private int choiceMouth(String mouth) {
            switch (mouth) {
                case "January": return 1;
                case "February": return 2;
                case "March": return 3;
                case "April": return 4;
                case "May": return 5;
                case "June": return 6;
                case "July": return 7;
                case "August": return 8;
                case "September": return 9;
                case "October": return 10;
                case "November": return 11;
                case "December": return 12;
                default: return -1;
            }
        }

        public void addTime(String city1, String city2) {
            Integer minutesHours[] = timeDiff(city1, city2);
            if ( minutes + minutesHours[1] >= 60) {
                minutes = minutes + minutesHours[1] - 60;
                if (hours + 1 >= 24) {
                    hours = hours + 1 - 24;
                    if (day + 1 > daysInMouth(mouth)) {
                        day = 1;
                        if (mouth + 1 > 12) {
                            mouth = 1;
                            year++;
                        }
                        else mouth++;
                    }
                    else day++;
                }
            }
            else if ( minutes + minutesHours[1] < 0 ) {
                minutes = 60 + minutes + minutesHours[1];
                if (hours - 1 < 0 ) {
                    hours = 23;
                    if (day - 1 < 1) {
                        day = daysInMouth(mouth - 1);
                        if (mouth - 1 < 1) {
                            mouth = 12;
                            year--;
                        }
                        else mouth--;
                    }
                    else day--;
                }
            }
            else {
                minutes += minutesHours[1];
            }
            if (hours + minutesHours[0] >= 24) {
                hours = hours + minutesHours[0] - 24;
                if (day + 1 > daysInMouth(mouth)) {
                    day = 1;
                    if (mouth + 1 > 12) {
                        mouth = 1;
                        year++;
                    }
                    else mouth++;
                }
                else day++;
            }
            else if (hours + minutesHours[0] < 0 ) {
                hours = 24 + hours + minutesHours[0];
                if (day - 1 < 1) {
                    day = daysInMouth(mouth - 1);
                    if (mouth - 1 < 1) {
                        mouth = 12;
                        year--;
                    }
                    else mouth--;
                }
                else day--;
            }
            else {
                hours += minutesHours[0];
            }
        }

        private Integer[] timeDiff(String city1, String city2) {
            Integer hoursCity1, hoursCity2;
            Integer minutesCity1, minutesCity2;
            switch ( city1 ) {
                case "Los Angeles": hoursCity1 = -8; minutesCity1 = 0; break;
                case "New York": hoursCity1 = -5; minutesCity1 = 0; break;
                case "Caracas": hoursCity1 = -4; minutesCity1 = -30; break;
                case "Buenos Aires": hoursCity1 = -3; minutesCity1 = 0; break;
                case "London": hoursCity1 = 0; minutesCity1 = 0; break;
                case "Rome": hoursCity1 = 1; minutesCity1 = 0; break;
                case "Moscow": hoursCity1 = 3; minutesCity1 = 0; break;
                case "Tehran": hoursCity1 = 3; minutesCity1 = 30; break;
                case "New Delhi": hoursCity1 = 5; minutesCity1 = 30; break;
                case "Beijing": hoursCity1 = 8; minutesCity1 = 0; break;
                case "Canberra": hoursCity1 = 10; minutesCity1 = 0; break;
                default: hoursCity1 = 100; minutesCity1 = 100;
            }
            switch ( city2 ) {
                case "Los Angeles": hoursCity2 = -8; minutesCity2 = 0; break;
                case "New York": hoursCity2 = -5; minutesCity2 = 0; break;
                case "Caracas": hoursCity2 = -4; minutesCity2 = -30; break;
                case "Buenos Aires": hoursCity2 = -3; minutesCity2 = 0; break;
                case "London": hoursCity2 = 0; minutesCity2 = 0; break;
                case "Rome": hoursCity2 = 1; minutesCity2 = 0; break;
                case "Moscow": hoursCity2 = 3; minutesCity2 = 0; break;
                case "Tehran": hoursCity2 = 3; minutesCity2 = 30; break;
                case "New Delhi": hoursCity2 = 5; minutesCity2 = 30; break;
                case "Beijing": hoursCity2 = 8; minutesCity2 = 0; break;
                case "Canberra": hoursCity2 = 10; minutesCity2 = 0; break;
                default: hoursCity2 = 100; minutesCity2 = 100;
            }
            Integer minsHours[] = new Integer[2];
            minsHours[0] = hoursCity2 - hoursCity1;
            minsHours[1] = minutesCity2 - minutesCity1;
            return minsHours;
        }

        private int daysInMouth(int nowMouth) {
            if ( nowMouth == 0) nowMouth = 12;
            if ( nowMouth <= 7 ) {
                if ( nowMouth % 2 == 1 ) return 31;
                else if ( nowMouth == 2 ) {
                    if ( year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ) return 29;
                    else return 28;
                }
                else return 30;
            }
            else {
                if ( nowMouth % 2 == 0 ) return 31;
                else return 30;
            }
        }

        public String getDate() {
            return year + "-" + mouth + "-" + day + " " + (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes);
        }
    }
    public static String timeDifference(String city1, String date, String city2) {
        Date d = new Date(date);
        d.addTime(city1, city2);
        return d.getDate();
    }
    public static boolean isNew(int number) {
        String source = Integer.toString(number);
        char[] sorted = Integer.toString(number).toCharArray();
        int min = 0;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[min] == '0') min = i;
            else if (sorted[i] != '0' && sorted[min] > sorted[i]) min = i;
        }
        char temp = sorted[0];
        sorted[0] = sorted[min];
        sorted[min] = temp;
        int indexZeros = 1;
        for (int i = 2; i < sorted.length; i++) {
            if (sorted[i] == '0') {
                sorted[i] = sorted[indexZeros];
                sorted[indexZeros] = '0';
                indexZeros++;
            }
        }
        String sortedNum = "";
        for (int i = 0; i < sorted.length; i++) sortedNum += sorted[i];
        return source.equals(sortedNum);
    }
}
