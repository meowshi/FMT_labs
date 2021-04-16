import java.net.*;
import java.io.*;

public class Crawler {
    private final String protocol = "http://";

    private int depth;
    private int maxThreadsCount;
    private URLPool poolik;

    public Crawler(URLPool pool, int d, int n) {
        depth = d;
        maxThreadsCount = n;
        poolik = pool;
    }

    private void analys() {
        for (int i = 0; i < maxThreadsCount; i++) {
            Thread thread = new Thread(new CrawlerTask(poolik), "" + i);
            thread.start();
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

    private class CrawlerTask implements Runnable {
        private URLPool pool;

        public CrawlerTask(URLPool pool_) {
            pool = pool_;
        }
        
        @Override
        public void run() {
            while (true) {
                try {
                    URLDepthPair udp = pool.getUnchecked(maxThreadsCount);
                    URL url = new URL(udp.getURL());
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.contains("href=\"" + protocol) && udp.getDepth() + 1 <= depth) {
                            pool.addUncheked(new URLDepthPair(getURL(line), udp.getDepth() + 1));
                        }
                    }
                    pool.addChecked(udp);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } 
    }
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("args != 3");
            System.exit(1);
        }
        URLPool pool = new URLPool(new URLDepthPair(args[0], 0));
        try {
            Crawler crawler = new Crawler(pool, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            crawler.analys();
            while (pool.getWaiting() != crawler.maxThreadsCount);
            pool.showUDP();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
