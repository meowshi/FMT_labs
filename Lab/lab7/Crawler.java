import java.util.*;
import java.net.*;
import java.io.*;

public class Crawler {

    private LinkedList<URLDepthPair> checked = new LinkedList<>();
    private LinkedList<URLDepthPair> unchecked = new LinkedList<>();
    
    private final String protocol = "http://";

    private int depth;
    
    public Crawler(String url, int d) {
        depth = d;
        unchecked.add(new URLDepthPair(url, 0));
    }

    private void analys() {
        while (unchecked.size() > 0) {
            try {
                URLDepthPair udp = unchecked.pop();
                URL url = new URL(udp.getURL());
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(protocol) && udp.getDepth() + 1 <= depth) {
                        unchecked.add(new URLDepthPair(getURL(line), udp.getDepth() + 1));
                    }
                }
                checked.add(udp);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("args != 2");
            System.exit(1);
        }
        try {
            Crawler crawler = new Crawler(args[0], Integer.parseInt(args[1]));
            crawler.analys();
            crawler.showUDP();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
    public String getURL(String string) {
        StringBuilder newURL = new StringBuilder();
        int index = string.indexOf(protocol);
        for ( int i = index; string.charAt(i) != '\"'; i++ ) {
            newURL.append(string.charAt(i));
        }
        return newURL.toString();
    }

    public void showUDP() {
        for ( int i = 0; i < checked.size(); i++ ) {
            System.out.println(checked.get(i).toString());
        }
    }
}
