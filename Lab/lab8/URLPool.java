import java.util.*;

class URLPool {
    private LinkedList<URLDepthPair> checked;
    private LinkedList<URLDepthPair> unchecked;
    private int waiting;

    public URLPool(URLDepthPair udp) {
        checked = new LinkedList<>();
        unchecked = new LinkedList<>();
        unchecked.add(udp);
        waiting = 0;
    }

    public synchronized void addUncheked(URLDepthPair udp) {
        if (!checked.contains(udp) && !unchecked.contains(udp)) {
            unchecked.add(udp);
            notify();
        }
    }
    
    public synchronized void addChecked(URLDepthPair udp) {
        if (!checked.contains(udp)) {
            checked.add(udp);
        }
    }

    public synchronized URLDepthPair getUnchecked(int max) {
        if (unchecked.size() == 0) {
            waiting++;
            try {
                if (waiting == max) {
                    showUDP();
                    System.exit(0);
                }
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            waiting--;
        }
        return unchecked.pop();
    }

    public int getWaiting() {
        return waiting;
    }

    public void showUDP() {
        for ( int i = 0; i < checked.size(); i++ ) {
            System.out.println(checked.get(i).toString());
        }
    }
}