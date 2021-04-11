import java.util.*;
import java.net.*;
import java.io.*;

public class Crawler {

    private LinkedList<URLDepthPair> checked = new LinkedList<>();
    private LinkedList<URLDepthPair> unchecked = new LinkedList<>();
    
    private final String protocol = "http://";

    private int depth;
    private int maxThreadsCount;
    
    public Crawler(String url, int d, int n) {
        depth = d;
        unchecked.add(new URLDepthPair(url, 0));
        maxThreadsCount = n;
    }

    private void analys() {
        while (Thread.activeCount() > 1 || unchecked.size() > 0)
            if (unchecked.size() > 0 && Thread.activeCount() <= maxThreadsCount) {
                CrawlerTask thread = new CrawlerTask();
                thread.run();
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

    private class CrawlerTask implements Runnable {
        @Override
        public void run() {
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
        if (args.length != 3) {
            System.out.println("args != 3");
            System.exit(1);
        }
        try {
            Crawler crawler = new Crawler(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            crawler.analys();
            crawler.showUDP();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
